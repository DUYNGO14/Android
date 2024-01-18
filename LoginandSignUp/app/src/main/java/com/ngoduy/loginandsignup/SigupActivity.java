package com.ngoduy.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SigupActivity extends AppCompatActivity {
    EditText signupName,signupEmail,signupUsername,signupPassword;
    Button signupButton;
    TextView loginRedirrectText;
    FirebaseDatabase databse;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigup);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirrectText = findViewById(R.id.loginRedirectText);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databse = FirebaseDatabase.getInstance();
                reference = databse.getReference("users");
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                HelperClass helperclass = new HelperClass(name,email,username,password);
                reference.child(name).setValue(helperclass);

                Toast.makeText(SigupActivity.this,"You have signup successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SigupActivity.this,LoginActiivity.class);
                startActivity(intent);

            }
        });
        loginRedirrectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SigupActivity.this,"You have signup successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SigupActivity.this,LoginActiivity.class);
                startActivity(intent);
            }
        });
    }
}