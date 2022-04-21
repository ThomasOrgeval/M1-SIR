package rest;

import entity.Card;
import entity.Kanban;
import repository.CardRepository;
import repository.KanbanRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/kanban")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KanbanResource {
    @Inject
    KanbanRepository kanbanRepository;
    @Inject
    CardRepository cardRepository;

    @GET
    public List<Kanban> getKanbans() {
        return kanbanRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Kanban getKanbanById(@PathParam("id") long id) {
        return kanbanRepository.findById(id);
    }

    @GET
    @Path("/cards/{id}")
    public List<Card> getCards(@PathParam("id") long id) {
        return cardRepository.findByKanban(id);
    }

    @POST
    public Long saveKanban(Kanban kanban) {
        return kanbanRepository.save(kanban);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {

    }
}
