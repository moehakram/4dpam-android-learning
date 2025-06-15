package com.example.a213049_muhakram;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class tgs_layout extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tgs_layout);

    }

    public void onRadioButtonClicked(View a) {
        ViewFlipper viewFlipper = findViewById(R.id.view_flipper);
        boolean checked = ((RadioButton) a).isChecked();

        switch (a.getTag().toString()) {
            case "0":
                if (checked) {
                    viewFlipper.setDisplayedChild(0);
                }
                break;

            case "1":
                if (checked) {
                    viewFlipper.setDisplayedChild(1);
                }
                break;
        }
    }
}



