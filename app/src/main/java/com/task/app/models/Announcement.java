package com.task.app.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rafiq Ahmed on 4/18/2018.
 */

public class Announcement {

    @SerializedName("ID")    
    public General id;

    @SerializedName("NATIVE_DATE")
    public General nativeDate;

    @SerializedName("ANNOUNCEMENT_DATE")
    public General announcementDate;

    @SerializedName("EXPIRY")
    public General expiry;

    @SerializedName("ANNOUNCEMENT_DESCRIPTION")
    public General announcementDescription;

    @SerializedName("ANNOUNCEMENT_TITLE")
    public General announcementTitle;

    @SerializedName("ANNOUNCEMENT_IMAGE")
    public General announcementImage;

    @SerializedName("ANNOUNCEMENT_IMAGE_THUMBNAIL")
    public General announcementImageThumbnail;

    @SerializedName("ANNOUNCEMENT_HTML")
    public General announcementHtml;
    
    
    public Announcement(){}

    public General getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(General announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public General getAnnouncementImage() {
        return announcementImage;
    }

    public void setAnnouncementImage(General announcementImage) {
        this.announcementImage = announcementImage;
    }

    public General getAnnouncementImageThumbnail() {
        return announcementImageThumbnail;
    }

    public void setAnnouncementImageThumbnail(General announcementImageThumbnail) {
        this.announcementImageThumbnail = announcementImageThumbnail;
    }

    public General getAnnouncementHtml() {
        return announcementHtml;
    }

    public void setAnnouncementHtml(General announcementHtml) {
        this.announcementHtml = announcementHtml;
    }
}
