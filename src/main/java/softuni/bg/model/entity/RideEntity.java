package softuni.bg.model.entity;

import softuni.bg.model.enums.BaggageEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "rides")
public class RideEntity extends BaseEntity {

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;

    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;

    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;

    @Column(name = "baggage_quantity", nullable = false)
    @Enumerated(EnumType.STRING)
    private BaggageEnum baggageQuantity;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "trip_information", columnDefinition = "TEXT")
    private String tripInformation;

    @ManyToOne(optional = false)
    private UserEntity driver;

    @ManyToOne(optional = false)
    private CarEntity car;

    public RideEntity() {
    }


}
