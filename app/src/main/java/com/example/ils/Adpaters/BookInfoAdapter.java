package com.example.ils.Adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ils.models.BookDetails;
import com.example.ils.R;

import java.util.ArrayList;

public class BookInfoAdapter  extends RecyclerView.Adapter<BookInfoAdapter.ViewHolder>{
    private ArrayList<BookDetails> bookDetails = new ArrayList<>();
    private Context context;
    public BookInfoAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public BookInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_info_skltn, parent, false);
        BookInfoAdapter.ViewHolder holder = new BookInfoAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookTitle.setText(bookDetails.get(position).getTitle());
        holder.Author.setText(bookDetails.get(position).getAuthor());
        holder.CallNumber.setText(bookDetails.get(position).getCallNumber());
        holder.Description.setText(bookDetails.get(position).getDescription());
        holder.ISBN.setText((bookDetails.get(position).getISBN()));
        holder.rating.setText(bookDetails.get(position).getRating());
        Glide.with(context)
                .asBitmap()
                .load(bookDetails.get(position).getImageUrl())
                .into(holder.bookCover);
    }



    @Override
    public int getItemCount() {
        return bookDetails.size();
    }

    public void setBooksInfo(ArrayList<BookDetails> bookDetails){
        this.bookDetails = bookDetails;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView bookTitle, Author, Description, ISBN, CallNumber,rating;

        private ImageView bookCover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.bookInfoTitle);
            Author = itemView.findViewById(R.id.bookInfoAuthorName);
            bookCover = itemView.findViewById(R.id.bookInfoImgCover);
            Description = itemView.findViewById(R.id.bookInfoDescription);
            ISBN = itemView.findViewById(R.id.bookInfoISBN);
            CallNumber = itemView.findViewById(R.id.bookInfoCallNo);
            rating = itemView.findViewById(R.id.bookInfoRating);
        }
    }


}
