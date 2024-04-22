package com.example.journalapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register_activity extends AppCompatActivity {


    EditText userName , password;
    EditText SetEmail;
    Button SignUp;
    // firebase authentication

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;

    // Firebase connection

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        SignUp = findViewById(R.id.BT1_AR_signUp);
        userName = findViewById(R.id.ET2_AR_Username);
        password = findViewById(R.id.ET1_AR_password);
        SetEmail = findViewById(R.id.ACT1_AR_email);
        // Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                currentUser = firebaseAuth.getCurrentUser();

                // Check the user logged in ot not
                if(currentUser != null){
                    // already log in

                } else {
                    // sign out
                }
            }
        };
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(userName.getText().toString()) && !TextUtils.isEmpty(password.getText().toString()) && !TextUtils.isEmpty(SetEmail.getText().toString())){
                    String email = SetEmail.getText().toString().trim();
                    String name = userName.getText().toString().trim();
                    String pass = password.getText().toString().trim();
                    CreaterUserEmailAccount(email, pass , name);
                } else{
                    Toast.makeText(Register_activity.this,
                            "No missing feild",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void CreaterUserEmailAccount(String email , String passWord , String userName){
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(passWord) && !TextUtils.isEmpty(userName)){

            firebaseAuth.createUserWithEmailAndPassword(
                    email , passWord
            ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        // user is created successfully
                        Toast.makeText(Register_activity.this, "Successfully" , Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
}

