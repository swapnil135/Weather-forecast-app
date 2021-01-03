package com.example.android.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Intent ReceivedIntent=getIntent();
        if(ReceivedIntent.hasExtra("SentWeather"))
        {
            String ReceivedText=ReceivedIntent.getStringExtra("SentWeather");
            TextView tv= findViewById(R.id.detail_activity_tv);
            tv.setText(ReceivedText);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}