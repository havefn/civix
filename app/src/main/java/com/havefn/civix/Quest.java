package com.havefn.civix;

import android.location.Location;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aufa on 18/06/2016.
 */
public class Quest {

    public String creatorID;
    public String title;
    public String description;
    public String imageID;
    public Location questLocation;
    public HashMap<String,Boolean> completedUser;
    private boolean status;
    public Date createdDate;
    public Date endDate;
    public int point;
    public QuestValidator validator;
    public String[] type; // {validation type (nfc, img, vote, etc) ; progression type (cl, co, etc)
    public List<String> nfcID;


    public static final String TAG = "QuestCreation";

    public Quest(String creatorID, Location questLocation ,String title){
        this.title = title;
        this.creatorID = creatorID;
        this.questLocation = questLocation;
        Calendar c = Calendar.getInstance();
        createdDate = c.getTime();

        if(isDateOK(endDate)){
            this.endDate = endDate;
        }else{
            //popup error, belum!
            //throw new Exception ("End date > current date");
        }

        Log.d(TAG,"Quest creation OK");

        completedUser = new HashMap<String,Boolean>();
    }

    //constructor for NFC based quest;
    public Quest(String imageID, String creatorID, Location questLocation,String title, String description, Date endDate){
        this.title = title;
        this.description = description;
        this.creatorID = creatorID;
        this.questLocation = questLocation;
        Calendar c = Calendar.getInstance();
        createdDate = c.getTime();
        this.nfcID = nfcID;
        this.imageID = imageID;
        this.description = description;

        nfcID = new ArrayList<>();

        if(isDateOK(endDate)){
            this.endDate = endDate;
        }else{
            //popup error, belum!
            //throw new Exception ("End date > current date");
        }

        this.type = new String[]{"nfc", "cl"};

        Log.d(TAG,"Quest creation OK");

        completedUser = new HashMap<String,Boolean>();
    }

    public Quest(){}


    public void setStatus(boolean in) throws Exception{

        if(!isDateOK(endDate)){
            throw new Exception("currentDate > endDate");
        }else{
            this.status = in;
        }

    }

    public boolean getStatus(){
        if(status == false){
            return false;
        }else{
            return isDateOK(endDate);
        }
    }


    public static boolean isDateOK(Date in){
        Calendar c = Calendar.getInstance();
        Date currentDate = c.getTime();
        return currentDate.compareTo(in) < 0;
    }

    public boolean userTryQuest(User user){
        if(validator.succeed()){
            completedUser.put(user.id,true);
        }
       return validator.succeed();
    }

    public boolean userTryQuest(User user, String in){
        if(validator.succeed(in)){
            completedUser.put(user.id,true);
        }
        return validator.succeed(in);
    }

    //nfc quest features
    public boolean addNFCID(String id) {
        if (type[0].equals("nfc")) {
            nfcID.add(id);
            return true;
        }
        return false;
    }
}
