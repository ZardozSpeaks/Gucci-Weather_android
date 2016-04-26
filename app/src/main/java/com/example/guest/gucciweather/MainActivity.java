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
<<<<<<< HEAD
    @Bind(R.id.editText) EditText mEditText;
    @Bind(R.id.startButton) Button mStartButton;
=======
    @Bind(R.id.startButton) Button mGucciButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
>>>>>>> ec73517e0a76c164bf30515568759aa5eb04ca2f

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "Alcefun.ttf");
        mTitleTextView.setTypeface(myCustomFont);

<<<<<<< HEAD

        mStartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String location = mEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, GucciWeatherActivity.class).putExtra("location", location);
                startActivity(intent);
            }
        });

=======
        mGucciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, GucciWeatherActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
>>>>>>> ec73517e0a76c164bf30515568759aa5eb04ca2f
    }
}
