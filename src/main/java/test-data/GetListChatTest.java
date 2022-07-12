import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListChatTest {
    @Test
    public void GetListChatWithAccessToken(){
        String access_token = Constant.PUBLIC_ACCESS_CODE;
        ResponseChatList res = Unirest.get(Constant.BASE_URL + "chat").header("Authorization",
                "Bearer " + access_token).asObject(ResponseChatList.class).getBody();
        System.out.println(res);
        assertEquals("1000", res.code);
    }
    @Test
    public void GetListChatWithoutAccessToken(){
        String access_token = "123";
        ResponseChatList res = Unirest.get(Constant.BASE_URL + "chat").header("Authorization",
                "Bearer "+ access_token).asObject(ResponseChatList.class).getBody();
        System.out.println(res);
        assertEquals("1004", res.code);
    }
}
