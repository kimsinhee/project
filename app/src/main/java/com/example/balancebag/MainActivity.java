package com.example.balancebag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                startLoading();
    }
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {


                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);

                    finish();

                },
                2000);//2초 후 LoginActivity로 넘어감
    }
}
