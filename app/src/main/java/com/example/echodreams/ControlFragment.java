package com.example.echodreams;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

public class ControlFragment extends Fragment {

    enum SendType { RECOGNITIONSEND, FIXINSEND, ENTRYSEND };

    interface OnFragmentSendDataListener {
        void onSendData(boolean data, SendType type);
    }

    private OnFragmentSendDataListener recognitionSendDataListener;
    private OnFragmentSendDataListener fixingSendDataListener;
    private OnFragmentSendDataListener entriesSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            recognitionSendDataListener = (OnFragmentSendDataListener) context;
            fixingSendDataListener = (OnFragmentSendDataListener) context;
            entriesSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " должен реализовывать интерфейс OnFragmentSendDataListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ToggleButton recognitionToggleButton = view.findViewById(R.id.recognitionProcessToggleButton);
        ToggleButton fixingToggleButton = view.findViewById(R.id.fixingEntryToggleButton);
        Button entriesButton = view.findViewById(R.id.goToEntriesButton);

        recognitionToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton toggleButton = view.findViewById(R.id.recognitionProcessToggleButton);
                recognitionSendDataListener.onSendData(toggleButton.isChecked(), SendType.RECOGNITIONSEND);
            }
        });

        fixingToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton toggleButton = view.findViewById(R.id.fixingEntryToggleButton);
                fixingSendDataListener.onSendData(toggleButton.isChecked(), SendType.FIXINSEND);
            }
        });

        entriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = view.findViewById(R.id.goToEntriesButton);
                entriesSendDataListener.onSendData(true, SendType.ENTRYSEND);
            }
        });
    }
}