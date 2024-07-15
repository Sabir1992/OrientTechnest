import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBooking extends BaseTests {



        @Test
        public void createBooking() {


           Response response = createBookingm();

            String name = response.jsonPath().getJsonObject("booking.firstname");
            Assertions.assertEquals("Sabir", name);

        }




}
