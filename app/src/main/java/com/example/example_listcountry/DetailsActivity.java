package com.example.example_listcountry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

//import com.example.example_listcountry.Api.DetailsCountryApi;
import com.example.example_listcountry.Api.ListCountryApi;
import com.example.example_listcountry.Model.ListCountryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class DetailsActivity extends AppCompatActivity {

    Intent intent;
    static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    private TextView tv1;
    //private DetailsCountryApi detailsCountryApi;
    private ListCountryApi listCountryApi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        }catch (NullPointerException e){}
        setContentView(R.layout.activity_details);

        tv1 = (TextView) findViewById(R.id.tv_money);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //DetailsCountryApi detailsCountryApi=retrofit.create(DetailsCountryApi.class);

        listCountryApi2 = retrofit.create(ListCountryApi.class);

        getListCountryModel();
    }
    private void  getListCountryModel () {
        Call<List<ListCountryModel>> call = listCountryApi2
                .getListCountryModel(getNameCountry());

        call.enqueue(new Callback<List<ListCountryModel>>() {
            @Override
            public void onResponse(Call<List<ListCountryModel>> call, Response<List<ListCountryModel>> response) {

                if (!response.isSuccessful()) {
                    tv1.setText("Code: " + response.code() + getNameCountry());
                    Log.i(TAG, "Country Name:    " + getNameCountry() );
                    return;
                }

                List<ListCountryModel> comments = response.body();

                for (ListCountryModel comment : comments) {
                    String content = "";
                    content += "Country Name: " + comment.getCountryName() + "\n";
                    content += "Code monetary unit: " + comment.getDetailsCountryModels().get(0).getCode() + "\n";
                    content += "Monetary unit: " + comment.getDetailsCountryModels().get(0).getName() + "\n";
                    content += "Symbol: " + comment.getDetailsCountryModels().get(0).getSymbol() + "\n";

                    tv1.append(content);
                    tv1.setTextSize(18);
                }
            }

            @Override
            public void onFailure(Call<List<ListCountryModel>> call, Throwable t) {
                tv1.setText(t.getMessage());
            }
        });
    }


    private String getNameCountry(){
        intent = getIntent();
        String nameCountry = intent.getStringExtra("name");
        return  nameCountry;
    }
}
