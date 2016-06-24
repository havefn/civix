package com.havefn.civix.Quest;

import com.havefn.civix.Global;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cakso on 21/06/2016.
 */
public class Quests {
    private Map<String, Quest> quests;

    public Quests() {
        quests = new HashMap<String, Quest>();
        Global.mRoot.getDatabase().getReference().setValue(this);
    }

    //HashMap.
    public void addQuest(String questId, Quest quest) {
        quests.put(questId, quest);
    }

    public Map<String, Quest> getQuests() {
        return quests;
    }

    public void setQuests(HashMap<String, Quest> quests) {
        this.quests = quests;
        Global.mRoot.getDatabase().getReference().setValue(this);
    }

    public void updateDatabase() {
        Global.mRoot.getDatabase().getReference().setValue(this);
    }
}
