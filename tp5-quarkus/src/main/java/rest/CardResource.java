package rest;

import model.Card;
import model.dao.CardDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/card")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CardResource {

    @Inject
    CardDao cardDao;

    @GET
    public List<Card> getCards() {
        return cardDao.listAll();
    }

    @GET
    @Path("/{id}")
    public Card getCardById(@PathParam("id") long id) {
        return cardDao.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Long updateCard(@PathParam("id") long id, Card card) {
        return cardDao.update(card, id);
    }

    @POST
    public Long saveCard(Card card) {
        return cardDao.save(card);
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        cardDao.deleteById(id);
        /*Card card = cardDao.findById(id);
        if(card == null) throw new NotFoundException();
        cardDao.delete(card);*/
    }
}
