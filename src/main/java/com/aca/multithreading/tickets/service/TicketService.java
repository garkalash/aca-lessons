package com.aca.multithreading.tickets.service;

import com.aca.multithreading.tickets.SellingProcess;

/**
 * @author: garik
 * @created" 8/22/2020, 10:04 AM
 */
public class TicketService {

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        ticketService.startSelling("action");
    }

    public void startSelling(String genre){
        new SellingProcess(genre).start();
    }
}
