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

public class WeightActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    TextView Rweight,Aweight;
    //TextView Aweight;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        Rweight = findViewById(R.id.recent_weight);
        Aweight = findViewById(R.id.able_weight);


        //firebase에서 무게값 불러오기

        DatabaseReference myRefWR =FirebaseDatabase.getInstance().getReference("loadcell");
        DatabaseReference myRefWA =FirebaseDatabase.getInstance().getReference("loadcellAverage");


        myRefWR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // Log.d("my",Rweight.setText());
                String mRecentWeight =snapshot.getValue(String.class);
                    //실시간으로 EditText에 무게값이 입력된다.
                Rweight.setText(mRecentWeight);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("e",error.toException().toString());
            }
        });

        myRefWA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Log.d("my",Rweight.setText());

                    String mAWeight = snapshot.getValue(String.class);
                    Aweight.setText(mAWeight);

                 //적정 가방 무게를 구하는 공식
                //int mAbleWeight = mAweight * 0.15 ;



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
            Intent intent= new Intent(WeightActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        });

        ImageView back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(v -> {
            WeightActivity.super.onBackPressed();
            Intent intent = new Intent(WeightActivity.this,CategoryActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
