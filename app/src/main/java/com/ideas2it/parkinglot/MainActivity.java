package com.ideas2it.parkinglot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendOption(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.menu_options);
        int checkedButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(checkedButtonId);
        String option = radioButton.getText().toString();
        Intent intent = null;
        switch (option){
            case "I want to park my car":
                intent = new Intent(this, ParkingActivity.class);
                startActivity(intent);
                break;
            case "I want to unpark my car":
                intent = new Intent(this, UnparkingActivity.class);
                startActivity(intent);
                break;
            case "Check a slot":
                intent = new Intent(this, PeekingActivity.class);
                startActivity(intent);
                break;
            case "Display Slot Allocations":
                intent = new Intent(this, DisplayActivity.class);
                startActivity(intent);
                break;
            case "Exit":
                finish();
        }
    }
}
