package CRUD.Users;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class UsersGETTwoTest extends UsersCommon {

    @Test
    public void readAllUsers() {
        Response response = given()
                .when()
                .get(BASE_URL + USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> names = json.getList("name");
        assertEquals(numberOfAllUsers, names.size());
    }

    @Test
    public void readOneUserById() {
        given()
                .when()
                .get(BASE_URL + USERS + "/" + userId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("Leanne Graham"))
                .body("username", equalTo("Bret"))
                .body("email", equalTo("Sincere@april.biz"))
                .body("address.street", equalTo("Kulas Light"));
    }

    @Test
    public void radOneUserWithPathVariable() {
        given()
                .pathParam("userId", userId)
                .when()
                .get(BASE_URL + USERS + "/{userId}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("Leanne Graham"))
                .body("username", equalTo("Bret"))
                .body("email", equalTo("Sincere@april.biz"))
                .body("address.street", equalTo("Kulas Light"));
    }

    @Test
    public void readUsersWithQueryParams() {
        Response response = given()
                .queryParam("username", "Bret")
                .when()
                .get(BASE_URL + USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals("Leanne Graham", json.getList("name").get(0));
        assertEquals("Bret", json.getList("username").get(0));
        assertEquals("Sincere@april.biz", json.getList("email").get(0));
        assertEquals("Kulas Light", json.getList("address.street").get(0));
    }
}
