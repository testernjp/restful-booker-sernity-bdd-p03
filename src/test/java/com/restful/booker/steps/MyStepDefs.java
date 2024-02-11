package com.restful.booker.steps;

import com.restful.booker.userinfo.AuthSteps;
import com.restful.booker.userinfo.BookingSteps;
import com.restful.booker.util.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
public class MyStepDefs {

    static String firstname = null;
    static String lastname = null;
    static String totalprice = null;
    static String updatedfirstname = null;
    static String updatedlastname = null;
    static String updatedtotalprice = null;
    static String depositpaid;
    static String additionalneeds;
    static String checkin;
    static String checkout;
    static String token;
    static int id;

    @Steps
    BookingSteps bookingSteps;
    @Steps
    AuthSteps authSteps;

    @Given("I am on home page")
    public void iAmOnHomePage() {
    }

    @When("I create a new booking providing username {string} password {string}")
    public void iCreateANewBookingProvidingUsernamePassword(String username, String password) {
        ValidatableResponse response = authSteps.createToken("admin","password123");
        token = response.extract().path("token");
        System.out.println("token " + token);
    }
    @Then("I create a new booking providing {string} {string} {string} {string} {string} {string} {string}")
    public void iCreateANewBookingProviding(String _firstname, String _lastname, String _totalprice, String depositpaid, String additionalneeds, String checkin, String checkout) {
        firstname = TestUtils.getRandomValue()+_firstname;
        lastname  = TestUtils.getRandomValue()+_lastname;
        totalprice = TestUtils.getRandomValue()+_totalprice;
        ValidatableResponse response = bookingSteps.createBooking(token,firstname,lastname,totalprice,depositpaid,additionalneeds,checkin,checkout);
        id = response.extract().path("bookingid");
        System.out.println("ID " + id);
    }

    @Then("I verify that the booking is created successfully")
    public void iVerifyThatTheBookingIsCreatedSuccessfully() {
        ValidatableResponse response=bookingSteps.getBookingByFirstName(id);
        String bookingName=response.extract().path("firstname");
        Assert.assertTrue(bookingName.contains(firstname));
    }
    @And("I update the user with updatefirstname {string} updatelastname {string} updatetotal price {string}{string} {string} {string} {string}")
    public void iUpdateTheUserWithUpdatefirstnameUpdatelastnameUpdatetotalPrice(String _updatedfirstname, String _updatedlastname, String _updatedtotalprice, String depositpaid, String additionalneeds, String checkin, String checkout) {
        updatedfirstname = TestUtils.getRandomValue()+_updatedfirstname;
        updatedlastname = TestUtils.getRandomValue()+_updatedlastname;
        updatedtotalprice = TestUtils.getRandomValue()+_updatedtotalprice;
        ValidatableResponse response=bookingSteps.updateBooking(id,token,updatedfirstname,updatedlastname,updatedtotalprice,depositpaid,additionalneeds,checkin,checkout);
        String updatedBookingName=response.extract().path("firstname");
        Assert.assertTrue(updatedBookingName.contains(updatedfirstname));
    }

    @Then("I verify that the booking with updatefirstname {string} is updated successfully")
    public void iVerifyThatTheBookingWithUpdatefirstnameIsUpdatedSuccessfully(String firstname) {
        ValidatableResponse response=bookingSteps.getBookingByFirstName(id);
        String bookingName=response.extract().path("firstname");
        Assert.assertTrue(bookingName.contains(firstname));
    }

    @When("I delete the updated booking")
    public void iDeleteTheUpdatedBooking() {
        bookingSteps.deleteBooking(id);
    }

    @Then("I verify that the booking is deleted successfully")
    public void iVerifyThatTheBookingIsDeletedSuccessfully() {
        bookingSteps.getBookingById(id);
    }
}
