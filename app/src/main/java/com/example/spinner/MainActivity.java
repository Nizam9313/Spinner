package com.example.spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout mlayout = findViewById(R.id.laidout);
        ArrayList<String> list = new ArrayList<>();
        list.add("White");
        list.add("Red");
        list.add("Pink");
        list.add("Purple");
        list.add("Green");
        list.add("Violet");
        list.add("Black");
        ArrayAdapter adapter = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,list);
        Spinner sp = (Spinner) findViewById(R.id.sp1);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),sp.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                if(sp.getSelectedItem().toString() == "Red")
                    mlayout.setBackgroundColor(Color.RED);
                else if(sp.getSelectedItem().toString() == "Pink")
                    mlayout.setBackgroundColor(Color.rgb(255,105,180));
                else if(sp.getSelectedItem().toString() == "Purple")
                    mlayout.setBackgroundColor(Color.rgb(98,0,238));
                else if(sp.getSelectedItem().toString() == "Green")
                    mlayout.setBackgroundColor(Color.GREEN);
                else if(sp.getSelectedItem().toString() == "Violet")
                    mlayout.setBackgroundColor(Color.rgb(143,0,255));
                else if(sp.getSelectedItem().toString() == "Black") {
                    mlayout.setBackgroundColor(Color.DKGRAY);
                }
                else {
                    mlayout.setBackgroundColor(Color.WHITE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure you want to Exit?");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}