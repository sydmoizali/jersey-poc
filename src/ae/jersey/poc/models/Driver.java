package ae.jersey.poc.models;

import ae.jersey.poc.api.dto.Nationality;

import javax.persistence.*;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Entity
@Table(name = "DRIVER")
public class Driver extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "DRIVER_ID")
    private Long driverId;

    @Column(name = "LICENSE_NO")
    private String licenseNo;

    @Column(name = "LICENSE_SOURCE")
    private String licenseSource;

    @Transient
    private List<Nationality> nationalities;

    public Driver() {
    }

    public Driver(Long driverId) {
        this.driverId = driverId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getLicenseSource() {
        return licenseSource;
    }

    public void setLicenseSource(String licenseSource) {
        this.licenseSource = licenseSource;
    }

    public List<Nationality> getNationalities() {
        return nationalities;
    }

    public void setNationalities(List<Nationality> nationalities) {
        this.nationalities = nationalities;
    }
}
