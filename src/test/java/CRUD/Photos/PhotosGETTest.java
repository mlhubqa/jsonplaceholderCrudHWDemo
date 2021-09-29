package CRUD.Photos;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotosGETTest extends PhotosCommon {

    @Test
    public void readAllPhotos() {
        Response response = given()
                .when()
                .get(BASE_URL + PHOTOS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> photos = json.getList("id");
        assertEquals(numberOfAllPhotos, photos.size());
    }

    @Test
    public void readOnePhotoById() {
        Response response = given()
                .when()
                .get(BASE_URL + PHOTOS + "/" + photoId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(photoAlbumId, json.get("albumId"));
        assertEquals("vitae et cumque velit repellat eaque", json.get("title"));
        assertEquals("https://via.placeholder.com/600/9f134c", json.get("url"));
        assertEquals("https://via.placeholder.com/150/9f134c", json.get("thumbnailUrl"));
    }

    @Test
    public void readOnePhotoWithPathVariable() {
        Response response = given()
                .pathParam("id", photoId)
                .when()
                .get(BASE_URL + PHOTOS + "/{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(photoAlbumId, json.get("albumId"));
        assertEquals("vitae et cumque velit repellat eaque", json.get("title"));
        assertEquals("https://via.placeholder.com/600/9f134c", json.get("url"));
        assertEquals("https://via.placeholder.com/150/9f134c", json.get("thumbnailUrl"));
    }

    @Test
    public void readPhotosWithQueryParams() {
        Response response = given()
                .queryParam("albumId", photoAlbumId)
                .when()
                .get(BASE_URL + PHOTOS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> photos = json.getList("id");
        assertEquals(numberOfPhotosInAlbum, photos.size());
    }
}
