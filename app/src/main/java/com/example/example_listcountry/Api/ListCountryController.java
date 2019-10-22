package com.example.example_listcountry.Api;

import com.example.example_listcountry.Api.ListCountryApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListCountryController {
    static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    public static ListCountryApi getListCountryApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ListCountryApi listCountryApi=retrofit.create(ListCountryApi.class);
        return listCountryApi;
    }
}
