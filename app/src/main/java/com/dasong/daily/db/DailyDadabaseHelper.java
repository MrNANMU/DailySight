package com.dasong.daily.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory ;

/**
 * Created by dason on 2016/12/12 0012.
 */

public class DailyDadabaseHelper extends SQLiteOpenHelper {

    private Context mContext = null ;
    private final String createDb = "CREATE TABLE daily(" +
            "id integer primary key autoincrement, " +
            "title text," +
            "time text," +
            "words text," +
            "type integer)" ;

    public DailyDadabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.createDb) ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
