package ae.jersey.poc.api.client;

import ae.jersey.poc.api.dto.Nationality;
import ae.jersey.poc.api.dto.NationalityData;
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
public class NationalityRestClient {

    private static final String API_ENDPOINT = "https://api.nationalize.io/";

    private NationalityRestClient() {
    }

    private static Invocation.Builder initializeService(String licenseNo) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(UriBuilder.fromUri(API_ENDPOINT).queryParam("licenseNo", licenseNo).build());
        return target.request().accept(MediaType.APPLICATION_JSON);
    }

    public static List<Nationality> getNationalities(String licenseNo) {
        try {
            NationalityData nationalityData = initializeService(licenseNo).get(NationalityData.class);
            if(nationalityData != null && nationalityData.getCountry() != null) {
                return nationalityData.getCountry();
            }
        } catch(Exception e) {
            // To Log
        }
        return Collections.emptyList();
    }
}
