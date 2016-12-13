package com.dasong.daily.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dasong.daily.R;
import com.dasong.daily.bean.Bean;
import com.dasong.daily.bean.DailyBean;

import java.util.List;
import java.util.Random;

/**
 * Created by dason on 2016/12/12 0012.
 */

public class SimpleDailyRecAdapter extends RecyclerView.Adapter<SimpleDailyTabViewHolder> {

    private Context mContext = null ;
    private List<? extends Bean> mDatas = null ;
    private LayoutInflater mInflater = null ;
    private int mRes = 0 ;

    public SimpleDailyRecAdapter(Context context, List<? extends Bean> datas, int res){
        this.mContext = context ;
        this.mDatas = datas ;
        this.mInflater = LayoutInflater.from(context) ;
        this.mRes = res ;
    }

    @Override
    public SimpleDailyTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view  = this.mInflater.inflate(this.mRes,parent,false) ;
        SimpleDailyTabViewHolder holder = new SimpleDailyTabViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleDailyTabViewHolder holder, int position) {
        DailyBean daily = (DailyBean)this.mDatas.get(position) ;
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
    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }
}

class SimpleDailyTabViewHolder extends RecyclerView.ViewHolder {

    TextView dailyItem_time_sim = null ;
    TextView dailyItem_words_sim = null ;

    public SimpleDailyTabViewHolder(View itemView) {
        super(itemView);
        this.dailyItem_time_sim = (TextView)itemView.findViewById(R.id.dailyItem_time_sim) ;
        this.dailyItem_words_sim = (TextView)itemView.findViewById(R.id.dailyItem_words_sim) ;
    }

}
