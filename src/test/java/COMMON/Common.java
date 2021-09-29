package COMMON;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;

public class Common {

    protected final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    protected final String CONTENT_TYPE = "application/json";

    public static Faker faker;

    public static JSONObject photo;
    public static JSONObject user;
    public static JSONObject geo;
    public static JSONObject address;
    public static JSONObject company;

    @BeforeAll
    public static void beforeAll() {
        faker = new Faker();

        photo = new JSONObject();
        user = new JSONObject();
        geo = new JSONObject();
        address = new JSONObject();
        company = new JSONObject();
    }
}
