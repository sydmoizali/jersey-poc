package ae.jersey.poc.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by syedm on 12/12/2022.
 */
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity {

    @Column(name = "VERSION")
    protected Integer version;

    @Column(name = "ACTIVE_IND")
    protected Boolean activeIndicator;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATETIME")
    protected Date createDateTime;

    @Column(name = "CREATED_BY")
    protected String createdBy;

    public BaseEntity() {
        if(this.version == null)
            this.version = 1;
        if(this.activeIndicator == null)
            this.activeIndicator = Boolean.TRUE;
        if(this.createDateTime == null)
            this.createDateTime = new Date();
        if(this.createdBy == null)
            this.createdBy = "Guest";
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(Boolean activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
