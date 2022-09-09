package junit.jupiter;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTests {
    @BeforeAll
    static void before() {
        RestAssured.baseURI = "https://reqres.in";
    }
}
