package com.example.balancebag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class JoinActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;   //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mPutEmail,mPutPwd,mPutWeight;   //회원가입 입력필드
    private RadioButton male,female;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        mFirebaseAuth =FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("balancebag");


        mPutEmail =findViewById(R.id.put_emaiil);
        mPutPwd = findViewById(R.id.put_pwd);
        mPutWeight =findViewById(R.id.put_weight);
        // 회원가입 버튼
        Button mBtnRegister = findViewById(R.id.join_btn);

        mBtnRegister.setOnClickListener(v -> {
            //회원가입 처리 시작
            String strEmail = mPutEmail.getText().toString();
            String strPwd = mPutPwd.getText().toString();
            String strWeight = mPutWeight.getText().toString();
            String m1 =male.getText().toString();
            String m2 =female.getText().toString();

            //Firebase Auth진행
            mFirebaseAuth.createUserWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(JoinActivity.this, task -> {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                    UserAccount account =new UserAccount();
                    account.setIdToken(Objects.requireNonNull(firebaseUser).getUid());
                    account.setEmailId(firebaseUser.getEmail());
                    account.setWeight(strWeight);
                    account.setPassword(strPwd);

                    if(male.isChecked()){
                        account.setGender(m1);
                        //mDatabaseRef.child(String.valueOf(i+1)).setValue(account);
                    }else {
                        account.setGender(m2);
                        //mDatabaseRef.child(String.valueOf(i+1)).setValue(account);
                    }
                    //setValue :database에 insert(삽입) 행위
                    mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                    Intent intent =new Intent(JoinActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(JoinActivity.this,"회원가입에 성공하셨습니다. ",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(JoinActivity.this,"회원가입에 실패하셨습니다. ",Toast.LENGTH_SHORT).show();
                }
            });

       });

        ImageView back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JoinActivity.super.onBackPressed();
                Intent intent = new Intent(JoinActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
