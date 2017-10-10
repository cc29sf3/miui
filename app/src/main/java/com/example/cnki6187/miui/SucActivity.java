package com.example.cnki6187.miui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cnki6187.adapter.MyAdapter;
import com.example.cnki6187.entity.User;

import java.util.ArrayList;
import java.util.List;

public class SucActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suc);
        listView=(ListView)findViewById(R.id.myList);
        MyAdapter myAdapter =new MyAdapter(this,getUsers());
        listView.setAdapter(myAdapter);
    }

    private List<User> getUsers()
    {
        List<User> list=new ArrayList<User>();
        list.add(new User("关羽",39,R.drawable.body));
        list.add(new User("张飞",39,R.drawable.foot));
        list.add(new User("曹操",39,R.drawable.head));
        list.add(new User("许褚",39,R.drawable.body));
        list.add(new User("赵云",39,R.drawable.head));
        list.add(new User("黄忠",39,R.drawable.body));
        list.add(new User("魏延",39,R.drawable.head));
        list.add(new User("张辽",39,R.drawable.body));
        list.add(new User("典韦",39,R.drawable.foot));
        list.add(new User("吕布",39,R.drawable.body));
        list.add(new User("马超",39,R.drawable.foot));
        list.add(new User("李典",39,R.drawable.foot));
        return list;
    }
}
