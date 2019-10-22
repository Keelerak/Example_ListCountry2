package com.example.example_listcountry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.example_listcountry.Adapter.ListCountryAdapter;
import com.example.example_listcountry.Api.ListCountryApi;
import com.example.example_listcountry.Api.ListCountryController;
import com.example.example_listcountry.Model.ListCountryModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static ListCountryApi listCountryApi;
    RecyclerView recyclerView;
    List<ListCountryModel> listCountryposts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        }catch (NullPointerException e){}
        setContentView(R.layout.activity_main);

        listCountryApi = ListCountryController.getListCountryApi();

        listCountryposts = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.list_country_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ListCountryAdapter listCountryAdapter = new ListCountryAdapter(listCountryposts);
        recyclerView.setAdapter(listCountryAdapter);

        listCountryApi.getListCountryModel().enqueue(new Callback<List<ListCountryModel>>() {
            @Override
            public void onResponse(Call<List<ListCountryModel>> call, Response<List<ListCountryModel>> response) {
                listCountryposts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ListCountryModel>> call, Throwable t) {

            }
        });
    }
}
