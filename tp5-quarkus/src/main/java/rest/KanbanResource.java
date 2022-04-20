package rest;

import entity.Card;
import entity.Kanban;
import repository.CardRepository;
import repository.KanbanRepository;
import repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/kanban")
public class KanbanResource {
    @Inject
    KanbanRepository kanbanRepository;
    @Inject
    CardRepository cardRepository;
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kanban> getKanbans() {
        return kanbanRepository.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kanban getKanbanById(@PathParam("id") long id) {
        return kanbanRepository.findById(id);
    }

    @GET
    @Path("/cards/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getCards(@PathParam("id") long id) {
        return cardRepository.findByKanban(id);
    }
}
