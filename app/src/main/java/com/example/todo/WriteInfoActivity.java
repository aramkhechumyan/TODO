package com.example.todo;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class WriteInfoActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private EditText title;
    private EditText description;
    private TextView timeView;
    private Button timeButton;
    private Button save;
    private Button cancle;
    private String time;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_info);

        title = findViewById(R.id.title_editText);
        description = findViewById(R.id.description_editText);
        timeView = findViewById(R.id.time_textView);
        timeButton = findViewById(R.id.time_button);
        save = findViewById(R.id.save_button);
        cancle = findViewById(R.id.cancle_button);

        timeButton.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            new TimePickerDialog(this, this,
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE), true)
                    .show();
        });

        cancle.setOnClickListener(v -> finish());

        save.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("title", title.getText().toString());
            intent.putExtra("description", description.getText().toString());
            intent.putExtra("time", time);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        this.time = (hour + ":" + minute);
        timeView.setText(time);
    }
}
