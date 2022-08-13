package softuni.bg.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import softuni.bg.model.dto.*;
import softuni.bg.model.entity.RideEntity;
import softuni.bg.model.entity.RidesStatusEntity;
import softuni.bg.model.entity.UserEntity;
import softuni.bg.model.enums.SeatEnum;
import softuni.bg.model.mapper.RideMapper;
import softuni.bg.repository.RideRepository;
import softuni.bg.repository.RideSpecification;
import softuni.bg.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RideService {
    private final RideRepository rideRepository;
    private final UserRepository userRepository;
    private final RideMapper rideMapper;

    public RideService(RideRepository rideRepository, UserRepository userRepository, RideMapper rideMapper) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
        this.rideMapper = rideMapper;
    }

    public void saveRide(PublishRideDto publishRideDto, UserDetails userDetails) {
        RideEntity newRide = this.rideMapper.publishRideDtoToRideEntity(publishRideDto);

        Optional<UserEntity> currentUser = this.userRepository.findByEmail(userDetails.getUsername());

        newRide.setDriver(currentUser.get());

        this.rideRepository.save(newRide);

    }

    public List<RideDetailsDto> searchRide(SearchRideDto searchRideDto) {
        return this.rideRepository
                .findAll((new RideSpecification(searchRideDto)))
                .stream()
                .map(this.rideMapper::rideEntityToRideDetailsDto)
                .toList();

    }

    public RideDetailsDto getRide(Long rideId) {
        RideEntity rideDetails = rideRepository.getById(rideId);

        return this.rideMapper
                .rideEntityToRideDetailsDto(rideDetails);
    }

    public void requestToJoinRide(Long rideId, UserDetails userDetails) {
        RideEntity rideToJoin = this.rideRepository.getById(rideId);
        Optional<UserEntity> user = this.userRepository.findByEmail(userDetails.getUsername());

        RidesStatusEntity newRideRequest = new RidesStatusEntity();

        newRideRequest.setPassengerId(user.get().getId());
        newRideRequest.setJoinRide(true);

        rideToJoin.addRidesStatus(newRideRequest);

        this.rideRepository.save(rideToJoin);
    }

    public List<ConsiderRideDto> considerRideRequest(UserDetails userDetails) {
        Optional<UserEntity> user = this.userRepository.findByEmail(userDetails.getUsername());


        return this.rideRepository
                .findRideStatusByDriverId(user.get().getId())
                .stream()
                .map(requestRideDto -> {

                    UserEntity passenger
                            = this.userRepository
                            .getById(requestRideDto.getPassengerId());

                    String firstName = passenger.getFirstName();
                    String lastName = passenger.getLastName();

                    return map(requestRideDto, firstName, lastName);
                })
                .toList();
    }

    private ConsiderRideDto map(RequestRideDto requestRideDto, String firstName, String lastName) {
        return new ConsiderRideDto()
                .setId(requestRideDto.getId())
                .setPassengerId(requestRideDto.getPassengerId())
                .setRideId(requestRideDto.getRideId())
                .setDeparture(requestRideDto.getDeparture())
                .setArrival(requestRideDto.getArrival())
                .setDepartureDate(requestRideDto.getDepartureDate())
                .setDepartureTime(requestRideDto.getDepartureTime())
                .setNumberOfSeats(requestRideDto.getSeats())
                .setPassengerFirstname(firstName)
                .setPassengerLastname(lastName);
    }

    public boolean addPassengerToRide(Long rideId, Long passengerId) {
        RideEntity ride = this.rideRepository.getById(rideId);

        int freeSeats = ride.getNumberOfSeats().getValue();

        if (freeSeats - 1 >= 0) {
            UserEntity passenger = this.userRepository.getById(passengerId);
            ride.addPassenger(passenger);

            String newValue = ride.getNumberOfSeats().newValue(freeSeats - 1);
            SeatEnum newEnum = SeatEnum.valueOf(newValue);
            ride.setNumberOfSeats(newEnum);

            this.rideRepository.save(ride);

            return true;
        }

        return false;
    }

    public List<RideDetailsDto> findMyRidesByUsername(String username) {
        Optional<UserEntity> byEmail = this.userRepository.findByEmail(username);

        Long driverId = byEmail.get().getId();

        return this.rideRepository
                .findAllByDriver_Id(driverId)
                .stream()
                .map(this.rideMapper::rideEntityToRideDetailsDto)
                .toList();
    }
}
