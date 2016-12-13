package com.dasong.daily.listener;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.dasong.daily.activitys.NewDailyActivity;

import java.util.List;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class ButtonClickedListener implements View.OnClickListener {

    private static final int MODEL_TAB = 0 ;
    private static final int DAILY_TAB = 1 ;
    private static final int PREDICTION_TAB = 2 ;

    private int position = 0 ;
    private View view = null ;

    public ButtonClickedListener(View view,int position){
        this.position = position ;
        this.view = view ;
    }
    @Override
    public void onClick(View v) {
        switch (this.position){
            case MODEL_TAB :
                Snackbar.make(this.view,"新建速写",Snackbar.LENGTH_SHORT).show();
                Log.v("ZHENG:",this.position+"") ;
                break;
            case DAILY_TAB :
                Intent intent = new Intent(view.getContext(), NewDailyActivity.class) ;
                view.getContext().startActivity(intent);
                Log.v("ZHENG:",this.position+"") ;
                break;
            case PREDICTION_TAB :
                Snackbar.make(this.view,"新建预言",Snackbar.LENGTH_SHORT).show();
                Log.v("ZHENG:",this.position+"") ;
                break;
        }
    }
}
