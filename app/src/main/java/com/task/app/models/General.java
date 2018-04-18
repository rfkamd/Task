package com.task.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Rafiq Ahmed on 4/18/2018.
 */

public class General implements Serializable{

    @SerializedName("Tag")
    public String tag;

    @SerializedName("TypeCode")
    public int typeCode;

    @SerializedName("Value")
    public String value;

    @SerializedName("IsBinaryUnique")
    public boolean isBinaryUnique;

}
