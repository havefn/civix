package com.havefn.civix.Quest;

import android.location.Location;

import com.havefn.civix.Global;
import com.havefn.civix.LocationFb;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by aufa on 18/06/2016.
 */
public class Quest {

    private String creatorID;
    private String title;
    private String description;
    private String imageID;
    private LocationFb questLocation;
    private HashMap<String,Boolean> completedUser;
    private boolean complete;
    private Date createdDate;
    private Date endDate;
    private String progressionType;
    private String questId;

    private static final String TAG = "QuestCreation";

    public Quest(String creatorID, LocationFb questLocation , String title, String description, String imageID, String type, String questId) {
        this.questId = questId;
        this.title = title;
        this.creatorID = creatorID;
        this.questLocation = questLocation;
        Calendar c = Calendar.getInstance();
        createdDate = c.getTime();
        this.imageID = imageID;
        this.endDate = endDate;
        this.description = description;
        this.progressionType = type;
        completedUser = new HashMap<String,Boolean>();
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public Quest(){}

    public String getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(String creatorID) {
        this.creatorID = creatorID;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public Location getQuestLocation() {
        return questLocation;
    }

    public void setQuestLocation(LocationFb questLocation) {
        this.questLocation = questLocation;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public HashMap<String, Boolean> getCompletedUser() {
        return completedUser;
    }

    public void setCompletedUser(HashMap<String, Boolean> completedUser) {
        this.completedUser = completedUser;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public String getProgressionType() {
        return progressionType;
    }

    public void setProgressionType(String progressionType) {
        this.progressionType = progressionType;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

    public String getQuestId() {
        return questId;
    }

    public void setQuestId(String questId) {
        this.questId = questId;
        Global.mRoot.child("quests").child(questId).setValue(this);
    }

//    public static String getTAG() {
//        return TAG;
//    }
//        public boolean userTryQuest(User user){
//        if(validator.succeed()){
//            completedUser.put(user.id,true);
//        }
//       return validator.succeed();
//    }

//    public boolean userTryQuest(User user, String in){
//        if(validator.succeed(in)){
//            completedUser.put(user.id,true);
//        }
//        return validator.succeed(in);
//    }
}
