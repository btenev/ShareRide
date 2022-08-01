package softuni.bg.model.dto;

import javax.validation.constraints.NotBlank;

public class CarDto {
    @NotBlank(message = "Please, enter the brand of the ride vehicle!")
    private String brand;
    @NotBlank(message = "Please, enter the model of the ride vehicle!")
    private String model;
    @NotBlank(message = "Please, enter the color of the ride vehicle!")
    private String color;
    @NotBlank(message = "Please, enter the license plate of the ride vehicle!")
    private String licensePlate;

    public CarDto() {
    }

    public String getBrand() {
        return brand;
    }

    public CarDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CarDto setColor(String color) {
        this.color = color;
        return this;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public CarDto setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }
}
