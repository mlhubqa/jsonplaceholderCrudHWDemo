package CRUD.Users;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UsersDELETETest extends UsersCommon {

    @Test
    public void jsonplaceholderDeleteUser() {
        Response response = given()
                .when()
                .delete(BASE_URL + USERS + "/" + userId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }
}
