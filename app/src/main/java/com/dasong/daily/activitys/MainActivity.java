package com.dasong.daily.activitys;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.dasong.daily.R;
import com.dasong.daily.adapter.FragmentAdapter;
import com.dasong.daily.fragments.DailyFragment;
import com.dasong.daily.fragments.ModelFragment;
import com.dasong.daily.fragments.PredictionFragment;
import com.dasong.daily.listener.ButtonClickedListener;
import com.dasong.daily.listener.TabListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dason on 2016/12/8 0008.
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar = null ;
    private TabLayout tabBar = null ;
    private ViewPager viewPager = null ;
    private ModelFragment model = null ;
    private DailyFragment daily = null ;
    private PredictionFragment prediction = null ;
    private List<Fragment> mFragments = null ;
    private FragmentAdapter mAdapter = null ;
    private TabLayout.Tab tabModel = null ;
    private TabLayout.Tab tabDaily = null ;
    private TabLayout.Tab tabPrediction = null ;
    private FloatingActionButton button = null ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initView();
        this.initEvent() ;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.daily.updateList();
    }

    private void initView(){
        this.initBar() ;
        this.initTab();
        this.button = (FloatingActionButton)findViewById(R.id.button) ;
    }

    private void initEvent(){
        this.tabClickedEvent();
        this.floatBtnEvent();
    }

    private void initBar() {

        this.toolBar = (Toolbar)findViewById(R.id.toolBar) ;
        this.toolBar.setTitle("光景日记");
        //this.toolBar.setSubtitle("子标题");
        //this.toolBar.setLogo(R.drawable.icon_menu);
        this.setSupportActionBar(this.toolBar);
        //加了Logo位置会异常，未解决
    }


    private void initViewPager(){

        this.viewPager = (ViewPager)findViewById(R.id.viewPager) ;
        this.model = new ModelFragment() ;
        this.daily = new DailyFragment() ;
        this.prediction = new PredictionFragment() ;
        this.mFragments = new ArrayList<Fragment>() ;
        this.mFragments.add(this.model) ;
        this.mFragments.add(this.daily) ;
        this.mFragments.add(this.prediction) ;
        this.mAdapter = new FragmentAdapter(this.getSupportFragmentManager(),this.mFragments);
        this.viewPager.setAdapter(this.mAdapter);
        this.viewPager.setCurrentItem(1);


    }

    private void initTab(){

        this.tabBar = (TabLayout)findViewById(R.id.tabBar) ;
        this.tabModel = this.tabBar.newTab() ;
        this.tabDaily = this.tabBar.newTab() ;
        this.tabPrediction = this.tabBar.newTab() ;
        this.tabBar.addTab(this.tabPrediction);
        this.tabBar.addTab(this.tabDaily);
        this.tabBar.addTab(this.tabModel);
        this.initViewPager();
        this.tabBar.setupWithViewPager(this.viewPager);
        this.tabBar.getTabAt(0).setText("速写").setIcon(R.drawable.icon_model_unclicked) ;
        this.tabBar.getTabAt(1).setText("日记").setIcon(R.drawable.icon_daily_clicked) ;
        this.tabBar.getTabAt(2).setText("预言").setIcon(R.drawable.icon_prediction_unclicked) ;
        this.tabBar.getTabAt(1).select() ;
    }



    private void tabClickedEvent(){
        this.tabBar.addOnTabSelectedListener(new TabListener(this.button));
    }

    private void floatBtnEvent(){
        this.button.setOnClickListener(new ButtonClickedListener(this.button,this.tabBar.getSelectedTabPosition()));
    }

}
