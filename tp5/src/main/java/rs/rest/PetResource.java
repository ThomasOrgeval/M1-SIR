package rs.rest;

import io.swagger.v3.oas.annotations.Parameter;
import rs.domain.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class PetResource {
    @GET
    @Path("/{petId}")
    public Pet getPetById(@PathParam("petId") Long petId)  {
        // return pet
        return new Pet();
    }

    @POST
    @Consumes("application/json")
    public Response addPet(
            @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}
