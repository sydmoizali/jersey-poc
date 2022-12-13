package ae.jersey.poc.api.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by syedm on 13/12/2022.
 */
public class Currency {

    private String id;
    private String name;
    private String min_size;

    public Currency() {
    }

    public Currency(String id, String name, String min_size) {
        this.id = id;
        this.name = name;
        this.min_size = min_size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMin_size() {
        return min_size;
    }

    public void setMin_size(String min_size) {
        this.min_size = min_size;
    }
}
