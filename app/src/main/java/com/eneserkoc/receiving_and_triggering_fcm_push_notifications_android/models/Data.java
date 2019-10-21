package com.eneserkoc.receiving_and_triggering_fcm_push_notifications_android.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Data {
    public String title;
    public int price;
    public int view_count;
    public int view_count_limit;

    public Data(){

    }

    public Data(String title, int price, int view_count, int view_count_limit) {
        this.title = title;
        this.price = price;
        this.view_count = view_count;
        this.view_count_limit = view_count_limit;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getView_count() {
        return view_count;
    }

    public int getView_count_limit() {
        return view_count_limit;
    }
}
