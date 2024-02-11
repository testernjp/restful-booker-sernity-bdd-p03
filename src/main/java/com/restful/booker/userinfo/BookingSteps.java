package com.restful.booker.userinfo;

import com.restful.booker.constant.EndPoints;
import com.restful.booker.model.BookingPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;

public class BookingSteps {

    @Step("Create booking with firstname : {0}, lastname : {1}, totalprice : {2}, depositpaid : {3}, additionalneeds : {4}, checkin : {5}, checkout : {6}")
    public ValidatableResponse createBooking(String token, String firstname,String lastname,String totalprice,String depositpaid,String additionalneeds,String checkin, String checkout){

        HashMap<String,String>checkInOutDatesData = new HashMap<String,String>();
        checkInOutDatesData.put("checkin",checkin);
        checkInOutDatesData.put("checkout",checkout);

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalprice(totalprice);
        bookingPojo.setDepositpaid(depositpaid);
        bookingPojo.setAdditionalneeds(additionalneeds);
        bookingPojo.setBookingdates(checkInOutDatesData);

        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("cookie", token)
                .body(bookingPojo)
                .when()
                .post(EndPoints.CREATE_BOOKING_IDS)
                .then().log().all().statusCode(200);
    }
    @Step("Getting the booking information with the firstname : {0}")
    public ValidatableResponse getBookingByFirstName(int id){
        return SerenityRest.given().log().all()
                .pathParam("bookingId",id)
                .header("Accept", "*/*")
                .header("Connection","keep-alive")
                .when()
                .get(EndPoints.GET_SINGLE_BOOKING_BY_ID)
                .then().log().all()
                .statusCode(200);
    }

    @Step("Updating the booking information id : {0}, token : {1}, firstname : {2}, lastname : {3}, totalprice : {4}, depositpaid : {5}, additionalneeds : {6}, checkin : {7}, checkout : {8}")
    public ValidatableResponse updateBooking(int id, String token, String firstname,String lastname,String totalprice,String depositpaid, String additionalneeds, String checkin, String checkout){

        HashMap<String,String>checkInOutDatesData = new HashMap<String,String>();
        checkInOutDatesData.put("checkin",checkin);
        checkInOutDatesData.put("checkout",checkout);

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalprice(totalprice);
        bookingPojo.setDepositpaid(depositpaid);
        bookingPojo.setAdditionalneeds(additionalneeds);
        bookingPojo.setBookingdates(checkInOutDatesData);

        return SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .header("Cookie",token)
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Accept", "*/*")
                .pathParam("bookingId",id)
                .when()
                .body(bookingPojo)
                .put(EndPoints.UPDATE_BOOKING_BY_ID)
                .then().log().all()
                .statusCode(200);
    }

    @Step("Deleting the booking information with bookingId : {0}")
    public ValidatableResponse deleteBooking(int id){

        return SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .header("Cookie","token")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Accept", "*/*")
                .pathParam("bookingId",id)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then().log().all()
                .statusCode(201);
    }

    @Step("Getting booking information with bookingId : {0}")
    public ValidatableResponse getBookingById(int id){

        return SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .header("Cookie","token")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Accept", "*/*")
                .pathParam("bookingId",id)
                .when()
                .get(EndPoints.GET_SINGLE_BOOKING_BY_ID)
                .then().log().all()
                .statusCode(404);
    }
}