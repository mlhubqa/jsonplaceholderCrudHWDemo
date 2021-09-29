package CRUD.Photos;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotosPOSTTest extends PhotosCommon {

    @Test
    public void createNewPhoto() {

        Response response = given()
                .contentType(CONTENT_TYPE)
                .body(photoBody())
                .when()
                .post(BASE_URL + PHOTOS)
                .then()
                .statusCode(anyOf(is(HttpStatus.SC_CREATED), is(HttpStatus.SC_OK)))
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(albumId, json.getInt("albumId"));
        assertEquals(title, json.get("title"));
        assertEquals(url, json.get("url"));
        assertEquals(thumbnailUrl, json.get("thumbnailUrl"));
    }
}
