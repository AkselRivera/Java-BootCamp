package com.example.demo.models;


import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    public String productId;
    public String productName;
    public String UOM;
    public  Double availQty;
    public Date availDate;


    public Product(String productId, String productName, String UOM, Double availQty, Date availDate) {
        this.productId = productId;
        this.productName = productName;
        this.UOM = UOM;
        this.availQty = availQty;
        this.availDate = availDate;
    }
}
