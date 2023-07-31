package com.example.ils.models;

public class books {
    private String title;
    private String imageUrl;
    private String Author;
    private String bookState;
    private String serialNumber;
    public books(String title, String imageUrl, String Author, String bookState, String serialNumber){
        this.title = title;
        this.imageUrl = imageUrl;
        this.Author = Author;
        this.bookState = bookState;
        this.serialNumber = serialNumber;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public void setAuthor(String Author){
        this.Author = Author;
    }


    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBookState(String bookState){
        this.bookState = bookState;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getSerialNumber() { return serialNumber; }

    public String getBookState() {
        return bookState;
    }

    @Override
    public String toString() {
        return "books{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", Author='" + Author + '\'' +
                ", bookState='" + bookState + '\'' +
                '}';
    }
}
