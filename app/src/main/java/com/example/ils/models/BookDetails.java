package com.example.ils.models;

import com.example.ils.models.books;

public class BookDetails extends books {

    private String CoAuthor;
    private String Pages;
    private String Description;
    private String rating;
    private String CallNumber;
    private String ISBN;

    /**
     * Constructor for BookDetails, which extends the book class
     * @param title
     * @param imageUrl
     * @param Author
     * @param bookState
     * @param serialNumber
     * @param CoAuthor
     * @param Pages
     * @param Description
     * @param rating
     * @param CallNumber
     * @param ISBN
     */
    public BookDetails(String title,
                       String imageUrl,
                       String Author,
                       String bookState,
                       String serialNumber,
                       String CoAuthor,
                       String Pages,
                       String Description,
                       String rating,
                       String CallNumber,
                       String ISBN) {
        super(title, imageUrl, Author, bookState, serialNumber);
        this.CoAuthor = CoAuthor;
        this.Pages = Pages;
        this.Description = Description;
        this.rating = rating;
        this.CallNumber = CallNumber;
        this.ISBN = ISBN;
    }

    public String getCoAuthor() {
        return CoAuthor;
    }

    public void setCoAuthor(String coAuthor) {
        CoAuthor = coAuthor;
    }

    public String getPages() {
        return Pages;
    }

    public void setPages(String pages) {
        Pages = pages;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCallNumber() {
        return CallNumber;
    }

    public void setCallNumber(String callNumber) {
        CallNumber = callNumber;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


}
