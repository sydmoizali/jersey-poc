package ae.jersey.poc.resources;

import ae.jersey.poc.models.Vehicle;
import ae.jersey.poc.services.VehicleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Path("/vehicles")
public class VehicleResource {

    @Inject
    private VehicleService vehicleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getVehicles(@QueryParam("param") String param) {
        return vehicleService.getVehiclesByParam(param);
    }

    @GET
    @Path("/{vehicleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle getVehicle(@PathParam("vehicleId") Long vehicleId) {
        return vehicleService.getVehicleById(vehicleId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle postVehicle(Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @DELETE
    @Path("/{vehicleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteVehicle(@PathParam("vehicleId") Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
    }
}
