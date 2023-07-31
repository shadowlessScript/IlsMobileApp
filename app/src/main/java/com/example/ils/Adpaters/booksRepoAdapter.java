package com.example.ils.Adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ils.Helpers;
import com.example.ils.R;
import com.example.ils.models.books;
import com.example.ils.fragments.BookInfo;

import java.util.ArrayList;

public class booksRepoAdapter extends RecyclerView.Adapter<booksRepoAdapter.ViewHolder> {
    private ArrayList<com.example.ils.models.books> books = new ArrayList<>();
    public static String SERIAL_NUMBER;
    private Context context;
    public booksRepoAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_repo, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookTitle.setText(books.get(position).getTitle());
        holder.Author.setText(books.get(position).getAuthor());
        holder.bookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, books.get(holder.getAdapterPosition()).getSerialNumber() + " selected", Toast.LENGTH_SHORT).show();
                SERIAL_NUMBER = books.get(holder.getAdapterPosition()).getSerialNumber();
                Helpers helper = new Helpers();
                helper.replaceFragment(context, new BookInfo());

            }
        });

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.bookCover);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<books> books){
        this.books = books;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView bookTitle, Author;
        private CardView bookCard;
        private ImageView bookCover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.bookTitle);
            bookCard = itemView.findViewById(R.id.bookCard);
            Author = itemView.findViewById(R.id.bookAuthor);
            bookCover = itemView.findViewById(R.id.imageCover);
        }
    }

    public ArrayList<com.example.ils.models.books> getBooks() {
        return books;
    }
}
