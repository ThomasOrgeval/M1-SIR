package rs.rest;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import rs.dao.KanbanDao;
import rs.domain.Kanban;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/kanban")
@Produces({"application/json", "application/xml"})
public class KanbanResource {
    KanbanDao kanbanDao = new KanbanDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
    public List<Kanban> getUsers()  {
        return kanbanDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
    public Kanban getUserById(@PathParam("id") long id)  {
        return kanbanDao.findOne(id);
    }
}
