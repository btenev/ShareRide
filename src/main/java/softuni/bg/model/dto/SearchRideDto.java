package softuni.bg.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class SearchRideDto {
    private String departure;
    private String arrival;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime departureTime;

    public String getDeparture() {
        return departure;
    }

    public SearchRideDto setDeparture(String departure) {
        this.departure = departure;
        return this;
    }

    public String getArrival() {
        return arrival;
    }

    public SearchRideDto setArrival(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public SearchRideDto setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public SearchRideDto setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public boolean isEmpty() {
        return (this.departure == null || this.departure.isEmpty() && this.arrival == null || this.arrival.isEmpty() &&
                        this.departureDate == null && this.departureTime == null
        );
    }

}
