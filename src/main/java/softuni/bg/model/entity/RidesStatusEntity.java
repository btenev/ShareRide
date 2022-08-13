package softuni.bg.model.entity;

import softuni.bg.model.enums.RequestEnum;

import javax.persistence.*;

@Entity
@Table(name = "rides_status")
public class RidesStatusEntity extends BaseEntity {
    @Column(nullable = false)
    private Long passengerId;

    private boolean joinRide;

    private boolean approveRide;

    @Enumerated(EnumType.STRING)
    private RequestEnum reason;

    public RidesStatusEntity() {
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public RidesStatusEntity setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public boolean isJoinRide() {
        return joinRide;
    }

    public RidesStatusEntity setJoinRide(boolean joinRide) {
        this.joinRide = joinRide;
        return this;
    }

    public boolean isApproveRide() {
        return approveRide;
    }

    public RidesStatusEntity setApproveRide(boolean approveRide) {
        this.approveRide = approveRide;
        return this;
    }

    public RequestEnum getReason() {
        return reason;
    }

    public RidesStatusEntity setReason(RequestEnum reason) {
        this.reason = reason;
        return this;
    }
}

