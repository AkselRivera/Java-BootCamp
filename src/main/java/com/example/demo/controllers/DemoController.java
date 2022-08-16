package com.example.demo.controllers;

import com.example.demo.service.DemoService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.*;


@RestController
public class DemoController {
@Autowired
    DemoService demoService;

/*
    @GetMapping("/")
    public ArrayList<String> demoGet(){
        return demoService.findAll();
    }
*/
    @PostMapping("/getInvPicture")
    public Object getInventory(@RequestBody String input  ) throws ParseException {

        return  demoService.objectInventory( input);
    }
}
