package CRUD.Users;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersPUTPATCHTest extends UsersCommon {

    @Test
    public void updateUserPUTTest() {
        Response response = given()
                .contentType(CONTENT_TYPE)
                .body(userBody())
                .when()
                .put(BASE_URL + USERS + "/" + userId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(name, json.get("name"));
        assertEquals(username, json.get("username"));
        assertEquals(email, json.get("email"));
    }

    @Test
    public void updateUserPATCHTest() {
        Response response = given()
                .contentType(CONTENT_TYPE)
                .body(userBodyForPatch())
                .when()
                .patch(BASE_URL + USERS + "/" + userId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(companyCatchPhrase, json.get("company.catchPhrase"));
    }
}
