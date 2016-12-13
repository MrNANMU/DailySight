package com.dasong.daily.activitys;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.dasong.daily.R;
import com.dasong.daily.bean.DailyBean;
import com.dasong.daily.db.DailyDadabaseHelper;
import com.dasong.daily.listener.SaveDailyInDbListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dason on 2016/12/13 0013.
 */

public abstract class DailyActivity extends AppCompatActivity {

    protected TextInputLayout newDaily_editWapper = null ;
    protected EditText newDaily_titleEdit = null ;
    protected EditText newDaily_words = null ;
    protected Toolbar newDaily_ToolBar = null ;
    protected FloatingActionButton newDaily_addDaily = null ;
    protected TextView newDaily_time = null ;
    protected DailyBean bean = null ;

    protected DailyDadabaseHelper dbHelper = null ;
    protected SQLiteDatabase db = null ;

    protected boolean isFirstSave = true ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdaily);
        this.initView() ;
        this.initEvent() ;
    }

    protected void initView(){
        this.initBar();
        this.newDaily_editWapper = (TextInputLayout)findViewById(R.id.newDaily_editWapper) ;
        this.newDaily_titleEdit = (EditText)findViewById(R.id.newDaily_titleEdit) ;
        this.newDaily_time = (TextView)findViewById(R.id.newDaily_time) ;
        this.newDaily_words = (EditText)findViewById(R.id.newDaily_words) ;
        this.newDaily_addDaily = (FloatingActionButton)findViewById(R.id.newDaily_addDaily) ;
        this.newDaily_time.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    protected void initEvent(){
        this.saveInDb() ;
    }

    protected void initBar() {
        this.newDaily_ToolBar = (Toolbar)findViewById(R.id.newDaily_ToolBar) ;
        this.setBarTitle();
        this.setSupportActionBar(this.newDaily_ToolBar);
    }

    protected void getDb(){
        this.dbHelper = new DailyDadabaseHelper(this,"DailyBase.db",null,1) ;
        this.db = this.dbHelper.getReadableDatabase() ;
    }


    public abstract void setBarTitle() ;

    public abstract void createDaily() ;

    public abstract void updateDaily() ;

    public abstract void saveInDb() ;


}
