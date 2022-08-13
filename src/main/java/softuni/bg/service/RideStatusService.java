package softuni.bg.service;

import org.springframework.stereotype.Service;
import softuni.bg.model.entity.RidesStatusEntity;
import softuni.bg.model.enums.RequestEnum;
import softuni.bg.repository.RidesStatusRepository;

@Service
public class RideStatusService {

    private final RidesStatusRepository ridesStatusRepository;

    public RideStatusService(RidesStatusRepository ridesStatusRepository) {
        this.ridesStatusRepository = ridesStatusRepository;

    }

    public void approveRide(Long id) {
        RidesStatusEntity ridesStatus = this.ridesStatusRepository.getById(id);
        ridesStatus.setApproveRide(true);
        RequestEnum reason = RequestEnum.YES;
        ridesStatus.setReason(reason);
        this.ridesStatusRepository.save(ridesStatus);
    }

    public void rejectRide(Long id) {
        RidesStatusEntity ridesStatus = this.ridesStatusRepository.getById(id);
        RequestEnum reason = RequestEnum.NO;
        ridesStatus.setReason(reason);
        this.ridesStatusRepository.save(ridesStatus);
    }
}
