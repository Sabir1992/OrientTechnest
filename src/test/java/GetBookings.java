import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookings extends BaseTests{

    @Test
    public void getAllBooking(){

        spec.queryParam("firstname", "SabirXXXX");

        Response response =  given(spec)
                 .when()
                 .get("/booking");
                response
                 .then()
                 //.log().all()
                 .statusCode(200);
        //response.prettyPrint();


}



}
