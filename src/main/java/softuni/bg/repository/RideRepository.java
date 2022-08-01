package softuni.bg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.model.entity.RideEntity;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, Long> {
}
