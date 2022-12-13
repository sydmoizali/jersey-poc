package ae.jersey.poc.models;

import javax.persistence.*;

/**
 * Created by syedm on 12/12/2022.
 */
@Entity
@Table(name = "VEHICLE")
public class Vehicle extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "VEHICLE_ID")
    private Long vehicleId;

    @Column(name = "EMIRATE")
    private String emirate;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "CHASSIS")
    private String chassis;

    @Column(name = "MAKE")
    private String make;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "YEAR")
    private String year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    public Vehicle() {
    }

    public Vehicle(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getEmirate() {
        return emirate;
    }

    public void setEmirate(String emirate) {
        this.emirate = emirate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
