package softuni.bg.model.dto;

import softuni.bg.model.entity.CarEntity;
import softuni.bg.model.enums.BaggageEnum;
import softuni.bg.model.enums.SeatEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class RideDetailsDto {

    private Long id;

    private String departure;

    private String arrival;

    private LocalDate departureDate;

    private LocalTime departureTime;

    private SeatEnum numberOfSeats;

    private BaggageEnum baggageQuantity;

    private BigDecimal price;

    private String tripInformation;

    private CarDto car;

    private UserDetailsDto driver;

    private List<UserDetailsDto> passengers;
    public RideDetailsDto() {

    }

    public Long getId() {
        return id;
    }

    public RideDetailsDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDeparture() {
        return departure;
    }

    public RideDetailsDto setDeparture(String departure) {
        this.departure = departure;
        return this;
    }

    public String getArrival() {
        return arrival;
    }

    public RideDetailsDto setArrival(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public RideDetailsDto setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public RideDetailsDto setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public SeatEnum getNumberOfSeats() {
        return numberOfSeats;
    }

    public RideDetailsDto setNumberOfSeats(SeatEnum numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public BaggageEnum getBaggageQuantity() {
        return baggageQuantity;
    }

    public RideDetailsDto setBaggageQuantity(BaggageEnum baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RideDetailsDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTripInformation() {
        return tripInformation;
    }

    public RideDetailsDto setTripInformation(String tripInformation) {
        this.tripInformation = tripInformation;
        return this;
    }

    public CarDto getCar() {
        return car;
    }

    public RideDetailsDto setCar(CarDto car) {
        this.car = car;
        return this;
    }

    public UserDetailsDto getDriver() {
        return driver;
    }

    public RideDetailsDto setDriver(UserDetailsDto driver) {
        this.driver = driver;
        return this;
    }

    public List<UserDetailsDto> getPassengers() {
        return passengers;
    }

    public RideDetailsDto setPassengers(List<UserDetailsDto> passengers) {
        this.passengers = passengers;
        return this;
    }
}
