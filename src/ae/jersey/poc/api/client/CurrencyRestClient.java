package ae.jersey.poc.api.client;

import ae.jersey.poc.api.dto.Currency;
import ae.jersey.poc.api.dto.CurrencyData;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Collections;
import java.util.List;

/**
 * Created by syedm on 13/12/2022.
 */
public class CurrencyRestClient {

    private static final String API_ENDPOINT = "https://api.coinbase.com/v2/currencies";

    private CurrencyRestClient() {
    }

    private static Invocation.Builder initializeService() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(UriBuilder.fromUri(API_ENDPOINT).build());
        return target.request().accept(MediaType.APPLICATION_JSON);
    }

    public static List<Currency> getCurrencies() {
        try {
            CurrencyData currencyData = initializeService().get(CurrencyData.class);
            if(currencyData != null && currencyData.getData() != null) {
                return currencyData.getData();
            }
        } catch(Exception e) {
            // To Log
        }
        return Collections.emptyList();
    }
}
