package com.example.angeles.labapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Angeles on 4/10/2018.
 */
@Dao
public interface DaoQuestion {

    @Insert
    void insertOnlySingleQuestion (Questions questions);
    //@Insert
    //void insertMultipleMovies (List<Forms> formsList);
    @Query("SELECT * FROM Questions WHERE questionId = :questionId")
    Forms fetchOneQuestionbyQuestionId (int questionId);
    @Query("SELECT * FROM Questions")
    List<Questions> getAll();
    @Update
    void updateQuestion (Questions questions);
    @Delete
    void deleteQuestion (Questions questions);

}
