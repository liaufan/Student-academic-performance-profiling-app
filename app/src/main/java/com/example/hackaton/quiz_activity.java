package com.example.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hackaton.Database.Database;
import com.example.hackaton.Model.Question;

import java.util.List;
import java.util.Random;

public class quiz_activity extends AppCompatActivity {

    private Button A,B,C,D;
    private Database db;
    private List<Question> questions;
    private TextView quiz_question;
    private TextView quizQuestionId;
    static private int ans;
    static private int point=0;
    static private int index=0;
    private String username;
    private Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_activity);
        username=getIntent().getStringExtra("username");
        index=0;
        point=0;
        A = findViewById(R.id.quizChoiceA);
        B = findViewById(R.id.quizChoiceB);
        C = findViewById(R.id.quizChoiceC);
        D = findViewById(R.id.quizChoiceD);
        quizQuestionId = findViewById(R.id.quizQuestionId);
        db = new Database(this);
        questions=db.getQuestions();
        quiz_question = findViewById(R.id.quizQuestion);
        quiz_question.setText(questions.get(index).getDescription());
        setOptionButton();


        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==0){
                    point++;
                }
                if(index<20){
                    nextQuestion();
                }else{
                    openCompleteQuizActivity();
                }

            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==1){
                    point++;
                }
                if(index<20){
                    nextQuestion();
                }else{
                    openCompleteQuizActivity();
                }
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==2){
                    point++;
                }
                if(index<20){
                    nextQuestion();
                }else{
                    openCompleteQuizActivity();
                }
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==3){
                    point++;
                }
                if(index<20){
                    nextQuestion();
                }else{
                    openCompleteQuizActivity();
                }
            }
        });
    }

    public void openCompleteQuizActivity(){
        Intent intent = new Intent(this,completeQuiz.class);
        Log.d("Test Intent",String.valueOf(point));
        intent.putExtra("marks", String.valueOf(point));
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void setOptionButton(){
        quiz_question.setText(questions.get(index).getDescription());

        quizQuestionId.setText("Question "+(index+1)+" of 20");

        random();

        index++;

    }

    public void random(){
        switch(r.nextInt()%4){
            case 0:
                random0();
                break;
            case 1:
                random1();
                break;
            case 2:
                random2();
                break;
            case 3:
                random3();
                break;

            default:
                random();
                break;


        }
    }

    public void random0(){
        A.setText(questions.get(index).getAnswer());
        B.setText(questions.get(index).getOption2());
        C.setText(questions.get(index).getOption3());
        D.setText(questions.get(index).getOption1());
        ans=0;
    }
    public void random1(){
        A.setText(questions.get(index).getOption1());
        B.setText(questions.get(index).getAnswer());
        C.setText(questions.get(index).getOption2());
        D.setText(questions.get(index).getOption3());
        ans=1;
    }
    public void random2(){
        A.setText(questions.get(index).getOption1());
        B.setText(questions.get(index).getOption2());
        C.setText(questions.get(index).getAnswer());
        D.setText(questions.get(index).getOption3());
        ans=2;
    }

    public void random3(){
        A.setText(questions.get(index).getOption1());
        B.setText(questions.get(index).getOption2());
        C.setText(questions.get(index).getOption3());
        D.setText(questions.get(index).getAnswer());
        ans=3;
    }



    public void nextQuestion(){
        setOptionButton();

    }
}
