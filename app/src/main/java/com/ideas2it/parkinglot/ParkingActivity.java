package com.ideas2it.parkinglot;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ParkingActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
    }

    public void parkTheCar(View view){
        EditText editText = (EditText) findViewById(R.id.parkingCarNo);
        Long carNumber = Long.valueOf(editText.getText().toString());
        linearLayout = (LinearLayout) findViewById(R.id.parkingLayout);
        String message = null;
        if(DataHolder.poll(carNumber)==-1){
            DataHolder.insert(carNumber);
            message = String.format("%1$s parked at slot %2$s", carNumber, DataHolder.poll(carNumber));
        }
        else {
            message = "Same car number already parked";
        }
        Snackbar snackbar = Snackbar
                .make(linearLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
