package com.dasong.daily.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasong.daily.R;
import com.dasong.daily.adapter.DailyRecAdapter;
import com.dasong.daily.bean.DailyBean;
import com.dasong.daily.db.DailyDadabaseHelper;
import com.dasong.daily.listener.DailyRecItemClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class DailyFragment extends Fragment {

    private View view = null ;
    private RecyclerView dailyRecView = null ;
    private List<DailyBean> mdatas = null ;
    private DailyRecAdapter adapter = null ;
    private DailyDadabaseHelper dbHelper = null ;
    private SQLiteDatabase db = null ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_daily,container,false) ;
        this.initView();
        this.initEvent();
        return view ;
    }

    private void getDb(){
        this.dbHelper = new DailyDadabaseHelper(this.getActivity(),"DailyBase.db",null,1) ;
        this.db = this.dbHelper.getReadableDatabase() ;
    }

    private void initView(){

        this.dailyRecView = (RecyclerView)view.findViewById(R.id.dailyRecView) ;
        this.mdatas = new ArrayList<DailyBean>() ;
        this.getTextInDb();
        /*Cursor cursor = this.db.query("daily",null,null,null,null,null,null) ;
        if(cursor.moveToFirst()){
            do{
                DailyBean dailyBean = new DailyBean() ;
                dailyBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                dailyBean.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                dailyBean.setWords(cursor.getString(cursor.getColumnIndex("words")));
                dailyBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                dailyBean.setPosition(cursor.getInt(cursor.getColumnIndex("id")));
                this.mdatas.add(dailyBean) ;
            }while (cursor.moveToNext()) ;
        }
        cursor.close();
        this.db.close();
        this.adapter = new DailyRecAdapter(this.getActivity(),this.mdatas,R.layout.item_dailytab) ;
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false) ;
        this.dailyRecView.setLayoutManager(manager);
        this.dailyRecView.setAdapter(this.adapter);*/
        this.dailyRecView.addOnItemTouchListener(new DailyRecItemClickListener(this.getActivity(),this.dailyRecView));
    }

    private void getTextInDb(){
        this.getDb() ;
        Cursor cursor = this.db.query("daily",null,null,null,null,null,null) ;
        if(cursor.moveToFirst()){
            do{
                DailyBean dailyBean = new DailyBean() ;
                dailyBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                dailyBean.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                dailyBean.setWords(cursor.getString(cursor.getColumnIndex("words")));
                dailyBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                dailyBean.setPosition(cursor.getInt(cursor.getColumnIndex("id")));
                Log.e("ZHENG:",dailyBean.getWords()) ;
                this.mdatas.add(dailyBean) ;
            }while (cursor.moveToNext()) ;
        }
        cursor.close();
        this.db.close();
        this.adapter = new DailyRecAdapter(this.getActivity(),this.mdatas,R.layout.item_dailytab) ;
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false) ;
        this.dailyRecView.setLayoutManager(manager);
        this.dailyRecView.setAdapter(this.adapter);
    }

    private void initEvent(){

    }
    public void updateList(){
        this.getTextInDb();
    }

}
