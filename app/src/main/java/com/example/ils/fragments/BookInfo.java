package com.example.ils.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ils.BookDetails;
import com.example.ils.BookDetailsService;
import com.example.ils.BookInfoAdapter;
import com.example.ils.BookRepoService;
import com.example.ils.R;

import java.util.ArrayList;


public class BookInfo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String summary = "Ben Munyasia explores the continuing path to our own wisdom, a path that does not come cheap and leads us to become our ever-changing best selves. There’s a need for sincerity as we learn how to access our inner wisdom without imposition. We access our wisdom by leaving behind moral pressure established from previous relationships or societal expectations and revering our own genuine state of asking for guidance. We find our sincere questions when we find our purest intentions to care, to be kind and inclusive. Once we find these sincere questions and respond with the guidance suggested, we will be connected to ourselves in intimacy and greater capacity to give and receive.";
        View view = inflater.inflate(R.layout.book_info, container, false);

        BookDetailsService bookDetailsService = new BookDetailsService(getContext());

        RecyclerView bookInfoContainer = view.findViewById(R.id.bookInfoContainer);
        BookInfoAdapter bookInfoAdapter = new BookInfoAdapter(getContext());


//        ArrayList<BookDetails> bookDetails = new ArrayList<>();
//        bookDetails.add((new BookDetails("The Book of wisdom",
//                        "https://ath-1ceed.kxcdn.com/wp-content/uploads/Episode-34_Developing-our-Own-Wisdom-from-Inner-Inquiry.jpg",
//                        "Ben Munyasia",
//                        "eBook",
//                        "29449",
//                        "",
//                        "234",
//                        summary,
//                        "4.5",
//                        "TK 4758 828",
//                        "1384 92038 8475"
//        )));

        bookDetailsService.getBookDetails(new BookDetailsService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(ArrayList<com.example.ils.BookDetails> bookDetails) {
                bookInfoAdapter.setBooksInfo(bookDetails);

            }
        });

//        bookInfoAdapter.setBooksInfo(bookDetails);
        bookInfoContainer.setAdapter(bookInfoAdapter);
        bookInfoContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}