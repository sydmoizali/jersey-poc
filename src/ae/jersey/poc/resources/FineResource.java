package ae.jersey.poc.resources;

import ae.jersey.poc.models.Fine;
import ae.jersey.poc.services.FineService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Path("/fines")
public class FineResource {

    @Inject
    private FineService fineService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fine> getFines(@QueryParam("param") String param) {
        return fineService.getFinesByParam(param);
    }

    @GET
    @Path("/{fineId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fine getFine(@PathParam("fineId") Long fineId) {
        return fineService.getFineById(fineId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fine postFine(Fine fine) {
        return fineService.saveFine(fine);
    }

    @DELETE
    @Path("/{fineId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFine(@PathParam("fineId") Long fineId) {
        fineService.deleteFine(fineId);
    }
}
