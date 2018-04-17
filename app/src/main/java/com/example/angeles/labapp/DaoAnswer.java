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
public interface DaoAnswer {

    @Insert
    void insertOnlySingleAnswerSet(AnswerSet anset);
    @Insert
    void insertOnlySingleAnswer (AnswerSet answerSet, Questions questions );

    //@Insert
    //void insertMultipleMovies (List<Forms> formsList);
    @Query("SELECT * FROM Answer WHERE answerId = :answerId")
    Answer fetchOneQuestionbyQuestionId (int answerId);
    @Query("SELECT * FROM Answer WHERE answerSetId = :answerSetId")
    List<Answer> fetchOneSetAnswerbySetAnswerId(int answerSetId );

    @Query("SELECT * FROM Answer")
    List<Answer> getAllAnswer();
    @Query ("SELECT * FROM AnswerSet")
    List<AnswerSet> getAllSetAnswer();

}
