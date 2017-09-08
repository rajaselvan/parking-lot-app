package com.ideas2it.parkinglot;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Long> slotAllocations = DataHolder.fetchAll();
        List<String>listItems = null;
        if(slotAllocations.size()>0){
            listItems = new ArrayList<>();
            for(int i = 0; i < slotAllocations.size(); i++){
                if(slotAllocations.get(i)!=-1){
                    listItems.add(String.format("%1$s is parket at slot %2$s", String.valueOf(slotAllocations.get(i)), i));
                }
            }
            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom_row_layout, R.id.textView1, listItems);
            setListAdapter(adapter);
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Empty Parking Lot";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
