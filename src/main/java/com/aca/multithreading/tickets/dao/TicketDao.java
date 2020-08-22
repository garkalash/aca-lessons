package com.aca.multithreading.tickets.dao;

import com.aca.multithreading.tickets.models.TicketInfo;
import com.aca.multithreading.tickets.utility.GsonFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: garik
 * @created" 8/22/2020, 10:06 AM
 */
public class TicketDao {
    public static final TicketDao INSTANCE = new TicketDao();

    private Map<String, List<TicketInfo>> data = new HashMap<>();

    private TicketDao(){
        initData();
    }

    private void initData(){
        File file = new File(this.getClass().getClassLoader().getResource("films.json").getFile());
        Gson gson = GsonFactory.GSON_INSTANCE();
        try(Reader reader = new FileReader(file)){
           List<TicketInfo> infos = gson.fromJson(reader, new TypeToken<List<TicketInfo>>(){ }.getType());
           data = infos.stream().collect(Collectors.groupingBy(o -> o.getTicket().getGenre()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<TicketInfo> getAvailableTickets(String genre){
        return data.get(genre);
    }
}
