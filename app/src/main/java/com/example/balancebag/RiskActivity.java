package com.example.balancebag;


import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class RiskActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk);




        FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
        ImageView logout_btn = findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(v -> {
            //로그아웃 하기
            mFirebaseAuth.signOut();
            Intent intent= new Intent(RiskActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        });

        ImageView back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(v -> {
            RiskActivity.super.onBackPressed();
            Intent intent = new Intent(RiskActivity.this,CategoryActivity.class);
            startActivity(intent);
            finish();
        });

    }
    //storage 객체에 만들고 싶은 이미지 참조
    FirebaseStorage storage = FirebaseStorage.getInstance(); //스토리지 인스턴스를 만든다.
    StorageReference storageRef =storage.getReference();// 스토리지를 참조한다.
    //파일명을 만들자
    //String filename ="profile" + num + ".jpg";


}
