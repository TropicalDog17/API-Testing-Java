import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EditAccountTest {
    @Test
    void EditPasswordOnly() {
        AbstractMap.SimpleEntry<String, String> userInfo = Utility.RandomSignup();
        String email = userInfo.getKey();
        String password = userInfo.getValue();


        String access_token = Utility.mockLogin(email, password);
        assertNotEquals("Wrong user info", access_token);
        ResponseDataAccount res = Unirest.post(Constant.BASE_URL + "edit")
                .header("Authorization", "Bearer " + access_token)
                .header("accept", "application/json")
                .field("email", email)
                .field("password", "12345635465")//Different from the old one
                .field("re_pass", "12345635465")
                .field("name", "Lol")
                .field("phone", "02312793912")
                .asObject(ResponseDataAccount.class)
                .getBody();

        assertEquals("1000", res.code);
        assertEquals("OK", res.message);

        //Try to login again with old password
        String resWithOldPass = Utility.mockLogin(email, password);
        assertEquals("Wrong user info", resWithOldPass);
    }
}
