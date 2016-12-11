package com.dasong.daily.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by dason on 2016/12/11 0011.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context mContext = null ;

    public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version){
        super(context,name,factory,version) ;
        this.mContext = context ;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
