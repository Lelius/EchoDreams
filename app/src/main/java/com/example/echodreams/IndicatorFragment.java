package com.example.echodreams;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class IndicatorFragment extends Fragment {

    public IndicatorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indicator, container, false);
    }

    public void changeBackgroundColor(boolean data, ControlFragment.SendType sendType) {
        View view = this.getView();
        if(sendType == ControlFragment.SendType.RECOGNITIONSEND) {
            if (data == true)
                view.findViewById(R.id.indicatorEntryTextView).setBackgroundColor(Color.WHITE);
            else
                view.findViewById(R.id.indicatorEntryTextView).setBackgroundColor(Color.GRAY);

        } else if (sendType == ControlFragment.SendType.FIXINSEND) {
            if (data == true)
                view.findViewById(R.id.indicatorServiceInfoTextView).setBackgroundColor(Color.WHITE);
            else
                view.findViewById(R.id.indicatorServiceInfoTextView).setBackgroundColor(Color.GRAY);

        } else if (sendType == ControlFragment.SendType.ENTRYSEND) {
            if (data == true) {
                Intent intent = new Intent(this.getActivity(), EntriesActivity.class);
                startActivity(intent);
            }
        }
    }
}