package rest;

import entity.CardType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cardType")
public class CardTypeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CardType[] getCardTypes() {
        return CardType.values();
    }
}
