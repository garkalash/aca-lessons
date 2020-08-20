package com.aca.files;

import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: garik
 * @created: 8/6/2020, 9:58 PM
 */
class GoodPerson {
    private Integer id;
    private Integer age;
    private List<String> diplomas;
    private boolean married;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getDiplomas() {
        return diplomas;
    }

    public void setDiplomas(List<String> diplomas) {
        this.diplomas = diplomas;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class JsonParser {
    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "    \"id\": 5,\n" +
                "    \"age\": 45,\n" +
                "    \"diplomas\": [\"YSU\",\"Cambridge\"],\n" +
                "    \"married\": true,\n" +
                "    \"name\": \"Slavik\"\n" +
                "}";

        JSONObject jsonObject = new JSONObject(jsonStr);
        GoodPerson goodPerson = new GoodPerson();
        goodPerson.setAge(jsonObject.getInt("age"));
        goodPerson.setMarried(jsonObject.getBoolean("married"));
        goodPerson.setName(jsonObject.getString("name"));
        goodPerson.setId(jsonObject.getInt("id"));

        JSONArray diplomasAsJson = jsonObject.getJSONArray("diplomas");

        List<String> receivedDiplomas = new ArrayList<>();
        diplomasAsJson.iterator().forEachRemaining(o -> {
            System.out.println(o);
            receivedDiplomas.add((String) o);
        });
        goodPerson.setDiplomas(receivedDiplomas);

        JSONObject serializedPerson = new JSONObject();
        serializedPerson.put("age", goodPerson.getAge());


        GoodPerson googledVersion = new GsonBuilder().create().fromJson(jsonStr, GoodPerson.class);
        googledVersion.setMarried(false);
        String googledVersionJson = new GsonBuilder().create().toJson(googledVersion);

        System.out.println(goodPerson.getName());
    }
}
