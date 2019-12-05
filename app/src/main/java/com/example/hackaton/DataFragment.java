package com.example.hackaton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hackaton.Database.Database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataFragment extends Fragment {

    private TextView username;

    private Database db;
    private Button linkButton;
    private ImageButton buyButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        username = view.findViewById(R.id.dataUsername);
        db = new Database(getActivity());

        String un = getActivity().getIntent().getStringExtra("username");
        username.setText(un);

        linkButton = view.findViewById(R.id.linkButton);
        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://app.powerbi.com/view?r=eyJrIjoiNDk1YjVkYjgtZmQ2Mi00NmE5LWIwZDQtNmRlOTAzMWMwMjhiIiwidCI6IjUzN2MyYmUxLWZjZDQtNDVhOS04M2IzLTY2NTNlYWNjNTA3MCIsImMiOjEwfQ%3D%3D");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        buyButton = view.findViewById(R.id.imageButton);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://liauroufan.com/math.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        return view;
    }
}
