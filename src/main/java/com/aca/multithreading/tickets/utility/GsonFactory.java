package com.aca.multithreading.tickets.utility;

import com.aca.multithreading.tickets.models.Ticket;
import com.aca.multithreading.tickets.models.TicketInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: garik
 * @created" 8/22/2020, 9:53 AM
 */
public class GsonFactory {

    public static Gson GSON_INSTANCE(){
    GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Ticket> deserializer = (json, typeOfT, context) -> {
            JsonObject jsonObject = json.getAsJsonObject();
            String id = jsonObject.get("_id").getAsString();
            String genre = jsonObject.get("genre").getAsString();
            BigDecimal price = new BigDecimal(jsonObject.get("price").getAsString()
                    .replaceAll("[^0-9.]", ""));
            Integer year = jsonObject.get("year").getAsInt();
            Ticket ticket = new Ticket();
            ticket.setId(id);
            ticket.setGenre(genre);
            ticket.setPrice(price);
            ticket.setYear(year);
            return ticket;
        };
        gsonBuilder.registerTypeAdapter(Ticket.class, deserializer);

        JsonDeserializer<TicketInfo> ticketInfoJsonDeserializer = (json, typeOfT, context) -> {
            JsonObject jsonObject = json.getAsJsonObject();
            Ticket ticket = gsonBuilder.create().fromJson(jsonObject.toString(), Ticket.class);
            Integer count = jsonObject.get("ticketCount").getAsInt();
            TicketInfo ticketInfo = new TicketInfo();
            ticketInfo.setTicket(ticket);
            ticketInfo.setCount(new AtomicInteger(count));
            return ticketInfo;
        };
        gsonBuilder.registerTypeAdapter(TicketInfo.class, ticketInfoJsonDeserializer);
        return gsonBuilder.create();
    }
}
