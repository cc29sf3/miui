package com.example.cnki6187.miui;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cnki6187.adapter.MyAdapter;
import com.example.cnki6187.contentProvider.MyContentProvider;
import com.example.cnki6187.contentProvider.MySqliteHelper;
import com.example.cnki6187.entity.User;

import java.util.ArrayList;
import java.util.List;

public class SucActivity extends AppCompatActivity {

    private ListView listView;
    public static final String  ACTION="SUC_ACTION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suc);
        listView=(ListView)findViewById(R.id.myList);
        MyAdapter myAdapter =new MyAdapter(this,getUsers());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user=(User)parent.getItemAtPosition(position);
                Intent intent =new Intent(SucActivity.this,FailActivity.class);
                intent.setAction(ACTION);
                intent.putExtra("name",user.getName());
                intent.putExtra("age",user.getAge());
                intent.putExtra("image",user.getImageID());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                view.get
            }
        });

    }

    private List<User> getUsers()
    {
        List<User> list=new ArrayList<User>();
        String[] projection=new String[]{MySqliteHelper.TestTable.COLUMN_NAME_NAME,
                MySqliteHelper.TestTable.COLUMN_NAME_AGE,
                MySqliteHelper.TestTable.COLUMN_NAME_HEAD_ID};
        Cursor cursor=getContentResolver().query(MyContentProvider.uri,projection,null,null,null);
        while (cursor.moveToNext())
        {
            String name=cursor.getString(0);
            int age=cursor.getInt(1);
            int id=cursor.getInt(2);
            list.add(new User(name,age,id));
        }
        cursor.close();
        return list;
    }
}
