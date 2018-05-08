package com.example.angeles.labapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.location.Location;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Angeles on 4/10/2018.
 */
@Entity(foreignKeys = @ForeignKey(entity = Forms.class,
        parentColumns = "formId",
        childColumns = "formId",
        onDelete = CASCADE))

public class AnswerSet {
    @PrimaryKey(autoGenerate = true)
    private int answerSetId;
    private int formId;
    private String date;
    private double lat;
    private double log;
    //private Location loc;


    public int getAnswerSetId() {
        return answerSetId;
    }

    public int getFormId() {
        return formId;
    }

    public void setAnswerSetId(int answerSetId) {
        this.answerSetId = answerSetId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate()  {return date;}

    public void setLat(double lat){this.lat = lat;}
    public double getLat(){return lat;}

    public void setLog(double log) {this.log = log;}
    public double getLog() {return log;}


}
