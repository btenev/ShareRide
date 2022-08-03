package softuni.bg.model.entity;

import softuni.bg.model.enums.BaggageEnum;
import softuni.bg.model.enums.SeatEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "rides")
public class RideEntity extends BaseEntity {

    @Column(nullable = false)
    private String departure;

    @Column(nullable = false)
    private String arrival;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;

    @Column(name = "number_of_seats", nullable = false)
    @Enumerated(EnumType.STRING)
    private SeatEnum numberOfSeats;

    @Column(name = "baggage_quantity", nullable = false)
    @Enumerated(EnumType.STRING)
    private BaggageEnum baggageQuantity;


    private BigDecimal price;

    @Column(name = "trip_information", columnDefinition = "TEXT")
    private String tripInformation;

    @ManyToOne
    private RoleEntity driver;

    @ManyToOne
    private CarEntity car;

    public RideEntity() {
    }

    public String getDeparture() {
        return departure;
    }

    public RideEntity setDeparture(String departure) {
        this.departure = departure;
        return this;
    }

    public String getArrival() {
        return arrival;
    }

    public RideEntity setArrival(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public RideEntity setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public RideEntity setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public SeatEnum getNumberOfSeats() {
        return numberOfSeats;
    }

    public RideEntity setNumberOfSeats(SeatEnum numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public BaggageEnum getBaggageQuantity() {
        return baggageQuantity;
    }

    public RideEntity setBaggageQuantity(BaggageEnum baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RideEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTripInformation() {
        return tripInformation;
    }

    public RideEntity setTripInformation(String tripInformation) {
        this.tripInformation = tripInformation;
        return this;
    }

    public RoleEntity getDriver() {
        return driver;
    }

    public RideEntity setDriver(RoleEntity driver) {
        this.driver = driver;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public RideEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }


}
