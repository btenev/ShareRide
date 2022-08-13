package softuni.bg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.model.entity.RidesStatusEntity;

@Repository
public interface RidesStatusRepository extends JpaRepository<RidesStatusEntity, Long> {
}
