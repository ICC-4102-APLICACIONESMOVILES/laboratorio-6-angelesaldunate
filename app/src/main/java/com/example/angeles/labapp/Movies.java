package com.example.angeles.labapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Angeles on 4/3/2018.
 */

@Entity
public class Movies {
    @NonNull
    @PrimaryKey
    private String movieId;
    private String movieName;

    public Movies() {
    }

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
    public String getMovieName() { return movieName; }
    public void setMovieName (String movieName) { this.movieName = movieName; }
}