package com.example.cnki6187.miui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cnki6187.adapter.DividerItemDecoration;
import com.example.cnki6187.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class Recycle extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycle);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        initData();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mAdapter=new HomeAdapter(mDatas,this));
//        LinearLayoutManager lm= new LinearLayoutManager(this);
//        lm.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(lm);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
//       recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }


}
