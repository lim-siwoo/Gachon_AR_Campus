package com.siwoosiwoo.gachon_arnavigation_1011;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class loginActivity extends AppCompatActivity {
    private Button btn_register_1;

    private FirebaseAuth mFirebaseAuth; //파이어베이스 인증 관련
    private EditText et_email, et_pwd;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_register_1 = findViewById(R.id.btn_register2);
        btn_register_1.setOnClickListener(v -> {
            Intent intent = new Intent(loginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        mFirebaseAuth = FirebaseAuth.getInstance();

        et_email = findViewById(R.id.email);
        et_pwd = findViewById(R.id.passWord);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(v -> {
            String strEmail = et_email.getText().toString();
            String strPwd = et_pwd.getText().toString();

            mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Intent intent = new Intent(loginActivity.this, home_Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(loginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
    }

}
