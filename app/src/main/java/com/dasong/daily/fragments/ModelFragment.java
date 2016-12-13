package com.dasong.daily.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasong.daily.R;
import com.dasong.daily.adapter.DailyRecAdapter;
import com.dasong.daily.adapter.ModelRecAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class ModelFragment extends Fragment {

    private View view = null ;
    private RecyclerView modelRecView = null ;
    private List<String> mdatas = null ;
    private ModelRecAdapter adapter = null ;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_model,container,false) ;
        this.initView();
        return view ;
    }

    private void initView(){
        this.modelRecView = (RecyclerView)view.findViewById(R.id.modelRecView) ;
        this.mdatas = new ArrayList<String>() ;
        this.mdatas.add("累觉不爱") ;
        this.mdatas.add("怒吃狗粮") ;
        this.mdatas.add("求SSR") ;
        this.mdatas.add("你瞅啥") ;
        this.adapter = new ModelRecAdapter(this.getActivity(),this.mdatas,R.layout.item_modeltab) ;
        GridLayoutManager manager = new GridLayoutManager(this.getActivity(),2,GridLayoutManager.VERTICAL,false) ;
        this.modelRecView.setLayoutManager(manager);
        //this.modelRecView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL_LIST));
        this.modelRecView.setAdapter(this.adapter);
    }
}
