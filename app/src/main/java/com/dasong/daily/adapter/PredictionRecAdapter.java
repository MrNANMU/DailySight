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

/**
 * Created by dason on 2016/12/11 0011.
 */

public class PredictionRecAdapter extends RecyclerView.Adapter<PredictionTabViewHolder> {

    private Context mContext = null ;
    private List<String> mDatas = null ;
    private LayoutInflater mInflater = null ;
    private int mRes = 0;

    public PredictionRecAdapter(Context context, List<String> datas,int res){
        this.mContext = context ;
        this.mDatas = datas ;
        this.mInflater = LayoutInflater.from(context) ;
        this.mRes = res ;
    }

    @Override
    public PredictionTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(this.mRes,parent,false) ;
        PredictionTabViewHolder holder = new PredictionTabViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(PredictionTabViewHolder holder, int position) {
        holder.tv.setText(this.mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }
}
class PredictionTabViewHolder extends ViewHolder{

    TextView tv = null ;

    public PredictionTabViewHolder(View itemView) {
        super(itemView);
        this.tv = (TextView)itemView.findViewById(R.id.predictionItem_tv) ;
    }
}