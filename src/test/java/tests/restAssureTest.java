package tests;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class restAssureTest {
    @Test
    public void isGoogleUp(){
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
