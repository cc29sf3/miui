package com.example.cnki6187.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ImageView;

import com.example.cnki6187.miui.R;

import java.util.List;

/**
 * Created by cnki6187 on 2017/10/11.
 */

public class MySpinnerAdapter extends BaseAdapter implements SpinnerAdapter {
    List<Integer> list;
    Context context;
    public MySpinnerAdapter(Context context,List<Integer> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.spinner,null);
        if(convertView!=null){
            ImageView imageView=(ImageView) convertView.findViewById(R.id.imageView3);
            imageView.setImageResource(list.get(position));
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.spinneritem,null);
        if(convertView!=null){
            ImageView imageView=(ImageView) convertView.findViewById(R.id.imageView2);
            imageView.setImageResource(list.get(position));
        }
        return convertView;
    }
}
