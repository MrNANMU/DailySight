package com.dasong.daily.activitys;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.dasong.daily.R;
import com.dasong.daily.adapter.holder.DailyTabViewHolder;
import com.dasong.daily.bean.DailyBean;
import com.dasong.daily.listener.DailyRecItemClickListener;
import com.dasong.daily.listener.SaveDailyInDbListener;

/**
 * Created by dason on 2016/12/13 0013.
 * 该Activity大致逻辑与NewDailyActivity相同，布局文件使用的也是同一个
 * 为了维护更清晰，拆分为两个Activity
 */

public class DailyShowActivity extends DailyActivity {

    private static final int ERROR = -1 ;

    private int position = 0 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent() ;
        this.position = intent.getIntExtra("position",ERROR) ;
        this.reSetText();
    }


    private void reSetText(){
        this.getDb();
        Cursor cursor = this.db.rawQuery("SELECT * FROM daily WhERE id="+(this.position+1),null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0) ;
            String title = cursor.getString(1) ;
            String words = cursor.getString(3) ;
           this.newDaily_titleEdit.setText(title);
           this.newDaily_words.setText(words);
        }
        cursor.close();
        this.db.close();
    }

    @Override
    public void setBarTitle() {
        this.newDaily_ToolBar.setTitle("日记");
    }

    @Override
    public void createDaily() {

    }

    @Override
    public void updateDaily() {
        this.getDb() ;
        String title = this.newDaily_titleEdit.getText().toString().replaceAll("(\r\n|\r|\n|\n\r|\\s)", "") ;
        String words = this.newDaily_words.getText().toString() ;
        Log.e("ZHENG:",words) ;
        int type ;
        if(title == ""){
            type = 1 ;
        }else {
            type = 0 ;
        }
        ContentValues values = new ContentValues() ;
        values.put("title",title);
        values.put("words",words);
        values.put("type",type);
        this.db.update("daily",values,"id=?",new String[]{String.valueOf(this.position+1)});
    }

    @Override
    public void saveInDb() {
        this.newDaily_addDaily.setOnClickListener(new SaveDailyInDbListener(this,1));
    }

}
