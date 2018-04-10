package com.example.angeles.labapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnswerForm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnswerForm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerForm extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private static final String DATABASE_NAME = "movies_db";

    public AnswerForm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnswerForm.
     */
    // TODO: Rename and change types and number of parameters
    public static AnswerForm newInstance(String param1, String param2) {
        AnswerForm fragment = new AnswerForm();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answer_form, container, false);
    }
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button button = (Button) view.findViewById(R.id.buttonsendanswer);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FormDatabase formDatabase= Room.databaseBuilder(view.getContext(),FormDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();

                EditText editTextnam = (EditText) view.findViewById(R.id.editTextQ1);
                final String name = editTextnam.getText().toString();

                EditText editTextLn = (EditText) view.findViewById(R.id.editTextQ2);
                final String date = editTextLn.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AnswerSet anset =new AnswerSet();
                        //form.setFormId(unixTime1);
                        //anset.setFormName(name);
                        //form.setFormDate(date);
                        //form.setFormDescription(des);
                        //form.setFormCategorie(typ);
                        //formDatabase.daoAccess () . insertOnlySingleForm (form);
                    }
                }) .start();
            }



        });





    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
