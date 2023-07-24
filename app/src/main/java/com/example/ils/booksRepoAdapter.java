package com.example.ils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ils.fragments.BookInfo;

import java.util.ArrayList;

public class booksRepoAdapter extends RecyclerView.Adapter<booksRepoAdapter.ViewHolder> {
    private ArrayList<books> books = new ArrayList<>();
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
//                AppView appView = new AppView();
//                appView.replaceFragment(new BookInfo());

                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view, new BookInfo());
                fragmentTransaction.commit();
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


}
