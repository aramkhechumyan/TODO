package com.example.todo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ToDoActivity extends AppCompatActivity {
    private FloatingActionButton myFab;
    private RecyclerView recyclerView;

    private final ToDoAdapter toDoAdapter = new ToDoAdapter(todoModel -> {
        Intent intent = new Intent(ToDoActivity.this, SeeInfoActivity.class);
        intent.putExtra("title", todoModel.getTitle());
        intent.putExtra("description",todoModel.getDescription());
        intent.putExtra("time",todoModel.getTime());
        startActivity(intent);
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do);

        myFab = findViewById(R.id.add_alarm_fab);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(toDoAdapter);

        myFab.setOnClickListener(v -> {
            Intent intent = new Intent(this, WriteInfoActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("title");
            String description = data.getStringExtra("description");
            String time = data.getStringExtra("time");

            toDoAdapter.addItem(new TodoModel(title, description, time));
        }
    }

    interface OnItemClickListener {
        void onItemClick(TodoModel todoModel);
    }
}