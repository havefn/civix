package com.havefn.civix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aufa 19/06/2016.
 */
public class QuestProgression {
    private Boolean complete;
    List<Boolean> checkList;
    int currentCount;
    int targetCount;
    String type;


    public QuestProgression (String type, int targetCount){
        checkList = new ArrayList<Boolean>();
        currentCount = 0;
        this.targetCount = targetCount;
        this.type = type;
        complete = false;
    }

    public Boolean isComplete(){
        if(type.equals("cl")){
            Boolean temp = true;

            for(Boolean e : checkList){
                temp = temp && e;
                if(temp.equals(false)){
                    break;
                }
            }

            return temp;
        }else if(type.equals("co")){
            if(currentCount == targetCount){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }



}
