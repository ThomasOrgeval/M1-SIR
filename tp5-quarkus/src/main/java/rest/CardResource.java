package rest;

import model.Card;
import model.dao.CardDao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/card")
public class CardResource {

    @Inject
    CardDao cardDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getCards() {
        return cardDao.findAllCards();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Card getCardById(@PathParam("id") long id) {
        return cardDao.findOne(id).isPresent() ? cardDao.findOne(id).get() : null;
    }
}