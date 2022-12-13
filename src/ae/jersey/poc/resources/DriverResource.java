package ae.jersey.poc.resources;

import ae.jersey.poc.models.Driver;
import ae.jersey.poc.services.DriverService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Path("/drivers")
public class DriverResource {

    @Inject
    private DriverService driverService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Driver> getDrivers(@QueryParam("param") String param) {
        return driverService.getDriversByParam(param);
    }

    @GET
    @Path("/{driverId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Driver getDriver(@PathParam("driverId") Long driverId) {
        return driverService.getDriverById(driverId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Driver postDriver(Driver driver) {
        return driverService.saveDriver(driver);
    }

    @DELETE
    @Path("/{driverId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDriver(@PathParam("driverId") Long driverId) {
        driverService.deleteDriver(driverId);
    }
}
