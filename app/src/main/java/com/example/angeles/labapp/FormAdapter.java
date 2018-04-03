package com.example.angeles.labapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angeles on 4/3/2018.
 */

public class FormAdapter extends ArrayAdapter<Forms> {
    public FormAdapter(Context context, List<Forms> forms) {
        super(context, 0, forms);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Forms forms = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_form_adapter, parent, false);
        }
        // Lookup view for data population
        TextView frName = (TextView) convertView.findViewById(R.id.textViewnombre);
        TextView frDate = (TextView) convertView.findViewById(R.id.textViewfecha);
        TextView frCategorie = (TextView) convertView.findViewById(R.id.textViewcategoria);
        TextView frDescription = (TextView) convertView.findViewById(R.id.textViewdescripcion);
        // Populate the data into the template view using the data object
        frName.setText(forms.getFormName());
        frDate.setText(forms.getFormDate());
        frCategorie.setText(forms.getFormCategorie());
        frDescription.setText(forms.getFormDescription());

        // Return the completed view to render on screen
        return convertView;
    }
}