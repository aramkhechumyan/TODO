package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private final List<TodoModel> todoItems = new ArrayList<>();
    private final ToDoActivity.OnItemClickListener onItemClickListener;

    public ToDoAdapter(ToDoActivity.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final TextView timeTextView;
        private TodoModel todoModel;

        public ViewHolder(View view, ToDoActivity.OnItemClickListener onItemClickListener) {
            super(view);
            view.setOnClickListener(v -> {
                onItemClickListener.onItemClick(todoModel);
            });
            titleTextView = view.findViewById(R.id.title_textView);
            descriptionTextView = view.findViewById(R.id.description_textView);
            timeTextView = view.findViewById(R.id.time_textView);
        }

        public void bindData(TodoModel todoModel){
            this.todoModel = todoModel;

            titleTextView.setText(todoModel.getTitle());
            descriptionTextView.setText(todoModel.getDescription());
            timeTextView.setText(todoModel.getTime());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);

        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        TodoModel todoModel = todoItems.get(position);
        viewHolder.bindData(todoModel);
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    public void addItem(@NonNull final TodoModel todoModel){
        todoItems.add(0, todoModel);
        notifyItemInserted(0);
    }
}
