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
}
