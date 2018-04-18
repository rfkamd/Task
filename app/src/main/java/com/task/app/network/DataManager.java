package com.task.app.network;

import com.task.app.models.Announcement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafiq Ahmed on 4/18/2018.
 */

public class DataManager {

    public static void getAnnouncements(String url, final ResponseListener callback) {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl("http://94.56.199.34/EMC/IPDP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DataApi service = retrofit.create(DataApi.class);

        Call<List<Announcement>> response = service.getAnnouncements(url);
        response.enqueue(new Callback<List<Announcement>>() {
            @Override
            public void onResponse(Call<List<Announcement>> call, Response<List<Announcement>> response) {
                callback.onApiResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Announcement>> call, Throwable throwable) {
                callback.onApiResponseFailure(throwable);
            }
        });
    }

}
