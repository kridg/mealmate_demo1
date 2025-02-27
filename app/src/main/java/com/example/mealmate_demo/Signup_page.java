package com.example.mealmate_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Signup_page extends AppCompatActivity {
    private EditText email, password, cpassword;

    Button signup_btn;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        signup_btn=findViewById(R.id.signup_btn);
        firebaseAuth=FirebaseAuth.getInstance();

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String CPassword=cpassword.getText().toString().trim();

                if (Email.isEmpty()){
                    Toast.makeText(Signup_page.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty()){
                    Toast.makeText(Signup_page.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (password.length()>6){
                    Toast.makeText(Signup_page.this, "Password is TOoO Short", Toast.LENGTH_SHORT).show();
                }
                if (Password.equals(CPassword)){
                    firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent=new Intent(Signup_page.this,MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(Signup_page.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(Signup_page.this, "Error! Couldn't Sign Up", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}