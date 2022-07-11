import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;

public class EditAccountTest {
    @Test
    void EditPasswordOnly() {
        AbstractMap.SimpleEntry<String, String> userInfo = Utility.RandomSignup();
        String email = userInfo.getKey();
        String password = userInfo.getValue();


        String access_token = Utility.getAccessTokenForTest(email, password);
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
        String resWithOldPass = Utility.getAccessTokenForTest(email, password);
        assertEquals("Wrong user info", resWithOldPass);
    }

    @Test
    void EditEmailAndPasswordCorrectly() {
<<<<<<< HEAD
        ResponseDataAccount res = randomSignupLoginAndEdit(Utility.RandomEmail.getRandomEmail(20), "3497234932", "3497234932", "Lo4l", "349028402384");
=======
        ResponseDataAccount res = randomSignupLoginAndEdit(Utility.getRandomEmail(20), "3497234932", "3497234932", "Lo4l", "349028402384");
>>>>>>> parameterize-test
        System.out.println(res.message);
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);

    }

    //Tao 2 tai khoan, edit truong email cua tai khoan thu nhat bang gia tri cua tai khoan thu 2
    // Expected: code = 1001, login vao tai khoan thu nhat va thu 2 voi thong tin cu ok
    @Test
    void EditWithExistingEmail() {


        AbstractMap.SimpleEntry<String, String> anotherUserInfo = Utility.RandomSignup();
        String anotherEmail = anotherUserInfo.getKey();
        String anotherPassword = anotherUserInfo.getValue();

        //Edit new email with an existing email
        ResponseDataAccount res = randomSignupLoginAndEdit(anotherEmail, "12314802384", "12314802384", "Lol", "48092343204");


        assertEquals("1001", res.code);
        assertNotEquals("Wrong user info", Utility.getAccessTokenForTest(anotherEmail, anotherPassword));

    }

    private ResponseDataAccount randomSignupLoginAndEdit(String newEmail, String newPassword, String newRe_pass, String newName, String newPhone) {
        AbstractMap.SimpleEntry<String, String> userInfo = Utility.RandomSignup();
        String email = userInfo.getKey();
        String password = userInfo.getValue();

        String access_token = Utility.getAccessTokenForTest(email, password);
        return Unirest.post(Constant.BASE_URL + "edit")
                .header("Authorization", "Bearer " + access_token)
                .header("accept", "application/json")
                .field("email", newEmail)
                .field("password", newPassword)//Different from the old one
                .field("re_pass", newRe_pass)
                .field("name", newName)
                .field("phone", newPhone)
                .asObject(ResponseDataAccount.class)
                .getBody();
    }
}
