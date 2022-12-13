package ae.jersey.poc.api.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by syedm on 13/12/2022.
 */
@XmlRootElement
public class CurrencyData {

    private List<Currency> data;

    public CurrencyData() {
    }

    public CurrencyData(List<Currency> data) {
        this.data = data;
    }

    public List<Currency> getData() {
        return data;
    }

    public void setData(List<Currency> data) {
        this.data = data;
    }
}
