package com.chirag.firebasedemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.security.PrivilegedAction;

public class MainActivity extends AppCompatActivity {

    private EditText nameEt;
    private EditText emailEt;
    private EditText phoneNumberEt;
    private Button submitButton;
    private RadioGroup genderRg;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        db = FirebaseFirestore.getInstance();
        
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                String email = emailEt.getText().toString();
                Integer phoneNo = Integer.valueOf(phoneNumberEt.getText().toString());
                int genderId = genderRg.getCheckedRadioButtonId();
                RadioButton genderRb = findViewById(genderId);
                String gender = genderRb.getText().toString();

                //Validate here. Check if anything is empty and any other kind of sanitation.

                User user = new User(name,gender,email,phoneNo);
                uploadUser(user);
            }
        });
    }

    public void uploadUser(User user) {
        db.collection("users")
                .document(phoneNumberEt.getText().toString())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void initializeViews() {
        nameEt=findViewById(R.id.name_et);
        emailEt=findViewById(R.id.email_et);
        phoneNumberEt=findViewById(R.id.phno_et);
        submitButton=findViewById(R.id.submit_button);
        genderRg=findViewById(R.id.gender);
    }
}
