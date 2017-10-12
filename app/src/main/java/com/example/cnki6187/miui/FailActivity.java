package com.example.cnki6187.miui;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cnki6187.adapter.MySpinnerAdapter;
import com.example.cnki6187.contentProvider.MySqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class FailActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private Spinner spinner;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextName=(EditText)findViewById(R.id.et_Name);
        editTextAge=(EditText)findViewById(R.id.et_Age);
        buttonAdd=(Button)findViewById(R.id.button_Add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDatabase();
            }
        });

        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(R.drawable.body);
        list.add(R.drawable.foot);
        list.add(R.drawable.head);
        MySpinnerAdapter adapter=new MySpinnerAdapter(this,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FailActivity.this,String.valueOf(id),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Intent intent =getIntent();
        if(intent.getAction()==SucActivity.ACTION)
        {
            editTextName.setText(intent.getStringExtra("name"));
            editTextAge.setText(String.valueOf(intent.getIntExtra("age",0)));
            spinner.setSelection(list.indexOf(intent.getIntExtra("image",0)));
        }
    }

    private void addDatabase(){
        Uri uri = Uri.parse("content://com.example.cnki6187.contentProvider.MyContentProvider/users");
        ContentValues cv=new ContentValues(3);
        cv.put(MySqliteHelper.TestTable.COLUMN_NAME_NAME,editTextName.getText().toString());
        cv.put(MySqliteHelper.TestTable.COLUMN_NAME_AGE,Integer.valueOf(editTextAge.getText().toString()));
        cv.put(MySqliteHelper.TestTable.COLUMN_NAME_HEAD_ID,spinner.getSelectedItemId());
        getContentResolver().insert(uri,cv);
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
    }

}
