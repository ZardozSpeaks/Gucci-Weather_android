package com.example.guest.gucciweather;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.startButton) Button mGucciButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "Alcefun.ttf");
        mTitleTextView.setTypeface(myCustomFont);

        mGucciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, GucciWeatherActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });

    }
}
