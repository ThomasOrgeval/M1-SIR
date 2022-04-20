package rest;

import entity.Card;
import repository.CardRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/card")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CardResource {

    @Inject
    CardRepository cardRepository;

    @GET
    public List<Card> getCards() {
        return cardRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Card getCardById(@PathParam("id") long id) {
        return cardRepository.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Long updateCard(@PathParam("id") long id, Card card) {
        return cardRepository.update(card, id);
    }

    @POST
    public Long saveCard(Card card) {
        return cardRepository.save(card);
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        cardRepository.deleteById(id);
        /*Card card = cardDao.findById(id);
        if(card == null) throw new NotFoundException();
        cardDao.delete(card);*/
    }
}
