package com.havefn.civix.Messaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aufa on 18/06/2016.
 */
public class MessageRoom {
    public String userId;
    public String user2Id;
    public HashMap<String,Boolean> messages;

    public MessageRoom(String userId, String user2Id){
        this.userId = userId;
        this.user2Id = user2Id;
        messages = new HashMap<String,Boolean> ();
    }

    public MessageRoom(){}
}
