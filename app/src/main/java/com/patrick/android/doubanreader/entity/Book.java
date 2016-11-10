package com.patrick.android.doubanreader.entity;

/**
 * Created by Administrator on 2016/11/10.
 */

public class Book {
    private String book_name;
    private String  book_image_address;
    private String book_detail_address;

    public String getBook_detail_address() {
        return book_detail_address;
    }

    public void setBook_detail_address(String book_detail_address) {
        this.book_detail_address = book_detail_address;
    }

    public String getBook_image_address() {
        return book_image_address;
    }

    public void setBook_image_address(String book_image_address) {
        this.book_image_address = book_image_address;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
}
