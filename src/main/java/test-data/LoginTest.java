import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for Login
 */
class LoginTest {
    //covers: email, password: an already created account info.
    @Test
    public void LoginWithExistingAccount() {
        ResponseWithAccessToken res = Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", "ludlz@gmail.com")
                .field("password", "123456")
                .asObject(ResponseWithAccessToken.class)//ObjectMapper
                .getBody();

        System.out.println(res.data.access_token);
        Assertions.assertEquals("1000", res.code);
        Assertions.assertEquals("OK", res.message);
    }

    //covers: email, password: empty string
    @Test
    public void LoginWithNoInput() {
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", "")
                .field("password", "")
                .asObject(Response.class)
                .getBody();

        Assertions.assertEquals("1001", res.code);
    }

    //covers: email: random email with correct format
    //        password: random password
    @Test
    public void LoginWithWrongInfo() {
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", "fuckfuckfuckfuck@gmail.com")
                .field("password", "bruhbruhlmao")
                .asObject(Response.class)
                .getBody();
        Assertions.assertEquals("1002", res.code);
    }

    //covers: email: random string(wrong email format)
    //        password: random string
    //
    @Test
    public void LoginWithWrongEmailFormat() {
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", "fuckfuckfuckfuck")
                .field("password", "bruhbruhlmao")
                .asObject(Response.class)
                .getBody();
        Assertions.assertEquals("1001", res.code);
    }
}