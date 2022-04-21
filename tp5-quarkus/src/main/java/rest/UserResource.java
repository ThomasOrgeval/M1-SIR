package rest;

import entity.User;
import repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserRepository userRepository;

    @GET
    public List<User> getUsers() {
        return userRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") long id) {
        return userRepository.findById(id);
    }

    @POST
    public Response addUser(User user) {
        return Response.ok().entity("SUCCESS").build();
    }
}
