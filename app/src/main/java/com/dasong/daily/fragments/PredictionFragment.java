package com.dasong.daily.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasong.daily.R;
import com.dasong.daily.adapter.DailyRecAdapter;
import com.dasong.daily.adapter.PredictionRecAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class PredictionFragment extends Fragment {

    private View view = null ;
    private RecyclerView predictionRecView = null ;
    private List<String> mdatas = null ;
    private PredictionRecAdapter adapter = null ;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_prediction,container,false) ;
        this.initView();
        return view ;
    }
    private void initView(){
        this.predictionRecView = (RecyclerView)view.findViewById(R.id.predictionRecView) ;
        this.mdatas = new ArrayList<String>() ;
        for(int i=0 ;i < 15 ;i ++){
            this.mdatas.add("第"+(i+1)+"项") ;
        }
        this.adapter = new PredictionRecAdapter(this.getActivity(),this.mdatas,R.layout.item_predictiontab) ;
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.GAP_HANDLING_NONE) ;
        //LinearLayoutManager manager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false) ;
        this.predictionRecView.setLayoutManager(manager);
        //this.dailyRecView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL_LIST));
        this.predictionRecView.setAdapter(this.adapter);
    }
}

