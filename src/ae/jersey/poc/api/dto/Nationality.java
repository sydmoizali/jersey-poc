package ae.jersey.poc.api.dto;

/**
 * Created by syedm on 13/12/2022.
 */
public class Nationality {

    private String country_id;
    private String probability;

    public Nationality() {
    }

    public Nationality(String country_id, String probability) {
        this.country_id = country_id;
        this.probability = probability;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }
}
