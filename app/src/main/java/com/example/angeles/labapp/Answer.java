package com.example.angeles.labapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Angeles on 4/10/2018.
 */
@Entity(foreignKeys = {@ForeignKey(entity = AnswerSet.class,
        parentColumns = "answerSetId",
        childColumns = "answerSetId",
        onDelete = CASCADE),
        @ForeignKey(entity = Questions.class,
        parentColumns = "questionId",
        childColumns = "questionId", onDelete = CASCADE)})



public class Answer {
    @PrimaryKey(autoGenerate = true)
    private int answerId;
    private int answerSetId;
    private int questionId;
    private String textAnswer;

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }



    public int getAnswerSetId() {
        return answerSetId;
    }

    public void setAnswerSetId(int answerSetId) {
        this.answerSetId = answerSetId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
