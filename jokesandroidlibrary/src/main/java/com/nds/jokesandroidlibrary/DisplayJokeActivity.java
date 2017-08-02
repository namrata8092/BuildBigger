package com.nds.jokesandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;


/**
 * Created by Namrata Shah on 7/31/2017.
 */
public class DisplayJokeActivity extends AppCompatActivity {
    public static final String JOKE_KEY= "joke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_display);
        TextView jokeTextView = (TextView)findViewById(R.id.joke);
        String joke = getIntent().getStringExtra(JOKE_KEY);
        if(joke!=null && !TextUtils.isEmpty(joke)){
            jokeTextView.setText(joke);
        }else{
            jokeTextView.setText(R.string.joke_error);
        }
    }
}
