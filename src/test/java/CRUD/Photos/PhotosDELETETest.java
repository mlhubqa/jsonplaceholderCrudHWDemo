package CRUD.Photos;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PhotosDELETETest extends PhotosCommon {

    @Test
    public void deletePhoto() {
        given()
                .when()
                .delete(BASE_URL + PHOTOS + "/" + photoId)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
