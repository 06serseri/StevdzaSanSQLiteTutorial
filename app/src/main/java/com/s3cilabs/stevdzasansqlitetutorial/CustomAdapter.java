package com.s3cilabs.stevdzasansqlitetutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList bookId, bookTitle, bookAuthor, bookPages;
    Activity activity;

    CustomAdapter(Activity activity, Context context, ArrayList bookId, ArrayList bookTitle, ArrayList bookAuthor, ArrayList bookPages) {
        this.activity = activity;
        this.context = context;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewBookId.setText(String.valueOf(bookId.get(position)));
        holder.textViewBookTitle.setText(String.valueOf(bookTitle.get(position)));
        holder.textViewBookAuthor.setText(String.valueOf(bookAuthor.get(position)));
        holder.textViewBookPages.setText(String.valueOf(bookPages.get(position)));
        holder.bookItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(bookId.get(position)));
                intent.putExtra("title", String.valueOf(bookTitle.get(position)));
                intent.putExtra("author", String.valueOf(bookAuthor.get(position)));
                intent.putExtra("pages", String.valueOf(bookPages.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return bookId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBookId, textViewBookTitle, textViewBookAuthor, textViewBookPages;
        LinearLayout bookItemLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBookId = itemView.findViewById(R.id.textViewBookId);
            textViewBookTitle = itemView.findViewById(R.id.textViewBookTitle);
            textViewBookAuthor = itemView.findViewById(R.id.textViewBookAuthor);
            textViewBookPages = itemView.findViewById(R.id.textViewBookPages);
            bookItemLayout = itemView.findViewById(R.id.bookItemLayout);
        }
    }
}
