package com.example.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hackaton.Database.Database;
import com.example.hackaton.Model.Member;

public class sign_up_activity extends AppCompatActivity {

    private EditText firstname;
    private EditText lastname;
    private EditText email;
    private EditText username;
    private Spinner grade;
    private EditText password;
    private Button signUp;
    private Member newMember;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity);
        firstname = findViewById(R.id.signUpFirstName);
        lastname = findViewById(R.id.signUpLastName);
        email = findViewById(R.id.signUpEmail);
        username = findViewById(R.id.signUpUsername);
        grade =findViewById(R.id.spinner);
        password = findViewById(R.id.signUpPassword);
        signUp = findViewById(R.id.signUpButton);
        db = new Database(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstname.getText().toString().equals("")||lastname.getText().toString().equals("")||email.getText().toString().equals("")||
                        username.getText().toString().equals("")||password.getText().toString().equals("")){
                    //Please fill in all the fields!
                }else{
                    int grade_int;
                    grade_int=Integer.parseInt(grade.getSelectedItem().toString().substring(9));
                    Log.d("Test Grade", grade.getSelectedItem().toString().substring(9));
                    //String username, String password, String name, int grade, int status, String email, int star
                    newMember = new Member(username.getText().toString(),password.getText().toString(),firstname.getText().toString()+lastname.getText().toString(),grade_int,1,email.getText().toString(),0);
                    db.addMember(newMember);
                    openHomeActivity();

                }
            }
        });




    }
    public void openHomeActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
