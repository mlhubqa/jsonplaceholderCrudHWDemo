package CRUD.Photos;

import COMMON.Common;
import org.junit.jupiter.api.BeforeEach;

public class PhotosCommon extends Common {

    protected final String PHOTOS = "photos";
    protected final Integer numberOfAllPhotos = 5000;
    protected final Integer numberOfPhotosInAlbum = 50;
    protected final Integer numberOfAllAlbums = 100;
    protected final Integer photoId = 401;
    protected final Integer photoAlbumId = 9;

    protected Integer albumId;
    protected String title;
    protected String url;
    protected String thumbnailUrl;

    @BeforeEach
    public void generateFakeData() {
        albumId = faker.number().numberBetween(1, numberOfAllAlbums);
        title = faker.lorem().sentence();
        url = faker.internet().url();
        thumbnailUrl = faker.internet().url();
    }

    public String photoBody() {
        photo.put("albumId", albumId);
        photo.put("title", title);
        photo.put("url", url);
        photo.put("thumbnailUrl", thumbnailUrl);
        return photo.toString();
    }

    public String photoBodyForPatch() {
        photo.put("title", title);
        return photo.toString();
    }
}
