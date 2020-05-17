package com.Randart;

public class Art {
    public String title;
    public String description;
    public String primaryimageurl;
    public String url;
    public String culture;
    public String medium;
    public String period;
    public String objectid;
    public String totaluniquepageviews;

    public String toString(){
        return "Title: " + title + " \nUrl: " +  primaryimageurl;
    }
}
