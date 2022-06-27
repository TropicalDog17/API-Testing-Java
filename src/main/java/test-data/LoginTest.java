import kong.unirest.Unirest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for Login
 */
class LoginTest {
    //covers: email, password: an already created account info.
    @Test
    public void LoginWithExistingAccount() {
        Response res = doLogin("ludlz@gmail.com", "123456");
        Assertions.assertEquals("1000", res.code);
        Assertions.assertEquals("OK", res.message);
    }

    //covers: email, password: empty string
    @Test
    public void LoginWithNoInput() {
        Response res = doLogin("", "");
        Assertions.assertEquals("1001", res.code);
    }


    //covers: email: random email with correct format
    //        password: random password
    @Test
    public void LoginWithWrongInfo() {
        Response res = doLogin("fuckfuckfuckfuck@gmail.com", "bruhbruhlmao");
        Assertions.assertEquals("1002", res.code);
    }

    //covers: email: random string(wrong email format)
    //        password: random string
    //
    @Test
    public void LoginWithWrongEmailFormat() {
        Response res = doLogin("fuckfuckfuckfuck", "bruhbruhlmao");
        Assertions.assertEquals("1001", res.code);
    }

    private Response doLogin(String email, String password) {
        return Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", email)
                .field("password", password)
                .asObject(Response.class)
                .getBody();
    }
}