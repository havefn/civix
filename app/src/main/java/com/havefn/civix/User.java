package com.havefn.civix;


import android.net.Uri;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User {

    public String id;
    public int profilePicID;
    public String name;
    public String city;
    public Uri imageUrl;
    public Date createdOn;
    public Map<String,Object> ownedQuests;
    public Map<String,Object> completedQuests;
    public Map<String,Object> friends;
    public String description;
    public int point;
    public int appreciated;
    public HashMap<String,Object> messageRoom;
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
        ownedQuests = new HashMap<String,Object>();
        ownedQuests.put("haha", "123");
        ownedQuests.put("ckck", "ccdlufa");
        completedQuests = new HashMap<String,Object>();
        friends = new HashMap<String,Object>();
        messageRoom =  new HashMap<String,Object>();
    }

    public User(){}

}
