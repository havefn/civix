package com.havefn.civix;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Cakson on 20/06/2016.
 */
public class NFCQuest extends Quest {
    private QuestValidator validator;
    private List<String> nfcID;


    public NFCQuest(String creatorID, Location questLocation , String title, String description, Date endDate, String imageID, String type) throws Exception {
        super(creatorID, questLocation , title, description, endDate, imageID, type);
        ArrayList<String> nfcID = new ArrayList<String>();

        super.setQuestId(Global.mRoot.child("rootDB").push().getKey());
        Global.mRoot.child("rootDB").child(super.getQuestId()).setValue(this);
    }

    public QuestValidator getValidator() {
        return validator;
    }

    public void setValidator(QuestValidator validator) {
        this.validator = validator;
        Global.mRoot.child("rootDB").child(super.getQuestId()).setValue(this);
    }

    public List<String> getNfcID() {
        return nfcID;
    }

    public void setNfcID(List<String> nfcID) {
        this.nfcID = nfcID;
        Global.mRoot.child("rootDB").child(super.getQuestId()).setValue(this);
    }
}
