package softuni.bg.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import softuni.bg.model.dto.PublishRideDto;
import softuni.bg.model.dto.RideDetailsDto;
import softuni.bg.model.dto.SearchRideDto;
import softuni.bg.model.entity.RideEntity;
import softuni.bg.model.entity.UserEntity;
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
}
