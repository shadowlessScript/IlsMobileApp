package com.example.ils.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ils.ApiServices.BookRepoService;
import com.example.ils.R;
import com.example.ils.Adpaters.booksRepoAdapter;
import com.example.ils.models.books;

import java.util.ArrayList;


public class Home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        instantiate the bookreposervice
        BookRepoService bookRepoService = new BookRepoService(view.getContext());

//        bookRepoService.getBookTitle();


        RecyclerView booksRepo = view.findViewById(R.id.booksRepo);

        booksRepoAdapter adapter = new booksRepoAdapter(getContext());
        bookRepoService.getBookRepo(new BookRepoService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(ArrayList<books> books) {
                adapter.setBooks(books);

            }
        });
        booksRepo.setAdapter(adapter);
        booksRepo.setLayoutManager(new GridLayoutManager(getContext(), 2));

//        System.out.println(bookRepoService.getBookRepo());
        // Inflate the layout for this fragment
        return view;

    }



}