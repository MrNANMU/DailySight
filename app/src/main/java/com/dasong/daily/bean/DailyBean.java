package com.dasong.daily.bean;

/**
 * Created by dason on 2016/12/12 0012.
 */

public class DailyBean implements Bean {

    private String time = null ;
    private String title = null ;
    private String words = null ;
    private int type = 0 ;
    private int position = 0 ;

    public DailyBean(){

    }

    public void setTime(String time){

        this.time = time ;
    }

    public void setTitle(String title){

        this.title = title ;
    }

    public void setWords(String words){

        this.words = words ;
    }

    public void setType(int type){

        this.type = type ;
    }

    public String getTime(){

        return this.time ;
    }

    public String getTitle(){

        return this.title ;
    }

    public String getWords(){

        return this.words ;
    }

    public int getType(){

        return this.type ;
    }

    public void setPosition(int position){
        this.position = position ;
    }

    public int getPosition(){

        return this.position ;
    }

}
