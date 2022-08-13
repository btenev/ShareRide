package softuni.bg.service;

import org.springframework.stereotype.Service;
import softuni.bg.model.dto.DataDto;
import softuni.bg.repository.RideRepository;
import softuni.bg.repository.UserRepository;

@Service
public class DataService {
    private final RideRepository rideRepository;
    private final UserRepository userRepository;

    public DataService(RideRepository rideRepository, UserRepository userRepository) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
    }

    public DataDto getData () {
        return new DataDto()
                .setPublishedRides(getRideCount().toString())
                .setRegisteredUsers(getUserCount().toString());
    }


    private Long getRideCount() {
        return this.rideRepository.count();
    }

    private Long getUserCount() {
        return this.userRepository.count();
    }
}
