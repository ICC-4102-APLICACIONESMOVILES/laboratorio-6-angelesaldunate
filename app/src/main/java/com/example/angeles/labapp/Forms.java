package com.example.angeles.labapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Angeles on 4/3/2018.
 */

@Entity
public class Forms {
    @NonNull
    @PrimaryKey
    private String formId;
    private String formName;
    private String formDate;
    private String formDescription;
    private String formCategorie;

    public Forms() {
    }

    public String getFormId() { return formId; }
    public void setFormId(String formId) { this.formId = formId; }
    public String getFormName() { return formName; }
    public void setFormName (String formName) { this.formName = formName; }
    public String getFormDate() { return formDate; }
    public void setFormDate(String formDate) { this.formDate = formDate; }
    public String getFormDescription() { return formDescription; }
    public void setFormDescription(String formDescription) { this.formDescription = formDescription; }
    public String getFormCategorie() { return formCategorie; }
    public void setFormCategorie(String formCategorie) { this.formCategorie = formCategorie; }




}