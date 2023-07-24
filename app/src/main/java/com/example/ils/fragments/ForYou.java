package com.example.ils.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ils.R;
import com.example.ils.books;
import com.example.ils.booksRepoAdapter;

import java.util.ArrayList;

public class ForYou extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.for_you, container, false);
        RecyclerView booksRepo = view.findViewById(R.id.booksForYou);
        ArrayList<books> books = new ArrayList<>();
        books.add(new books("Introduction to java", "https://www.aibh.in/backend/images/products/cover-9788184954432.jpg", "K.SomasunDaram", "Print","212"));
        books.add(new books("Introduction to python", "https://m.media-amazon.com/images/I/419NS17nPKL._AC_UF1000,1000_QL80_.jpg", "Paul Veena  A.", "ebook","212"));
        books.add(new books("Learning Web Design", "https://learning.oreilly.com/library/cover/9780596527525/250w/", "Jennifer Niederst Robbins", "Print","212"));
        books.add(new books("A dusty road to success", "https://empoweringgenerations.co.zw/wp-content/uploads/2021/03/book.jpg", "DR Douglas Mboweni", "Print","212"));
//        books.add(new books("Harry Potter and the philosopher's stone", "https://m.media-amazon.com/images/I/81m1s4wIPML._AC_UF894,1000_QL80_.jpg", "J.K Rowling", "Print"));

        booksRepoAdapter adapter = new booksRepoAdapter(getContext());
        adapter.setBooks(books);
        booksRepo.setAdapter(adapter);
        booksRepo.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Inflate the layout for this fragment
        return view;

    }


}
