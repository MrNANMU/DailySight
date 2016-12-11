package com.dasong.daily.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dasong.daily.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dason on 2016/12/11 0011.
 */

public class DailyRecAdapter extends RecyclerView.Adapter<DailyTabViewHolder> {

    private Context mContext = null ;
    private List<String> mDatas = null ;
    private LayoutInflater mInflater = null ;
    private int mRes = 0 ;

    public DailyRecAdapter(Context context,List<String> datas,int res){
        this.mContext = context ;
        this.mDatas = datas ;
        this.mInflater = LayoutInflater.from(context) ;
        this.mRes = res ;
    }

    @Override
    public DailyTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view  = this.mInflater.inflate(this.mRes,parent,false) ;
        DailyTabViewHolder holder = new DailyTabViewHolder(view) ;

        return holder;
    }

    @Override
    public void onBindViewHolder(DailyTabViewHolder holder, int position) {
        holder.tv.setText(this.mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }
}

class DailyTabViewHolder extends ViewHolder {

    TextView tv = null ;
    public DailyTabViewHolder(View itemView) {
        super(itemView);
        this.tv = (TextView) itemView.findViewById(R.id.dailyItem_tv) ;
    }
}
