import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMessageOfChatTest{
    @Test
    public void CreateMessageWithAccessToken(){
        String access_token = Utility.getAccessTokenForTest();
        ResponseCreateMessageOfChat res =
                Unirest.post(Constant.BASE_URL + "chat/message").header("Authorization",
                        "Bearer " + access_token).queryString("chat_id",
                        "3").queryString("content", "lol").queryString("user_send_id", Constant.USER_ID).asObject(ResponseCreateMessageOfChat.class).getBody();
        assertEquals("1000", res.code);
    }
}
