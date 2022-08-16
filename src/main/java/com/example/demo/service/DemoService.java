package com.example.demo.service;

import com.example.demo.models.Product;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DemoService {

    Logger logger = LoggerFactory.getLogger(DemoService.class);

    public Object objectInventory ( String input ) throws ParseException {
        logger.info("Validating inventory");
        JSONObject inputJson = new JSONObject(input);
        List<Product> inventory = new ArrayList<>();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        inventory.add(new Product( "Prod1","Shirt","EACH", 10.0,  (Date) formatter.parse("2021-03-20") ) );
        inventory.add(new Product( "Prod1","Shirt","EACH", 20.0,  (Date) formatter.parse("2021-03-21") ) );
        inventory.add(new Product( "Prod1","Shirt","EACH", 30.0, (Date) formatter.parse("2021-03-28") ) );

        Date reqDate = (Date) formatter.parse(inputJson.getString("reqDate"));
        logger.info("Request Data: "+reqDate);
        inventory
                .stream()
                .filter(i ->reqDate.before(i.availDate));


        return inventory;

    }





    public Iterable<Object> sortValues(String value) {
        JSONObject jsonObject = new JSONObject(value.trim());
        JSONArray jsonArray = jsonObject.getJSONArray("productList");
        JSONArray sortedJsonArray = new JSONArray();
        List list = new ArrayList();
        for(int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getJSONObject(i));
        }
        System.out.println("Before Sorted JSONArray: " + jsonArray);

        for(int i = 0; i < jsonArray.length(); i++) {
            sortedJsonArray.put(list.get(i));
        }


        return sortedJsonArray;


    }
}
