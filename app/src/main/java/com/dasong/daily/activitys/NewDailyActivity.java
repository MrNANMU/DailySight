package com.dasong.daily.activitys;

import android.content.ContentValues;
import android.database.Cursor;

import com.dasong.daily.bean.DailyBean;
import com.dasong.daily.listener.SaveDailyInDbListener;

/**
 * Created by dason on 2016/12/12 0012.
 */

public class NewDailyActivity extends DailyActivity {

    @Override
    public void setBarTitle() {
        this.newDaily_ToolBar.setTitle("新日记");
    }

    public void createDaily(){
        this.getDb();
        String title = this.newDaily_titleEdit.getText().toString().replaceAll("(\r\n|\r|\n|\n\r|\\s)", "") ;
        String time = this.newDaily_time.getText().toString() ;
        String words = this.newDaily_words.getText().toString() ;
        int type ;
        if(title == ""){
            type = 1 ;
        }else {
            type = 0 ;
        }
        this.bean = new DailyBean() ;
        this.bean.setTime(time);
        this.bean.setWords(words);
        this.bean.setType(type);
        this.bean.setTitle(title);
        this.isFirstSave = false ;
        ContentValues values = new ContentValues() ;
        values.put("time",this.bean.getTime());
        values.put("title",this.bean.getTitle()) ;
        values.put("words",this.bean.getWords());
        values.put("type",this.bean.getType());
        this.db.insert("daily",null,values) ;
        this.db.close();
    }

    public void updateDaily(){
        this.getDb();
        String title = this.newDaily_titleEdit.getText().toString().replaceAll("(\r\n|\r|\n|\n\r|\\s)", "") ;
        String words = this.newDaily_words.getText().toString() ;
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
        int i = 0;
        Cursor cursor = this.db.query("daily",new String[]{"id"},null,null,null,null,null) ;
        if(cursor.moveToLast()){
            i = cursor.getInt(cursor.getColumnIndex("id")) ;
        }
        this.db.update("daily",values,"id=?",new String[]{String.valueOf(i)});
    }

    @Override
    public void saveInDb() {
        this.newDaily_addDaily.setOnClickListener(new SaveDailyInDbListener(this,0));
    }

}


