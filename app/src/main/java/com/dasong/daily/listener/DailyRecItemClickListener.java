package com.dasong.daily.listener;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dasong.daily.activitys.DailyShowActivity;
import com.dasong.daily.adapter.holder.DailyTabViewHolder;
import com.dasong.daily.util.OnRecyclerItemClickListener;

/**
 * Created by dason on 2016/12/13 0013.
 */

public class DailyRecItemClickListener extends OnRecyclerItemClickListener {

    private Context context = null ;
    private RecyclerView recyclerView = null ;

    public DailyRecItemClickListener(Context context,RecyclerView recyclerView) {
        super(recyclerView);
        this.context = context ;
        this.recyclerView = recyclerView ;
    }

    @Override
    public void onItemClick(RecyclerView.ViewHolder vh) {
        DailyTabViewHolder dHolder = (DailyTabViewHolder) vh ;
        int position = dHolder.postion ;
        String title = dHolder.dailyItem_title.getText().toString() ;
        String words = null ;
        if(title == ""){
            words = dHolder.dailyItem_words_sim.getText().toString() ;
        }else{
            words = dHolder.dailyItem_words.getText().toString() ;
        }
        Intent intent = new Intent(this.context,DailyShowActivity.class) ;
        intent.putExtra("position",position) ;
        intent.putExtra("title",title) ;
        intent.putExtra("words",words) ;
        this.context.startActivity(intent);
    }

    @Override
    public void onItemLongClick(RecyclerView.ViewHolder vh) {
        Log.e("ZHENG:","长按") ;
    }

}
