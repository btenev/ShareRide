package softuni.bg.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class AddressDto {
    @NotBlank(message = "Please enter your country!")
    private String country;

    @NotBlank(message = "Please enter your city!")
    private String city;

    @NotBlank(message = "Please enter your postal code!")
    private String postalCode;

    @NotBlank(message = "Please enter your street!")
    private String street;

    public AddressDto() {
    }

    public String getCountry() {
        return country;
    }

    public AddressDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressDto setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }
}
