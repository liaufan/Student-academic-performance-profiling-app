package com.example.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class completeQuiz extends AppCompatActivity {
    //private String marks = getIntent().getStringExtra("marks");
    private TextView result;
    private TextView percentage;
    private Button homeButton;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_quiz);
        result = findViewById(R.id.textView19);
        username=getIntent().getStringExtra("username");
        percentage = findViewById(R.id.textView15);
        Intent in=getIntent();
        String marks = in.getStringExtra("marks");
        int per = Integer.parseInt(marks)*100/20;
        percentage.setText(per+"%");
        homeButton = findViewById(R.id.button2);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        result.setText(marks+" out of 20 questions correct");

    }

    public void openHome(){
        Intent intent = new Intent(this, home_activity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}
