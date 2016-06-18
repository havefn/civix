package com.havefn.civix;


import android.net.Uri;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class User {

    public String id;
    public int profilePicID;
    public String name;
    public String city;
    public Uri imageUrl;
    public Date createdOn;
    public HashMap<String,Boolean> ownedQuests;
    public HashMap<String,Boolean> completedQuests;
    public HashMap<String,Boolean> friends;
    public String description;
    public int point;
    public int appreciated;
    public HashMap<String,Boolean> messageRoom;
    public String email;

    public User(String id, String name,String email ){
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
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
