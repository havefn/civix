package com.havefn.civix;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class User {

    public String id;
    public int profilePicID;
    public String name;
    public String city;
    public Date createdOn;
    public HashMap<String,Boolean> ownedQuests;
    public HashMap<String,Boolean> completedQuests;
    public HashMap<String,Boolean> friends;
    public String description;
    public int point;
    public int appreciated;
    public HashMap<String,Boolean> messageRoom;

    public User(int id, String name, String city, String description ){
        this.name = name;
        this.city = city;
        this.description = description;
        point = 0;
        Calendar c = Calendar.getInstance();
        createdOn = c.getTime();
        ownedQuests = new HashMap<String,Boolean>();
        completedQuests = new HashMap<String,Boolean>();
        friends = new HashMap<String,Boolean>();
        messageRoom =  new HashMap<String,Boolean>();
    }

    public User(){}

}
