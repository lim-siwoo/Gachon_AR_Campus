package com.siwoosiwoo.gachon_arnavigation_1011;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePostActivity extends AppCompatActivity {
    private DatabaseReference databaseRef;
    private EditText postEditText;
    private Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        // Initialize Firebase database reference
        databaseRef = FirebaseDatabase.getInstance().getReference().child("posts");

        // Initialize views
        postEditText = findViewById(R.id.postEditText);
        postButton = findViewById(R.id.postButton);

        // Set click listener for the post button
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postText = postEditText.getText().toString().trim();
                if (!postText.isEmpty()) {
                    writePostToFirebase(postText);
                    finish(); // Finish the activity after posting
                }
            }
        });
    }

    private void writePostToFirebase(String postText) {
        String postId = databaseRef.push().getKey();
        Post post = new Post(postId, postText);
        databaseRef.child(postId).setValue(post);
    }
}
