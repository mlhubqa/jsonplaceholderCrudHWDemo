package CRUD.Users;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class UsersPOSTTest extends UsersCommon {

    @Test
    public void createNewUser() {
        Response response = given()
                .contentType(CONTENT_TYPE)
                .body(userBody())
                .when()
                .post(BASE_URL + USERS)
                .then()
                .statusCode(anyOf(is(HttpStatus.SC_CREATED), is(HttpStatus.SC_OK)))
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(name, json.get("name"));
        assertEquals(username, json.get("username"));
        assertEquals(email, json.get("email"));
    }
}
