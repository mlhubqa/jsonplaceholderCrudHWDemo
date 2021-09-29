package CRUD.Photos;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotosPUTPATCHTest extends PhotosCommon {

    @Test
    public void updatePhotoPUT() {
        Response response = given()
                .contentType(CONTENT_TYPE)
                .body(photoBody())
                .when()
                .put(BASE_URL + PHOTOS + "/" + photoId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(albumId, json.getInt("albumId"));
        assertEquals(title, json.get("title"));
        assertEquals(url, json.get("url"));
        assertEquals(thumbnailUrl, json.get("thumbnailUrl"));
    }

    @Test
    public void updatePhotoPATCH() {
        Response response = given()
                .contentType(CONTENT_TYPE)
                .body(photoBodyForPatch())
                .when()
                .patch(BASE_URL + PHOTOS + "/" + photoId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(title, json.get("title"));
    }
}
