package com.restful.booker.testbase;

import com.restful.booker.util.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by NP
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
//        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
//        RestAssured.basePath = Path.USERS;
    }
}
