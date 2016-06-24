package com.havefn.civix;

import android.location.Location;
import android.os.Parcel;

/**
 * Created by aufa on 24/06/2016.
 */
public class LocationFb extends Location {
    public LocationFb(){
        super("");
    }


    public static final Creator<LocationFb> CREATOR = new Creator<LocationFb>() {
        @Override
        public LocationFb  createFromParcel(Parcel in) {
            return new LocationFb();
        }

        @Override
        public LocationFb[] newArray(int size) {
            return new LocationFb[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

    }

    public int describeContents() {
        return 0;
    }
}
