package softuni.bg.service.scheduler;

import org.springframework.stereotype.Component;
import softuni.bg.repository.RideRepository;

@Component
public class ArchiveRidesScheduler {

    public final RideRepository rideRepository;

    public ArchiveRidesScheduler(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public void archiveRides () {

    }
}
