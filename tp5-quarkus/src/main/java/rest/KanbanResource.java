package rest;

import entity.Kanban;
import repository.KanbanRepository;

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
}
