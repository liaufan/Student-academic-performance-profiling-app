package com.example.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hackaton.Database.Database;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button signInButton;
    private Button signUpButton;

    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.signInUserName);
        password = findViewById(R.id.signInPassword);
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);
        db = new Database(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.isAuthenticated(userName.getText().toString(),password.getText().toString())){
                    SignIn();
                }

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }

    public void openSignUpActivity(){
        Intent intent = new Intent(this, sign_up_activity.class);
        startActivity(intent);
    }

    public void SignIn(){
        Intent intent = new Intent(this, home_activity.class);
        intent.putExtra("username",userName.getText().toString());
        startActivity(intent);
    }
}
