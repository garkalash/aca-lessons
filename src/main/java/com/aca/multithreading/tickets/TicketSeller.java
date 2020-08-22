package com.aca.multithreading.tickets;

import com.aca.multithreading.tickets.models.Deal;
import com.aca.multithreading.tickets.models.Ticket;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

/**
 * @author: garik
 * @created" 8/22/2020, 10:46 AM
 */
public class TicketSeller implements Callable<List<Deal>> {
    private static final Logger logger = Logger.getLogger("TicketSeller");
    private static final int MAX_BUY_COUNT = 5;
    private final String name;
    private final BlockingQueue<Ticket> ticketsToSell;
    private final TicketProvider[] ticketProviders;

    public TicketSeller(String name, BlockingQueue<Ticket> ticketsToSell, TicketProvider... ticketProviders) {
        this.name = name;
        this.ticketsToSell = ticketsToSell;
        this.ticketProviders = ticketProviders;
    }

    @Override
    public List<Deal> call() throws Exception {
        logger.info(name + " selling STARTED");
        List<Deal> deals = new ArrayList<>();
        int i = 0;
        Random random = new Random();
        while (true){
            String buyer = name + "_Buyer-" + i;
            ++i;
            int count = random.nextInt(MAX_BUY_COUNT - 1) + 1;
            Optional<Deal> deal = buy(buyer, count);
            if(deal.isPresent()){
                deals.add(deal.get());
            } else {
                break;
            }
        }
        logger.info(name + " selling FINISHED");
        return deals;
    }

    private Optional<Deal> buy(String buyer, Integer count){
        boolean areProvidersFinished = Arrays.stream(ticketProviders).allMatch(TicketProvider::isFinished);
        if(!areProvidersFinished){
            Deal deal = new Deal();
            deal.setSeller(name);
            for (int i = 0; i < count; i++) {
                Ticket ticket = null;
                try {
                    ticket = ticketsToSell.take();
                    if(deal.getTickets().containsKey(ticket)){
                        deal.getTickets().put(ticket, deal.getTickets().get(ticket) + 1);
                    } else {
                        deal.getTickets().put(ticket, 1);
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            deal.setBuyer(buyer);
            return Optional.of(deal);
        } else {
            return Optional.empty();
        }
    }
}
