package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BookingCRUDTest extends TestBase {}

//    static String username = "admin";
//    static String password = "password123";
//    static String firstname = "Sheldon";
//    static String lastname = "Cooper";
//    static int totalprice = 111;
//    static Boolean depositpaid = true;
//    static String additionalneeds = "Breakfast";
//    static String token;
//    static int id;
//
//
//    @Steps
//    BookingSteps bookingSteps;
//
//    @Title("This will create a new token")
//    @Test
//    public void test001() {
//
//        ValidatableResponse response = bookingSteps.createToken(username, password);
//        token = response.extract().path("token");
//        System.out.println("token " + token);
//    }
//
//    @Title("This will create new booking")
//    @Test
//    public void test002() {
//        HashMap<String, String> checkInOutDatesData = new HashMap<String, String>();
//        checkInOutDatesData.put("checkin", "2018-01-01");
//        checkInOutDatesData.put("checkout", "2019-01-01");
//
//        ValidatableResponse response = bookingSteps.createBooking(token, firstname, lastname, totalprice, depositpaid,
//                additionalneeds);
//        id = response.extract().path("bookingid");
//        System.out.println("ID " + id);
//    }
//
//    @Title("This will verify if the booking is added")
//    @Test
//    public void test003() {
//        ValidatableResponse response = bookingSteps.getBookingByFirstName(id);
//        String bookingName = response.extract().path("firstname");
//        Assert.assertTrue(bookingName.contains(firstname));
//    }
//
//    @Title("This will update the booking information and checking information updated")
//    @Test
//    public void test004() {
//        firstname = firstname + "updated";
//        ValidatableResponse response = bookingSteps.updateBooking(id, token, firstname, lastname, totalprice, depositpaid, additionalneeds);
//        String updatedBookingName = response.extract().path("firstname");
//        Assert.assertTrue(updatedBookingName.contains(firstname));
//    }
//
//    @Title("This will delete the booking and verify the booking is deleted")
//    @Test
//    public void test005() {
//        bookingSteps.deleteBooking(id);
//        bookingSteps.getBookingById(id);
//    }
//}