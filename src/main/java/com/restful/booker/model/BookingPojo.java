package com.restful.booker.model;

import java.util.HashMap;

public class BookingPojo {
    private String firstname ;
    private String lastname ;
    private String totalprice;
    private String depositpaid ;
    private String additionalneeds ;

    public HashMap<String, String> getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HashMap<String, String> bookingdates) {
        this.bookingdates = bookingdates;
    }

    private HashMap<String,String> bookingdates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}