package com.havefn.civix;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Cakso on 20/06/2016.
 */
public class Global {
    public static final DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
}
