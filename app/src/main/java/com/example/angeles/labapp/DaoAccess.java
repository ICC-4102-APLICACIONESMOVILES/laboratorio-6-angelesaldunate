package com.example.angeles.labapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.text.Normalizer;
import java.util.List;

/**
 * Created by Angeles on 4/3/2018.
 */
@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleForm (Forms forms);
    //@Insert
    //void insertMultipleMovies (List<Forms> formsList);
    @Query("SELECT * FROM Forms WHERE formId = :formId")
    Forms fetchOneFormbyFormId (int formId);
    @Query("SELECT * FROM Forms")
    List<Forms> getAll();
    @Update
    void updateForm (Forms forms);
    @Delete
    void deleteForm (Forms forms);
}