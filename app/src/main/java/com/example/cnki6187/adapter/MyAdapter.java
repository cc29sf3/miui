package com.example.cnki6187.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cnki6187.entity.User;
import com.example.cnki6187.miui.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by cnki6187 on 2017/10/10.
 */

public class MyAdapter extends BaseAdapter {
    List<User> userlist;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context,List<User> users)
    {
        layoutInflater=LayoutInflater.from(context);
        userlist=users;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Override
    public Object getItem(int position) {
        return userlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user =userlist.get(position);
        ViewHolder viewHolder=null;
        if(convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.my_listitem,null);
            viewHolder.textAge=(TextView)convertView.findViewById(R.id.textAge);
            viewHolder.textName=(TextView)convertView.findViewById(R.id.textName);
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.textName.setText(user.getName());
        viewHolder.textAge.setText(String.valueOf(user.getAge()));
        viewHolder.imageView.setImageResource(user.getImageID());
        return convertView;
    }

    public static  class ViewHolder{
        public TextView textName;
        public TextView textAge;
        public ImageView imageView;
    }
}
