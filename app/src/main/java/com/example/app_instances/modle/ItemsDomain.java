package com.example.app_instances.modle;

import java.io.Serializable;

public class ItemsDomain implements Serializable {
    public String type;
    public String title;
    public String address;
    public String pickPath;
    public int price;
    public int bed;
    public int bath;
    public int size;
    public Boolean isGarage;
    public Double score;
    public String description;

    public ItemsDomain(String type, String title, String address, String pickPath,
                       int price, int bed, int bath, int size,
                       boolean isGarage, double score, String description) {
        this.type = type;
        this.title = title;
        this.address = address;
        this.pickPath = pickPath;
        this.price = price;
        this.bed = bed;
        this.bath = bath;
        this.size = size;
        this.isGarage = isGarage;
        this.score = score;
        this.description = description;
    }
}

