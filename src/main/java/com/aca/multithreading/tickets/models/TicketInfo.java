package com.aca.multithreading.tickets.models;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: garik
 * @created" 8/22/2020, 9:52 AM
 */
public class TicketInfo {
    private AtomicInteger count;
    private Ticket ticket;


    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
