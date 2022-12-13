package ae.jersey.poc.api.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by syedm on 13/12/2022.
 */
@XmlRootElement
public class NationalityData {

    private List<Nationality> country;
    private String name;

    public NationalityData() {
    }

    public NationalityData(List<Nationality> country, String name) {
        this.country = country;
        this.name = name;
    }

    public List<Nationality> getCountry() {
        return country;
    }

    public void setCountry(List<Nationality> country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
