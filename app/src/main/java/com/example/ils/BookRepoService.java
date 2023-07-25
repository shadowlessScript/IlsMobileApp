package com.example.ils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookRepoService {
    public final static String HOST_URL_IP = "http://192.168.1.11:8000";
    public final static String BOOK_REPO_URL = HOST_URL_IP+"/api/booksrepo/";
    Context context;
    private String bookTitle;
    private String authorName;
    private String serialNumber;
    private String imageCover;
    private JSONObject bookInfo;
    private String bookState;

    ArrayList<books> books = new ArrayList<>();
    public BookRepoService(Context context){
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(ArrayList<books> books);
    }

    public ArrayList<books> getBookRepo(VolleyResponseListener volleyResponseListener) {


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BOOK_REPO_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                bookTitle = "";

//                try {
//                    bookInfo = response.getJSONObject(0);
//////                    bookTitle = bookInfo;
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
                for(int i = 0; i < response.length(); i++){
                    try {
                        bookInfo = response.getJSONObject(i);
                       bookTitle = bookInfo.getString("title");
                       authorName = bookInfo.getString("Author");
                       imageCover = bookInfo.getString("Cover_image");
                       bookState = bookInfo.getString("state");
                       serialNumber = bookInfo.getString("serial_number");
                        books.add(new books(bookTitle, HOST_URL_IP+imageCover, authorName, bookState, serialNumber));
                    } catch (JSONException e) {
                        Toast.makeText(context, e.toString(),Toast.LENGTH_LONG).show();
                    }
                    System.out.println(books);
                }
                volleyResponseListener.onResponse(books);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                volleyResponseListener.onError(error.toString());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);

        return books;
    }
}
