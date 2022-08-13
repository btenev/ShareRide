package softuni.bg.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.bg.model.enums.SeatEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsiderRideDto {
    private Long id;
    private Long passengerId;
    private Long rideId;
    private String departure;
    private String arrival;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String passengerFirstname;
    private String passengerLastname;

    private SeatEnum numberOfSeats;

    public ConsiderRideDto() {
    }

    public Long getId() {
        return id;
    }

    public ConsiderRideDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public ConsiderRideDto setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public Long getRideId() {
        return rideId;
    }

    public ConsiderRideDto setRideId(Long rideId) {
        this.rideId = rideId;
        return this;
    }

    public String getDeparture() {
        return departure;
    }

    public ConsiderRideDto setDeparture(String departure) {
        this.departure = departure;
        return this;
    }

    public String getArrival() {
        return arrival;
    }

    public ConsiderRideDto setArrival(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public ConsiderRideDto setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public ConsiderRideDto setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public String getPassengerFirstname() {
        return passengerFirstname;
    }

    public ConsiderRideDto setPassengerFirstname(String passengerFirstname) {
        this.passengerFirstname = passengerFirstname;
        return this;
    }

    public String getPassengerLastname() {
        return passengerLastname;
    }

    public ConsiderRideDto setPassengerLastname(String passengerLastname) {
        this.passengerLastname = passengerLastname;
        return this;
    }


    public SeatEnum getNumberOfSeats() {
        return numberOfSeats;
    }

    public ConsiderRideDto setNumberOfSeats(SeatEnum numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }
}
