import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class BaseTests {

    RequestSpecification spec;


    @BeforeEach
    public void setup(){
        //System.out.println("Running Before Each Test");
         spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();
         //test
    }


    public String getJsonObject(){
        JSONObject body = new JSONObject();
        body.put("firstname", "SabirXXXX");
        body.put("lastname", "Tahirli");
        body.put("totalprice",1000);
        body.put("depositpaid", true);

        JSONObject bookingDate = new JSONObject();
        bookingDate.put("checkin", "2025-01-01");
        bookingDate.put("checkout", "2026-01-01");

        body.put("bookingdates", bookingDate);
        body.put("additionalneeds", "Breakfast");
        return body.toString();
    }


    public Response createBookingm(){



        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(getJsonObject())
                .post("/booking");
        response
                .then()
                .statusCode(200);
        return response;
    }


    public int getId(){
        Response response = createBookingm();
        return response.jsonPath().getJsonObject("bookingid");
    }


    public String getJsonObject2(String firstname, String lastname,int price){
        JSONObject body = new JSONObject();
        body.put("firstname", firstname);
        body.put("lastname", lastname);
        body.put("totalprice",price);
        body.put("depositpaid", true);

        JSONObject bookingDate = new JSONObject();
        bookingDate.put("checkin", "2025-01-01");
        bookingDate.put("checkout", "2026-01-01");

        body.put("bookingdates", bookingDate);
        body.put("additionalneeds", "Breakfast");
        return body.toString();
    }

    public String createToken() {
        JSONObject body = new JSONObject();
        body.put("username", "admin");
        body.put("password", "password123");

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/auth");
        response
                .then()
                .statusCode(200);
        return response.jsonPath().getJsonObject("token");
    }

}
