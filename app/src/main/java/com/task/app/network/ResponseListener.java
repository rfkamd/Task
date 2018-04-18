package com.task.app.network;

import com.task.app.models.Announcement;

import java.util.List;

/**
 * Created by Rafiq Ahmed on 4/19/2018.
 */

public interface ResponseListener {
    void onApiResponse(List<Announcement> announcements);
    void onApiResponseFailure(Throwable throwable);
}
