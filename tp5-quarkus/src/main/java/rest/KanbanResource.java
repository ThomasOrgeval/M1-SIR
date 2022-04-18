package rest;

import model.Kanban;
import model.dao.KanbanDao;

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
    KanbanDao kanbanDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kanban> getKanbans() {
        return kanbanDao.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kanban getKanbanById(@PathParam("id") long id) {
        return kanbanDao.findById(id);
    }
}
