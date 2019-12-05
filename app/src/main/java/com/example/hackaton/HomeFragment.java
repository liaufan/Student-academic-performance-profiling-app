package com.example.hackaton;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private Button startQuiz;
    private TextView username;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        startQuiz = view.findViewById(R.id.startQuiz);
        username = view.findViewById(R.id.homeUsernameTextView);
        username.setText(getActivity().getIntent().getStringExtra("username"));
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity();
            }
        });
        return view;

    }

    public void startQuizActivity(){
        Intent intent = new Intent(getActivity(), quiz_activity.class);
        intent.putExtra("username", getActivity().getIntent().getStringExtra("username"));
        startActivity(intent);
    }


}
