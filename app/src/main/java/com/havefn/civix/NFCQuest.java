package com.havefn.civix;

import android.location.Location;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Cakson on 20/06/2016.
 */
public class NFCQuest extends Quest {
    private static final String TAG = "NFCQuest";
    private QuestValidator validator;
    private List<String> nfcID;
    private int targetCount;

    public NFCQuest(String creatorID, Location questLocation , String title, String description, Date endDate, String imageID, String type) throws Exception {
        super(creatorID, questLocation , title, description, endDate, imageID, type);
        ArrayList<String> nfcID = new ArrayList<String>();
        DatabaseReference ref = Global.mRoot.child("quests").push();
        super.setQuestId(ref.getKey());
        Global.mRoot.child("quests").child(super.getQuestId()).setValue(this);
    }

    public NFCQuest(String creatorID, Location questLocation , String title, String description, String imageID, String type) throws Exception {
        super(creatorID, questLocation , title, description, imageID, type);
        ArrayList<String> nfcID = new ArrayList<String>();

        super.setQuestId(Global.mRoot.child("quests").push().getKey());
        Global.mRoot.child("quests").child(super.getQuestId()).setValue(this);
    }

    public void setTargetCount(int target){
        this.targetCount = target;
        Global.mRoot.child("quests").child(super.getQuestId()).setValue(this);
    }

    public int getTargetCount(){
        return targetCount;
    }

    public QuestValidator getValidator() {
        return validator;
    }

    public void setValidator(QuestValidator validator) {
        this.validator = validator;
        Global.mRoot.child("quests").child(super.getQuestId()).setValue(this);
    }

    public List<String> getNfcID() {
        return nfcID;
    }

    public void setNfcID(List<String> nfcID) {
        this.nfcID = nfcID;
        Global.mRoot.child("quests").child(super.getQuestId()).setValue(this);
    }

    public void updateDatabase() {
        Global.mRoot.child("quests").child(super.getQuestId()).setValue(this);
    }
}
