package com.example.cnki6187.miui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cnki6187.adapter.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FailActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextName=(EditText)findViewById(R.id.et_Name);
        editTextAge=(EditText)findViewById(R.id.et_Age);

        spinner=(Spinner)findViewById(R.id.spinner);
        List<Integer> list=new ArrayList<Integer>();
        list.add(R.drawable.body);
        list.add(R.drawable.foot);
        list.add(R.drawable.head);
        SpinnerAdapter adapter=new SpinnerAdapter(this,list);
        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });
    }


}
