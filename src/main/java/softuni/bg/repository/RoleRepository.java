package softuni.bg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.model.entity.RoleEntity;
import softuni.bg.model.enums.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByUserRole(RoleEnum userRole);
}
