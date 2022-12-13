package ae.jersey.poc.models;

import ae.jersey.poc.api.dto.Currency;

import javax.persistence.*;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Entity
@Table(name = "FINE")
public class Fine extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "FINE_ID")
    private Long fineId;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "AMOUNT")
    private String amount;

    @Column(name = "DESC_EN")
    private String descEn;

    @Column(name = "DESC_AR")
    private String descAr;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @Transient
    private List<Currency> currencies;

    public Fine() {
    }

    public Fine(Long fineId) {
        this.fineId = fineId;
    }

    public Long getFineId() {
        return fineId;
    }

    public void setFineId(Long fineId) {
        this.fineId = fineId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
    }

    public String getDescAr() {
        return descAr;
    }

    public void setDescAr(String descAr) {
        this.descAr = descAr;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
