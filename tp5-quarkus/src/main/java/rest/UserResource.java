package rest;

import entity.User;
import repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public Long addUser(User user) {
        return userRepository.save(user);
    }
}
