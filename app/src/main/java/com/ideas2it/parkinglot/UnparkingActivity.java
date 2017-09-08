package com.ideas2it.parkinglot;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class UnparkingActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unparking);
    }

    public void unparkTheCar(View view){
        EditText editText = (EditText) findViewById(R.id.unparkingCarNo);
        Long carNumber = Long.valueOf(editText.getText().toString());
        String message = null;
        int slotNumber = DataHolder.poll(carNumber);
        if(slotNumber!=-1){
            DataHolder.remove(carNumber);
            message = String.format("%1$s unparked from slot %2$s", carNumber, slotNumber);
        }
        else {
            message = "Car is not parked here";
        }
        linearLayout = (LinearLayout) findViewById(R.id.unparkingLayout);
        Snackbar snackbar = Snackbar
                .make(linearLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
