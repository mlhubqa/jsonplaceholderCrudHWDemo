package CRUD.Users;

import COMMON.Common;
import org.junit.jupiter.api.BeforeEach;

public class UsersCommon extends Common {

    protected final String USERS = "users";
    protected final Integer numberOfAllUsers = 10;
    protected final Integer userId = 1;
    protected final String DOMAIN_PL = ".pl";

    protected String name;
    protected String username;
    protected String email;
    protected String phone;
    protected String website;
    protected String lat;
    protected String lng;
    protected String street;
    protected long suite;
    protected String city;
    protected String zipcode;
    protected String companyName;
    protected String companyCatchPhrase;
    protected String companyBs;

    @BeforeEach
    public void generateFakeData() {
        name = faker.name().name();
        username = faker.name().fullName();
        email = faker.internet().emailAddress();
        phone = faker.phoneNumber().phoneNumber();
        website = faker.internet().url();
        lat = faker.address().latitude();
        lng = faker.address().longitude();
        street = faker.address().streetName();
        suite = faker.number().randomNumber();
        city = faker.address().city();
        zipcode = faker.address().zipCode();
        companyName = faker.company().name();
        companyCatchPhrase = faker.company().catchPhrase();
        companyBs = faker.company().bs();
    }

    public String userBody() {
        geo.put("lat", lat);
        geo.put("lng", lng);

        address.put("street", street);
        address.put("suite", suite);
        address.put("city", city);
        address.put("zipcode", zipcode);
        address.put("geo", geo);

        company.put("name", companyName);
        company.put("catchPhrase", companyCatchPhrase);
        company.put("bs", companyBs);

        user.put("name", name);
        user.put("username", username);
        user.put("email", email);
        user.put("phone", phone);
        user.put("website", website);
        user.put("address", address);
        user.put("company", company);

        return user.toString();
    }

    public String userBodyForPatch() {
        user.put("company", company);
        company.put("catchPhrase", companyCatchPhrase);
        return user.toString();
    }
}
