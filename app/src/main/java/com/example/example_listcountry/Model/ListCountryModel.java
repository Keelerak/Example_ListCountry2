package com.example.example_listcountry.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCountryModel {

    @SerializedName("name")
    private String countryName;
    @SerializedName("currencies")
    List<DetailsCountryModel> detailsCountryModels;
    public String getCountryName() {
        return countryName;
    }

    public List<DetailsCountryModel> getDetailsCountryModels(){
        return detailsCountryModels;
    }


}
