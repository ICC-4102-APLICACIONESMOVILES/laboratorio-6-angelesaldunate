package com.example.angeles.labapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Angeles on 5/9/2018.
 */

public class AnswerAdapter  extends ArrayAdapter<AnswerSet> {
    public AnswerAdapter(Context context, List<AnswerSet> answer) {
        super(context, 0, answer);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        AnswerSet answerSet = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_answerset_adapter, parent, false);
        }
        // Lookup view for data population
        TextView frName = (TextView) convertView.findViewById(R.id.textViewnombre);
        TextView frDate = (TextView) convertView.findViewById(R.id.textViewfecha);
        TextView frCategorie = (TextView) convertView.findViewById(R.id.textViewcategoria);
        TextView frDescription = (TextView) convertView.findViewById(R.id.textViewdescripcion);
        // Populate the data into the template view using the data object
        String lati = new Double(answerSet.getLat()).toString();
        String longi =new Double(answerSet.getLog()).toString();

        String getid = new Integer(answerSet.getFormId()).toString();
        frName.setText(getid);
        frDate.setText(answerSet.getDate());
        frCategorie.setText(lati);
        frDescription.setText(longi);

        // Return the completed view to render on screen
        return convertView;
    }
}