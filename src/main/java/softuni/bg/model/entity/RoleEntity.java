package softuni.bg.model.entity;

import softuni.bg.model.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum userRole;

    public RoleEntity() {
    }

    public RoleEnum getUserRole() {
        return userRole;
    }

    public RoleEntity setUserRole(RoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
