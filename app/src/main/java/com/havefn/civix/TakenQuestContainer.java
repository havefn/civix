package com.havefn.civix;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Cak on 19/06/2016.
 */
public class TakenQuestContainer {
    String questID;
    QuestProgression progress;
    DatabaseReference mRoot;

    public TakenQuestContainer(String questID) {
        this.questID = questID;
    }
}
