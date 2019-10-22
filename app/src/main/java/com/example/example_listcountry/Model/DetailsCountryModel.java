package com.example.example_listcountry.Model;

import com.google.gson.annotations.SerializedName;

public class DetailsCountryModel {

    @SerializedName("code")
    String code;
    @SerializedName("name")
    String name;
    @SerializedName("symbol")
    String symbol;

    public DetailsCountryModel(){

    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

}
