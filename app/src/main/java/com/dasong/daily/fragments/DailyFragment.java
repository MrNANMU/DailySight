package com.dasong.daily.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasong.daily.R;
import com.dasong.daily.adapter.DailyRecAdapter;
import com.dasong.daily.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class DailyFragment extends Fragment {

    private View view = null ;
    private RecyclerView dailyRecView = null ;
    private List<String> mdatas = null ;
    private DailyRecAdapter adapter = null ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_daily,container,false) ;
        this.initView();
        this.initEvent();
        return view ;
    }

    private void initView(){
        this.dailyRecView = (RecyclerView)view.findViewById(R.id.dailyRecView) ;
        this.mdatas = new ArrayList<String>() ;
        for(int i=0 ;i < 15 ;i ++){
            this.mdatas.add("第"+(i+1)+"项") ;
        }
        this.adapter = new DailyRecAdapter(this.getActivity(),this.mdatas,R.layout.item_dailytab) ;
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false) ;
        this.dailyRecView.setLayoutManager(manager);
        //this.dailyRecView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL_LIST));
        this.dailyRecView.setAdapter(this.adapter);
    }

    private void initEvent(){

    }
}
