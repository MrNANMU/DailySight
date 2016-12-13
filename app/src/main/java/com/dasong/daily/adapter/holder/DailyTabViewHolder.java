package com.dasong.daily.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dasong.daily.R;

/**
 * Created by dason on 2016/12/13 0013.
 */

public class DailyTabViewHolder extends RecyclerView.ViewHolder {

    public int postion = 0 ;

    public LinearLayout dailyItem_hasTitle = null ;
    public LinearLayout dailyItem_noTitle = null ;

    public TextView dailyItem_time = null ;
    public TextView dailyItem_title = null ;
    public TextView dailyItem_words = null ;
    public LinearLayout dailyItem_cover = null ;

    public TextView dailyItem_time_sim = null ;
    public TextView dailyItem_words_sim = null ;

    public DailyTabViewHolder(View itemView) {
        super(itemView);

        this.dailyItem_hasTitle = (LinearLayout)itemView.findViewById(R.id.dailyItem_hasTitle) ;
        this.dailyItem_noTitle = (LinearLayout)itemView.findViewById(R.id.dailyItem_noTitle) ;

        this.dailyItem_cover = (LinearLayout)itemView.findViewById(R.id.dailyItem_cover) ;
        this.dailyItem_time = (TextView)itemView.findViewById(R.id.dailyItem_time) ;
        this.dailyItem_title = (TextView)itemView.findViewById(R.id.dailyItem_title) ;
        this.dailyItem_words = (TextView)itemView.findViewById(R.id.dailyItem_words) ;

        this.dailyItem_time_sim = (TextView)itemView.findViewById(R.id.dailyItem_time_sim) ;
        this.dailyItem_words_sim = (TextView)itemView.findViewById(R.id.dailyItem_words_sim) ;
    }
}
