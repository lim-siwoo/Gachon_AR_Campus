package com.siwoosiwoo.gachon_arnavigation_1011;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class notice_board extends AppCompatActivity {
    private DatabaseReference databaseRef;
    private TextView noticeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_boardmain);

        // Initialize Firebase database reference
        databaseRef = FirebaseDatabase.getInstance().getReference().child("posts");

        // Initialize noticeTextView
        noticeTextView = findViewById(R.id.postTextView);

        // Set up a child event listener to listen for new posts
        databaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, String previousChildName) {
                Post post = snapshot.getValue(Post.class);
                if (post != null) {
                    String postText = "Post ID: " + post.getId() + "\nText: " + post.getText() + "\n\n";
                    noticeTextView.append(postText);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, String previousChildName) {
                // Handle post changes if needed
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                // Handle post removal if needed
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, String previousChildName) {
                // Handle post movement if needed
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error if needed
            }
        });
    }
}
