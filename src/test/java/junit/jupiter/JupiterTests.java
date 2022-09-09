package junit.jupiter;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class JupiterTests {

    @Test
    @DisplayName("test")
    public void test1() {
        RestAssured.baseURI = "https://reqres.in";
        given().when().get("/api/users/2").then().log().body()
                .assertThat()
                .statusCode(201)
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"))
                .body("data.first_name", equalTo("Jack"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
                .body("support.url", notNullValue())
                .body("support.text", containsStringIgnoringCase("to keep reqRes FREE"));
    }
}
