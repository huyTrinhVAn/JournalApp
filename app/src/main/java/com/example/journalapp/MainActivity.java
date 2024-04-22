package com.example.journalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button SignIn , Register;
    EditText email_MA , pass_MA;
    // FireBase Auth

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SignIn = findViewById(R.id.BT1_MA_Signin);
        Register = findViewById(R.id.BT2_MA_Register);
        email_MA = findViewById(R.id.ACTV_MA_Email);
        pass_MA = findViewById(R.id.ET1_MA_Password);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register_activity.class );
                startActivity(i);
            }
        });
        // FireBase Auth
        firebaseAuth = FirebaseAuth.getInstance();

    }
}