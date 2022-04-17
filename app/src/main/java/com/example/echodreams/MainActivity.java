package com.example.echodreams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ControlFragment.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(boolean data, ControlFragment.SendType type) {
        IndicatorFragment indicatorFragment = (IndicatorFragment) getSupportFragmentManager().findFragmentById(R.id.indicatorFragmentInMain);
        indicatorFragment.changeBackgroundColor(data, type);
    }
}