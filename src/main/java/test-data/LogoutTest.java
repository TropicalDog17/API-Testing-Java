import kong.unirest.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LogoutTest {

    @Test
        //LoginRequired
    void LogoutWhenAlreadySignedIn() {
        //Login using an existing account
        String access_token = Utility.getAccessTokenForTest("luldz@gmail.com", "123456");
        //test for logout functionality
        ResponseWithAccessToken logoutResponse = Unirest.post("https://auctions-app-2.herokuapp" + ".com/api/logout")
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseWithAccessToken.class)
                .getBody();
        System.out.println(logoutResponse.code);
        assertEquals("1000", logoutResponse.code);
        assertNull(logoutResponse.data);
    }

}
