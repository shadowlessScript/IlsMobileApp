package com.example.ils.fragments;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ils.BookRepoService;
import com.example.ils.MySingleton;
import com.example.ils.R;
import com.example.ils.books;
import com.example.ils.booksRepoAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


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
            public void onResponse(ArrayList<com.example.ils.books> books) {
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