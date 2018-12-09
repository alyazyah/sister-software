package com.example.ecesu.courseplanner;

import android.widget.ImageView;

import java.util.PriorityQueue;

public class ExampleItem {

    private String mText1;
    private String mText2;
    private String mnumber;

    public ExampleItem(String Text1, String Text2, String number){
        mText1 = Text1;
        mText2 = Text2;
        mnumber = number;
    }

    public void changeText1(String text) {
        mText1 = text;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public String getmnumber() {
        return mnumber;
    }


}
