package com.example.junli.reminderapp;

/**
 * Created by Jun Li on 2/19/2017.
 */

public class Reminder {
    private String title;
    private String description;
    private String dateAndTime;
    private int interval;

    private int id;

    //getter and setter
    public int getId() {return id;}
    public Reminder setId(int id){
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
// end getter and setter
}
