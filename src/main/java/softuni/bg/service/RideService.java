package softuni.bg.service;

import org.springframework.stereotype.Service;
import softuni.bg.model.dto.PublishRideDto;
import softuni.bg.repository.RideRepository;

@Service
public class RideService {
    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }


    public void saveRide(PublishRideDto publishRideModel) {

    }
}
