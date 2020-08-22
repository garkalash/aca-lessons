package com.aca.multithreading.tickets;

import com.aca.multithreading.tickets.models.Ticket;
import com.aca.multithreading.tickets.models.TicketInfo;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * @author: garik
 * @created" 8/22/2020, 10:19 AM
 */
public class TicketProvider extends Thread {
    private static final Logger logger = Logger.getLogger(TicketProvider.currentThread().getName());


    private final Integer limit;
    private final BlockingQueue<Ticket> ticketsToSell;
    private final List<TicketInfo> availableToProduce;
    private final AtomicInteger curProduced = new AtomicInteger(0);

    public TicketProvider(String name, Integer limit,
                          BlockingQueue<Ticket> ticketsToSell,
                          List<TicketInfo> availableToProduce) {
        super(name);
        this.limit = limit;
        this.ticketsToSell = ticketsToSell;
        this.availableToProduce = availableToProduce;
    }

    @Override
    public void run() {
        logger.info(getName() + " STARTED producing. Limit " + limit);
            while (curProduced.get() <= limit){
                for(TicketInfo ticketInfo: availableToProduce){
                    if(ticketInfo.getCount().get() != 0){
                        ticketInfo.getCount().decrementAndGet();
                        curProduced.incrementAndGet();
                        try {
                            ticketsToSell.put(ticketInfo.getTicket());
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        break;
                    }
            }
        }
        logger.info(getName() + " FINISHED providing. Is provided " + curProduced.get() + " tickets");
    }

    public boolean isFinished(){
        return curProduced.get() == limit;
    }
}
