package ae.jersey.poc;

import ae.jersey.poc.config.ApplicationBinder;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by syedm on 13/12/2022.
 */
public class Application extends ResourceConfig {

    public Application() {
        register(new ApplicationBinder());
        packages(true, "ae.jersey.poc.resources");
    }
}
