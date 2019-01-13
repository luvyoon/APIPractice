package kr.tjeit.apipractice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext ;


    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindView();



}
