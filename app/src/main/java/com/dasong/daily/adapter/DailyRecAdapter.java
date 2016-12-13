package com.dasong.daily.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dasong.daily.R;
import com.dasong.daily.adapter.holder.DailyTabViewHolder;
import com.dasong.daily.bean.Bean;
import com.dasong.daily.bean.DailyBean;

import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

/**
 * Created by dason on 2016/12/11 0011.
 */

public class DailyRecAdapter extends RecyclerView.Adapter<DailyTabViewHolder> {

    private static final int HASTITLE = 0 ;
    private static final int NOTITLE = 1 ;

    private Context mContext = null ;
    private List<? extends Bean> mDatas = null ;
    private LayoutInflater mInflater = null ;
    private int mRes = 0 ;

    public DailyRecAdapter(Context context, List<? extends Bean> datas, int res){
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
        DailyBean daily = (DailyBean)this.mDatas.get(position) ;
        holder.postion = position ;
        switch (daily.getType()){

            case HASTITLE :
                holder.dailyItem_noTitle.setVisibility(View.INVISIBLE);
                holder.dailyItem_hasTitle.setVisibility(View.VISIBLE);
                holder.dailyItem_time.setText(daily.getTime());
                holder.dailyItem_title.setText(daily.getTitle());
                holder.dailyItem_words.setText(daily.getWords());
                switch (new Random().nextInt(3)){
                    case 0 :
                        holder.dailyItem_cover.setBackgroundResource(R.color.colorIconPurple);
                        break ;
                    case 1 :
                        holder.dailyItem_cover.setBackgroundResource(R.color.colorIconPurpleDark);
                        break ;
                    case 2 :
                        holder.dailyItem_cover.setBackgroundResource(R.color.colorIconYellow);
                        break ;
                }
                break;
            case NOTITLE :
                holder.dailyItem_hasTitle.setVisibility(View.INVISIBLE);
                holder.dailyItem_noTitle.setVisibility(View.VISIBLE);
                holder.dailyItem_time_sim.setText(daily.getTime());
                holder.dailyItem_words_sim.setText(daily.getWords());
                switch (new Random().nextInt(3)){
                    case 0 :
                        holder.dailyItem_time_sim.setBackgroundResource(R.color.colorIconPurple);
                        break ;
                    case 1 :
                        holder.dailyItem_time_sim.setBackgroundResource(R.color.colorIconPurpleDark);
                        break ;
                    case 2 :
                        holder.dailyItem_time_sim.setBackgroundResource(R.color.colorIconYellow);
                        break ;
                }
                break ;
        }

    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }
}

