package com.example.ils.ApiServices;

import static com.example.ils.ApiServices.BookRepoService.HOST_URL_IP;
import static com.example.ils.Adpaters.booksRepoAdapter.SERIAL_NUMBER;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.ils.models.BookDetails;
import com.example.ils.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookDetailsService {
    private Context context;
    private String title;
    private String imageUrl;
    private String Author;
    private String bookState;
    private String serialNumber;
    private String CoAuthor;
    private String Pages;
    private String Description;
    private String rating;
    private String CallNumber;
    private String ISBN;
    private JSONObject bookInfo;
    public BookDetailsService(Context context){

        this.context = context;
    }
    ArrayList<BookDetails> bookDetails = new ArrayList<>();


    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(ArrayList<BookDetails> bookDetails);
    }

    public ArrayList<BookDetails> getBookDetails(BookDetailsService.VolleyResponseListener volleyResponseListener) {


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, HOST_URL_IP+"/api/bookdetails/"+SERIAL_NUMBER+"/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


//                try {
//                    bookInfo = response.getJSONObject(0);
//////                    bookTitle = bookInfo;
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
                for(int i = 0; i < response.length(); i++){
                    try {
                        bookInfo = response.getJSONObject(i);
                        title = bookInfo.getString("title");
                        Author = bookInfo.getString("Author");
                        imageUrl = bookInfo.getString("Cover_image");
                        bookState = bookInfo.getString("state");
                        serialNumber = bookInfo.getString("serial_number");
                        CoAuthor = bookInfo.getString("co_authors");
                        Pages = bookInfo.getString("pages");
                        Description = bookInfo.getString("description");
                        rating = bookInfo.getString("year"); //TODO: Create api for rating model
                        CallNumber = bookInfo.getString("call_number");
                        ISBN = bookInfo.getString("serial_number"); //TODO: Create isbn field
                        bookDetails.add(new BookDetails(title, HOST_URL_IP+imageUrl, Author, bookState, serialNumber, CoAuthor, Pages,
                                Description, rating, CallNumber, ISBN));
                    } catch (JSONException e) {
                        Toast.makeText(context, e.toString(),Toast.LENGTH_LONG).show();
                    }
                    System.out.println(bookDetails);
                }
                volleyResponseListener.onResponse(bookDetails);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                volleyResponseListener.onError(error.toString());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);

        return bookDetails;
    }
}
