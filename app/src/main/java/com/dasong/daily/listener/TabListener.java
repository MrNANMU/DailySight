package com.dasong.daily.listener;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.dasong.daily.R;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class TabListener implements TabLayout.OnTabSelectedListener {

    private static final int MODEL_TAB = 0 ;
    private static final int DAILY_TAB = 1 ;
    private static final int PREDICTION_TAB = 2 ;

    private View view = null ;

    public TabListener(View view){
        this.view = view ;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case MODEL_TAB :
                tab.setIcon(R.drawable.icon_model_clicked) ;
                view.setOnClickListener(new ButtonClickedListener(view,MODEL_TAB));
                break;
            case DAILY_TAB :
                tab.setIcon(R.drawable.icon_daily_clicked) ;
                view.setOnClickListener(new ButtonClickedListener(view,DAILY_TAB));
                break;
            case PREDICTION_TAB :
                tab.setIcon(R.drawable.icon_prediction_clicked) ;
                view.setOnClickListener(new ButtonClickedListener(view,PREDICTION_TAB));
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0 :
                tab.setIcon(R.drawable.icon_model_unclicked) ;
                break;
            case 1 :
                tab.setIcon(R.drawable.icon_daily_unclicked) ;
                break;
            case 2 :
                tab.setIcon(R.drawable.icon_prediction_unclicked) ;
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
