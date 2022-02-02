package rs.rest;

import io.swagger.v3.oas.annotations.Parameter;
import rs.dao.UserDao;
import rs.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {
    UserDao uDao;

    public UserResource() {
        uDao = new UserDao();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers()  {
        return uDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id)  {
        return uDao.findOne(id);
    }

    @POST
    @Consumes("application/json")
    public Response addUser(@Parameter(description = "Pet object that needs to be added to the store", required = true) User user) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}
