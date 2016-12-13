package com.dasong.daily.listener;


import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.dasong.daily.activitys.DailyActivity;
import com.dasong.daily.activitys.NewDailyActivity;


/**
 * Created by dason on 2016/12/12 0012.
 */

public class SaveDailyInDbListener implements View.OnClickListener {

    private static final int NEW_DAILY = 0 ;
    private static final int OLD_DAILY = 1 ;

    private DailyActivity activity = null ;
    private boolean isFirstSave = true ;

    private int type = 0 ;

    public SaveDailyInDbListener(Context context){
        this.activity = (DailyActivity)context ;
    }

    public SaveDailyInDbListener(Context context,int type){
        this.activity = (DailyActivity)context ;
        this.type = type ;
    }

    @Override
    public void onClick(View v) {
        this.save(this.type) ;
        Toast.makeText(this.activity,"已保存",Toast.LENGTH_SHORT).show();
    }

    private void save(int type){
        switch (type){
            case NEW_DAILY :
                if(this.isFirstSave){
                    this.activity.createDaily() ;
                    this.isFirstSave = false ;
                }else{
                    this.activity.updateDaily() ;
                }
                break;
            case OLD_DAILY :
                this.activity.updateDaily() ;
                break;
        }

    }

}
