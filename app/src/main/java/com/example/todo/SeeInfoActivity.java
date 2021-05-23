package com.example.todo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeeInfoActivity extends AppCompatActivity {
    private TextView titleText;
    private TextView descriptionText;
    private TextView timeText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.see_info);

        titleText = findViewById(R.id.title_textView);
        descriptionText = findViewById(R.id.description_textView);
        timeText= findViewById(R.id.time_textView);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String time = getIntent().getStringExtra("time");

        titleText.setText(title);
        descriptionText.setText(description);
        timeText.setText(time);
    }
}
