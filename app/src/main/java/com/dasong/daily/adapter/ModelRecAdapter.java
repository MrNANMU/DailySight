package com.dasong.daily.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dasong.daily.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by dason on 2016/12/11 0011.
 */

public class ModelRecAdapter extends RecyclerView.Adapter<ModelTabViewHolder> {

    private Context mContext = null ;
    private List<String> mDatas = null ;
    private LayoutInflater mInflater = null ;
    private int mRes = 0 ;

    private char[] title = null ;

    public ModelRecAdapter(Context context,List<String> datas,int res){
        this.mContext = context ;
        this.mDatas = datas ;
        this.mInflater = LayoutInflater.from(context) ;
        this.mRes = res ;
    }

    @Override
    public ModelTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(this.mRes,parent,false) ;
        ModelTabViewHolder holder = new ModelTabViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(ModelTabViewHolder holder, int position) {
        this.title = new char[]{' ',' ',' ',' '} ;
        char[] c = this.mDatas.get(position).toCharArray();
        for(int i=0 ;i < c.length ;i ++){
            this.title[i]=c[i] ;
        }
        switch (new Random().nextInt(3)){
            case 0 :
                holder.modelItem.setBackgroundResource(R.color.colorIconPurple);
                break ;
            case 1 :
                holder.modelItem.setBackgroundResource(R.color.colorIconPurpleDark);
                break ;
            case 2 :
                holder.modelItem.setBackgroundResource(R.color.colorIconYellow);
                break ;
        }
        holder.modelItem_title_1.setText(Character.toString(this.title[0]));
        holder.modelItem_title_2.setText(Character.toString(this.title[1]));
        holder.modelItem_title_3.setText(Character.toString(this.title[2]));
        holder.modelItem_title_4.setText(Character.toString(this.title[3]));
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ;
        holder.modelItem_time.setText(time);
    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }
}

class ModelTabViewHolder extends ViewHolder {

    LinearLayout modelItem = null ;
    TextView modelItem_title_1 = null ;
    TextView modelItem_title_2= null ;
    TextView modelItem_title_3 = null ;
    TextView modelItem_title_4 = null ;
    TextView modelItem_time = null ;
    public ModelTabViewHolder(View itemView) {
        super(itemView);
        this.modelItem = (LinearLayout)itemView.findViewById(R.id.modelItem) ;
        this.modelItem_title_1 = (TextView)itemView.findViewById(R.id.modelItem_title_1) ;
        this.modelItem_title_2 = (TextView)itemView.findViewById(R.id.modelItem_title_2) ;
        this.modelItem_title_3 = (TextView)itemView.findViewById(R.id.modelItem_title_3) ;
        this.modelItem_title_4 = (TextView)itemView.findViewById(R.id.modelItem_title_4) ;
        this.modelItem_time = (TextView)itemView.findViewById(R.id.modelItem_time) ;
    }
}
