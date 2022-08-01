package softuni.bg.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.bg.model.enums.BaggageEnum;
import softuni.bg.model.enums.SeatEnum;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class PublishRideDto {

    @NotBlank(message = "Please, enter your departure location!")
    private String departure;

    @NotBlank(message = "Please, enter your arrival location!")
    private String arrival;

    @NotNull(message = "Please, enter your departure date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date can not be in the past!")
    private LocalDate departureDate;

    @NotNull(message = "Please, enter departure time!")
    @Future(message = "Time of departure can not be now or in the past!")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime departureTime;

    @NotNull(message = "Please, select the number of available seats!")
    private SeatEnum numberOfSeats;

    @NotNull(message = "Please, select the size of the allowed luggage!")
    private BaggageEnum baggageQuantity;

    private BigDecimal price;

    private String tripInformation;

    @Valid
    private CarDto car;

    public PublishRideDto() {
    }

    public String getDeparture() {
        return departure;
    }

    public PublishRideDto setDeparture(String departure) {
        this.departure = departure;
        return this;
    }

    public String getArrival() {
        return arrival;
    }

    public PublishRideDto setArrival(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public PublishRideDto setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public PublishRideDto setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public SeatEnum getNumberOfSeats() {
        return numberOfSeats;
    }

    public PublishRideDto setNumberOfSeats(SeatEnum numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public BaggageEnum getBaggageQuantity() {
        return baggageQuantity;
    }

    public PublishRideDto setBaggageQuantity(BaggageEnum baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PublishRideDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTripInformation() {
        return tripInformation;
    }

    public PublishRideDto setTripInformation(String tripInformation) {
        this.tripInformation = tripInformation;
        return this;
    }

    public CarDto getCar() {
        return car;
    }

    public PublishRideDto setCar(CarDto car) {
        this.car = car;
        return this;
    }


}
