package com.havefn.civix;


import android.net.Uri;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User {

    private String id;
    private int profilePicID;
    private String name;
    private String city;
    private Uri imageUrl;
    private Date createdOn;
    private List<String> ownedQuests;
    private Map<String,Object> takenQuests;
    private Map<String,Object> completedQuests;
    private Map<String,Object> friends;
    private String description;
    private int point;
    private int appreciated;
    private HashMap<String,Object> messageRoom;
    private String email;

    public User(String id, String name,String email ){
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.description = description;
        point = 0;
        Calendar c = Calendar.getInstance();
        createdOn = c.getTime();
        ownedQuests = new ArrayList<String>();
        completedQuests = new HashMap<String,Object>();
        friends = new HashMap<String,Object>();
        messageRoom =  new HashMap<String,Object>();

        Global.mRoot.child("users").child(id).setValue(this);
    }

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public int getProfilePicID() {
        return profilePicID;
    }

    public void setProfilePicID(int profilePicID) {
        this.profilePicID = profilePicID;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public Uri getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Uri imageUrl) {
        this.imageUrl = imageUrl;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public Date getCreatedOn() {
        return createdOn;
    }


    public List<String> getOwnedQuests() {
        return ownedQuests;
    }

    public void setOwnedQuests(List<String> ownedQuests) {
        this.ownedQuests = ownedQuests;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public Map<String, Object> getTakenQuests() {
        return takenQuests;
    }

    public void setTakenQuests(Map<String, Object> takenQuests) {
        this.takenQuests = takenQuests;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public Map<String, Object> getCompletedQuests() {
        return completedQuests;
    }

    public void setCompletedQuests(Map<String, Object> completedQuests) {
        this.completedQuests = completedQuests;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public Map<String, Object> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, Object> friends) {
        this.friends = friends;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public String getDescription() {
        return description;

    }

    public void setDescription(String description) {
        this.description = description;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public int getAppreciated() {
        return appreciated;
    }

    public void setAppreciated(int appreciated) {
        this.appreciated = appreciated;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public HashMap<String, Object> getMessageRoom() {
        return messageRoom;
    }

    public void setMessageRoom(HashMap<String, Object> messageRoom) {
        this.messageRoom = messageRoom;
        Global.mRoot.child("users").child(id).setValue(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        Global.mRoot.child("users").child(id).setValue(this);
    }
}
