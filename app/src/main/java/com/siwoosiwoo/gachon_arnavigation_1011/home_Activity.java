package com.siwoosiwoo.gachon_arnavigation_1011;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class home_Activity extends AppCompatActivity {
    private Button map1;
    private Button friend_4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);



        map1 = (Button) findViewById(R.id.theme1);
        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity 연결
                Intent intent = new Intent(home_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
