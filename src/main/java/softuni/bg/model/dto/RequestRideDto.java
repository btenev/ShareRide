package softuni.bg.model.dto;

import softuni.bg.model.enums.SeatEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class RequestRideDto {
    private Long id;
    private Long passengerId;
    private Long rideId;
    private String departure;
    private String arrival;
    private LocalDate departureDate;
    private LocalTime departureTime;

    private SeatEnum seats;

    public RequestRideDto(Long id, Long passengerId, Long rideId, String departure, String arrival, LocalDate departureDate, LocalTime departureTime, SeatEnum seats) {
        this.id = id;
        this.passengerId = passengerId;
        this.rideId = rideId;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.seats = seats;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public RequestRideDto setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RequestRideDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getRideId() {
        return rideId;
    }

    public RequestRideDto setRideId(Long rideId) {
        this.rideId = rideId;
        return this;
    }

    public String getDeparture() {
        return departure;
    }

    public RequestRideDto setDeparture(String departure) {
        this.departure = departure;
        return this;
    }

    public String getArrival() {
        return arrival;
    }

    public RequestRideDto setArrival(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public RequestRideDto setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public RequestRideDto setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public SeatEnum getSeats() {
        return seats;
    }

    public RequestRideDto setSeats(SeatEnum seats) {
        this.seats = seats;
        return this;
    }
}
