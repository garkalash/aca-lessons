package com.aca.multithreading.tickets;

import com.aca.multithreading.tickets.dao.TicketDao;
import com.aca.multithreading.tickets.models.Deal;
import com.aca.multithreading.tickets.models.Ticket;
import com.aca.multithreading.tickets.models.TicketInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * @author: garik
 * @created" 8/22/2020, 10:05 AM
 */
public class SellingProcess {
    private static final Logger logger = Logger.getLogger("Sell_process");

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final String genre;
    private final BlockingQueue<Ticket> ticketsToSell = new ArrayBlockingQueue<>(20);
    private final List<TicketInfo> ticketsInWarehouse = new ArrayList<>();


    private final TicketProvider firstTicketProvider;
    private final TicketProvider secondTicketProvider;

    private final TicketSeller ticketSeller1;
    private final TicketSeller ticketSeller2;
    private final TicketSeller ticketSeller3;
    private final TicketSeller ticketSeller4;

    public SellingProcess(String genre) {
        this.genre = genre;
        ticketsInWarehouse.addAll(TicketDao.INSTANCE.getAvailableTickets(genre));

        int count = ticketsInWarehouse.stream().mapToInt(value -> value.getCount().get()).sum();

        firstTicketProvider  = new TicketProvider("Ticket-Provider-1", count/2, ticketsToSell, ticketsInWarehouse);
        secondTicketProvider  = new TicketProvider("Ticket-Provider-2", count - count/2, ticketsToSell, ticketsInWarehouse);

        ticketSeller1 = new TicketSeller("Seller1", ticketsToSell, firstTicketProvider, secondTicketProvider);
        ticketSeller2 = new TicketSeller("Seller2", ticketsToSell, firstTicketProvider, secondTicketProvider);
        ticketSeller3 = new TicketSeller("Seller3", ticketsToSell, firstTicketProvider, secondTicketProvider);
        ticketSeller4 = new TicketSeller("Seller4", ticketsToSell, firstTicketProvider, secondTicketProvider);
    }

    public void start(){
        logger.info("Process for genre " + genre  + " is started ");

        Future p1 = executorService.submit(firstTicketProvider);
        Future p2 = executorService.submit(secondTicketProvider);
        List<Deal> allDeals = new ArrayList<>();
        try {
            List<Future<List<Deal>>> futureDeals =  executorService.invokeAll(Arrays.asList(
                    ticketSeller1,
                    ticketSeller2,
                    ticketSeller3,
                    ticketSeller4
            ));

            while(true) {
                if(futureDeals.stream().allMatch(Future::isDone)){
                    futureDeals.forEach(sellFuture -> {
                        try {
                            allDeals.addAll(sellFuture.get());
                        } catch (InterruptedException | ExecutionException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    });
                    break;
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }


        logger.info("Process for genre " + genre  + " is FINISHED ");
        executorService.shutdown();
    }


}
