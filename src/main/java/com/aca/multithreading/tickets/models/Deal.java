package com.aca.multithreading.tickets.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: garik
 * @created" 8/22/2020, 10:44 AM
 */
public class Deal {
    private String seller;
    private String buyer;
    private Map<Ticket, Integer> tickets = new HashMap<>();

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Map<Ticket, Integer> getTickets() {
        return tickets;
    }

    public void setTickets(Map<Ticket, Integer> tickets) {
        this.tickets = tickets;
    }
}
