package com.example.android.androidjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("key-joke")) {

            String joke = bundle.getString("key-joke");

            TextView jokeTv = findViewById(R.id.joke_tv);
            jokeTv.setText(joke);
        }
    }


}
