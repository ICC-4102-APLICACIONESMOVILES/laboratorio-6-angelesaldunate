package com.example.angeles.labapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnswerContent.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnswerContent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerContent extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String DATABASE_NAME = "movies_db";


    private OnFragmentInteractionListener mListener;

    public AnswerContent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnswerContent.
     */
    // TODO: Rename and change types and number of parameters
    public static AnswerContent newInstance(String param1, String param2) {
        AnswerContent fragment = new AnswerContent();
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
        return inflater.inflate(R.layout.fragment_answer_content, container, false);
    }


    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        final int myInt = bundle.getInt("Awnset_Id");
        final FormDatabase formDatabase = Room.databaseBuilder(getContext(), FormDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();
        final TextView fId = (TextView) view.findViewById(R.id.formIdAns);
        final TextView frDate = (TextView) view.findViewById(R.id.dateAnsw);
        final TextView frLat = (TextView) view.findViewById(R.id.LatitAns);
        final TextView frLog = (TextView) view.findViewById(R.id.LongAnsw);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AnswerSet answerSet = formDatabase.daoAnswer().fetchOneSetAnswerbySetAnswerId(myInt);


                Handler mainHandler = new Handler(getActivity().getMainLooper());
                mainHandler.post(new Runnable() {
                    public void run() {


                        String date = answerSet.getDate();
                        String lat = new Double(answerSet.getLat()).toString();
                        String longit = new Double(answerSet.getLog()).toString();
                        frDate.setText(date);
                        frLat.setText(lat);
                        frLog.setText(longit);


                    }

                });




            }
        }) .start();

        Button button = (Button) view.findViewById(R.id.botonMapa);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent inte = new Intent(getContext(), MapsActivity.class);
                startActivity(inte);
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
