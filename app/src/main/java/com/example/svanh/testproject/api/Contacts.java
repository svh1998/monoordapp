package com.example.svanh.testproject.api;

/**
 * Created by svanh on 4/21/2017.
 */

public class Contacts {
    private String name,id;

    public Contacts(String name, String id){
        this.setName(name);
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String naam) {
        this.name = naam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
