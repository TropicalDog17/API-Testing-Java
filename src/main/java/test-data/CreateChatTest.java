import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChatTest {
    @Test
    public void CreateChatWithAccessToken(){
        String access_token = Utility.getAccessTokenForTest();
        ResponseCreateChat res =
                Unirest.post(Constant.BASE_URL + "chat/conversation/2").header(
                        "Authorization", "Bearer " + access_token).asObject(ResponseCreateChat.class).getBody();
        //2: random user ID
        assertEquals("1000", res.code);
        assertEquals("OK", res.code);
    }
}
