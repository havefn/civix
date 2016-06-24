package com.havefn.civix.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aufa 19/06/2016.
 */

//untuk sementara ini, kelas ini hanya dikhususkan untuk NFCQuestProgression :( -aufa
public class QuestProgression {
    private Boolean complete;
    private List<Boolean> checkList;
    private int currentCount;
    private int targetCount;
    private String type;
    private String userId;
    private String questId;

    public QuestProgression (String type, int targetCount, String userId, String questId){
        checkList = new ArrayList<Boolean>();
        this.type = type;
        this.userId = userId;
        this.questId = questId;
        complete = false;
    }

    public Boolean isComplete(){

            if(currentCount == targetCount){
                return true;
            }else{
                return false;
            }

    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public List<Boolean> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Boolean> checkList) {
        this.checkList = checkList;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(int targetCount) {
        this.targetCount = targetCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestId() {
        return questId;
    }

    public void setQuestId(String questId) {
        this.questId = questId;
    }
}
