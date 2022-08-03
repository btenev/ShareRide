package softuni.bg.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity {
    private String brand;
    private String model;
    private String color;
    private String licensePlate;

    public CarEntity() {
    }

    public String getBrand() {
        return brand;
    }

    public CarEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CarEntity setColor(String color) {
        this.color = color;
        return this;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public CarEntity setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

}
