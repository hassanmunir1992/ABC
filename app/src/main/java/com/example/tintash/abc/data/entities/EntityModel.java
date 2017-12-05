package com.example.tintash.abc.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tintash on 12/5/2017.
 */

public class EntityModel implements Parcelable {

    @Override
    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags){

    }

    public EntityModel() {

    }

    public EntityModel(Parcel parcel){

    }

    public static Parcelable.Creator<EntityModel> CREATOR = new Parcelable.Creator<EntityModel>(){
        @Override
        public EntityModel createFromParcel(Parcel parcel){
            return new EntityModel(parcel);
        }

        @Override
        public EntityModel[] newArray(int size){
            return new EntityModel[size];
        }
    };

}
