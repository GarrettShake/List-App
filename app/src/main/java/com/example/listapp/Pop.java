package com.example.listapp;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pop extends AppCompatActivity {


    FirebaseAuth auth;
    private EditText mTitle,mDesc;

    String TAG= "pop.java";

    public void AddData(String t, String d){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref1 = database.getReference(auth.getInstance().getCurrentUser().getUid());
        DatabaseReference postRef = ref1.child("list");
        DatabaseReference newPostRef = postRef.push();
        newPostRef.setValue(new list(t,d));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newitem);

        getSupportActionBar().hide();

        mTitle = findViewById(R.id.title);
        mDesc = findViewById(R.id.desc);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.5));

        FloatingActionButton fab1 = findViewById(R.id.fabmin);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fabplus);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = mTitle.getText().toString();
                String desc = mDesc.getText().toString();
                AddData(title,desc);

                finish();

            }
        });
    }
}
