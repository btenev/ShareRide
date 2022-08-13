package softuni.bg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.model.dto.RequestRideDto;
import softuni.bg.model.entity.RideEntity;
import softuni.bg.model.entity.RidesStatusEntity;

import java.util.List;

@Repository
public interface RideRepository extends
        JpaRepository<RideEntity, Long>,
        JpaSpecificationExecutor<RideEntity> {


    @Query("SELECT new softuni.bg.model.dto.RequestRideDto(rq.id, rq.passengerId, r.id, r.departure, r.arrival, r.departureDate, r.departureTime, r.numberOfSeats)" +
            "  FROM RideEntity r JOIN r.requests rq  WHERE r.driver.id = :driverId and rq.joinRide = true and rq.approveRide = false")
    List<RequestRideDto> findRideStatusByDriverId(Long driverId);

    List<RideEntity> findAllByDriver_Id(Long driverId);

/*      @Query("SELECT rq  FROM RideEntity r JOIN r.requests rq  WHERE r.driver.id = :driverId")
      List<RidesStatusEntity>  findRideStatusByDriverId(Long driverId); */

}
