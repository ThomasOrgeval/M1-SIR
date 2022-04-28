package rest;

import entity.Card;
import io.quarkus.logging.Log;
import repository.CardRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
    @Transactional
    public void delete(@PathParam("id") long id) {
        cardRepository.deleteById(id);
        Log.info("[Card] carte supprimee " + id);
    }
}
