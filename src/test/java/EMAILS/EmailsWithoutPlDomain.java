package EMAILS;

import CRUD.Users.UsersCommon;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailsWithoutPlDomain extends UsersCommon {

    @Test
    public void userWithoutPlDomainGETStreamTest() {

        Response response = given()
                .when()
                .get(BASE_URL + USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> emails = json.getList("email");

        Boolean isAnyEmailWithPlDomain = emails
                .stream()
                .anyMatch(x -> x.endsWith(DOMAIN_PL));

        assertEquals(false, isAnyEmailWithPlDomain);
    }

    @Test
    public void userWithoutPlDomainGETLoopTest() {

        Response response = given()
                .when()
                .get(BASE_URL + USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> emails = json.getList("email");

        Boolean isAnyEmailWithPlDomain = false;

        for (String email : emails) {
            if (email.endsWith(DOMAIN_PL)) {
                System.out.println(email);
                isAnyEmailWithPlDomain = true;
                System.out.println(isAnyEmailWithPlDomain);
                break;
            }
        }
        assertEquals(false, isAnyEmailWithPlDomain);
    }

    @Test
    public void userWithoutPlDomainGETSecondLoopTest() {

        Response response = given()
                .when()
                .get(BASE_URL + USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> emails = json.getList("email");

        Boolean isAnyEmailWithPlDomain = false;

        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).endsWith(DOMAIN_PL)) {
                isAnyEmailWithPlDomain = true;
                break;
            }
        }
        assertEquals(false, isAnyEmailWithPlDomain);
    }
}
