package com.example.angeles.labapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Angeles on 4/10/2018.
 */
@Entity(foreignKeys = @ForeignKey(entity = Forms.class,
        parentColumns = "formId",
        childColumns = "formId",
        onDelete = CASCADE))

public class Questions {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int questionId;
    private String textQuestion;
    private String typeQuestion;
    private int formId;

    @NonNull
    public int getQuestionId() {
        return questionId;
    }



    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public int getFormId() {
        return formId;
    }



    public void setQuestionId(@NonNull int questionId) {
        this.questionId = questionId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }
}
