package com.example.balancebag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class CategoryActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mFirebaseAuth = FirebaseAuth.getInstance();
        ImageView logout_btn = findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그아웃 하기
                mFirebaseAuth.signOut();
                Intent intent= new Intent(CategoryActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryActivity.super.onBackPressed();
                Intent intent = new Intent(CategoryActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button weight_btn =findViewById(R.id.weight_btn);
        weight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //weight checking으로 넘어간다.
                Intent intent =new Intent(CategoryActivity.this,WeightActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button press_btn =findViewById(R.id.press_btn);
        press_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //press checking으로 넘어간다.
                Intent intent =new Intent(CategoryActivity.this,PressActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button graph_btn =findViewById(R.id.graph_btn);
        graph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //graph checking으로 넘어간다.
                Intent intent =new Intent(CategoryActivity.this,GraphActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
