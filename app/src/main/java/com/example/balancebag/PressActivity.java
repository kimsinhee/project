package com.example.balancebag;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PressActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    TextView Rpress,Lpress,Hpress;
    //TextView Aweight;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press);

        Rpress = findViewById(R.id.right_press);
        Lpress = findViewById(R.id.left_press);
        Hpress = findViewById(R.id.hip_press);


        //firebase에서 무게값 불러오기

        DatabaseReference myRP = FirebaseDatabase.getInstance().getReference("Right");
        DatabaseReference myLP = FirebaseDatabase.getInstance().getReference("Left");
        DatabaseReference myHP = FirebaseDatabase.getInstance().getReference("Top");


        myRP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Log.d("my",Rweight.setText());
                String mRP =snapshot.getValue(String.class);
                //실시간으로 EditText에 무게값이 입력된다.
                Rpress.setText(mRP);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("e",error.toException().toString());
            }
        });

        myLP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Log.d("my",Rweight.setText());
                String mLP =snapshot.getValue(String.class);
                //실시간으로 EditText에 무게값이 입력된다.
                Lpress.setText(mLP);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("e",error.toException().toString());
            }
        });

        myHP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Log.d("my",Rweight.setText());
                String mHP =snapshot.getValue(String.class);
                //실시간으로 EditText에 무게값이 입력된다.
                Hpress.setText(mHP);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("e",error.toException().toString());
            }
        });



        mFirebaseAuth=FirebaseAuth.getInstance();
        ImageView logout_btn = findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(v -> {
            //로그아웃 하기
            mFirebaseAuth.signOut();
            Intent intent= new Intent(PressActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        });

        ImageView back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(v -> {
            PressActivity.super.onBackPressed();
            Intent intent = new Intent(PressActivity.this,CategoryActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
