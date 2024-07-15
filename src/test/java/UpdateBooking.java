import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends BaseTests {


    @Test
    public void updateBooking() {



        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + createToken())
                .body(getJsonObject2("Sabir2", "Tahirli2",999))
                .put("/booking/"+getId());



    }



}