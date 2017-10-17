package com.example.cnki6187.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cnki6187.miui.R;
import com.example.cnki6187.miui.Recycle;

import java.util.List;

/**
 * Created by cnki6187 on 2017/10/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<String> mDatas;
    private Context mContext;

    public HomeAdapter(List<String> datas,Context context)
    {
        mDatas=datas;
        mContext=context;
    }

    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        MyViewHolder myViewHolder=new MyViewHolder(layoutInflater.inflate(R.layout.recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View view){
            super(view);
            tv=(TextView)view.findViewById(R.id.id_num);
        }
    }
}
