package com.havefn.civix;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by aufa on 18/06/2016.
 */
public class Msg {
    public String ownerId;
    public String message;
    public Date sentTime;

    public Msg(String ownerId, String message){
        this.ownerId = ownerId;
        this.message = message;

        Calendar c = Calendar.getInstance();
        sentTime = c.getTime();
    }

    public Msg(){}
}
