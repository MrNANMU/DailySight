package com.dasong.daily.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dason on 2016/12/11 0011.
 */

public class RecAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext = null ;
    private List<String> mDatas = null ;
    private LayoutInflater mInflater = null ;
    private int mRes = 0 ;
    private MyViewHolder holder = null ;

    public RecAdapter(Context context,List<String> datas,int res,MyViewHolder holder){
        this.mContext = context ;
        this.mDatas = datas ;
        this.mInflater = LayoutInflater.from(context) ;
        this.mRes = res ;
        this.holder = holder ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return this.holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }
}

abstract class MyViewHolder extends ViewHolder{

    List<View> views = null ;

    public MyViewHolder(View itemView, List<View> views) {
        super(itemView);
        this.views = views ;
        this.initView();
    }

    abstract void initView();
}
