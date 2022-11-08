package get_requests;

import base_urls.ResfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_12Pojos extends ResfulBaseUrl {
     /*
       Given
           https://restful-booker.herokuapp.com/booking/20
       When
         I send GET Request to the URL
      Then
         Status code is 200
     And
         Response body is like:
                      {
                         "firstname": "Sally",
                         "lastname": "Brown",
                         "totalprice": 111,
                         "depositpaid": true,
                         "bookingdates": {
                             "checkin": "2013-02-23",
                             "checkout": "2014-10-23"
                },
    "additionalneeds": "Breakfast"
}
    */

    @Test
    public void get12() {
        spec.pathParams("first","booking","second",20);

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2013-02-23","2014-10-23");
        BookingPojo expData = new BookingPojo("Sally","Brown",111,true,bookingDatesPojo,"Breakfast");


        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        BookingPojo actData = response.as(BookingPojo.class);

        System.out.println("expData = " + expData);
        System.out.println("actData = " + actData);


    }
}
