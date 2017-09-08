package com.ideas2it.parkinglot;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PeekingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peeking);
    }


    public void findSlotStatus(View view){
        Context context = getApplicationContext();
        CharSequence text = null;
        EditText editText = (EditText) findViewById(R.id.slotNo);
        int slotNumber = Integer.valueOf(editText.getText().toString());
        if(DataHolder.peek(slotNumber)){
            text = "Slot is occupied";
        }
        else{
            text = "Slot is vacant";
        }
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
