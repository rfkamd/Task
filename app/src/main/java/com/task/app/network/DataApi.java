package com.task.app.network;

import com.task.app.models.Announcement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Rafiq Ahmed on 4/18/2018.
 */

public interface DataApi {
    @GET
    Call<List<Announcement>> getAnnouncements(@Url String url);
}
