package com.example.example_listcountry.Api;

import com.example.example_listcountry.Model.ListCountryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListCountryApi {

    //@GET("all")
    @GET("all?fields=name")
    Call<List<ListCountryModel>> getListCountryModel();

    @GET("name/{name}")
    Call<List<ListCountryModel>> getListCountryModel(
            @Path("name") String countryName
    );
}
