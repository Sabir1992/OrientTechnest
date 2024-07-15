import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingId extends BaseTests{


    @Test
    public void getBookingId(){

        spec.queryParam("firstname", "SFKSFBKI");

        Response response = given(spec)
                .when()
                .get("/booking/"+getId());
        response
                .then()
                .statusCode(200);


        String firstname = response.jsonPath().getJsonObject("firstname");
        String date = response.jsonPath().getJsonObject("bookingdates.checkin");
        int totalprice = response.jsonPath().getJsonObject("totalprice");


        Assertions.assertEquals("Sabir", firstname);



    }

}
