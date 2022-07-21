import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListChatTest {
    @Test
    public void GetListChatWithAccessToken(){
        String access_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU4MDY0NTgyLCJleHAiOjE2NTg0MjQ1ODIsIm5iZiI6MTY1ODA2NDU4MiwianRpIjoibnJ1U0RqSDZNeEFBa0wzciIsInN1YiI6NDkwLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.MrQGcJ9OMBSpVkDmtKNYaj9m1TW8ejIs00cQVEAEERA";
        ResponseChatList res = Unirest.get(Constant.BASE_URL + "chat").header("Authorization",
                "Bearer " + access_token).asObject(ResponseChatList.class).getBody();
        assertEquals("1000", res.code);
        System.out.println(res.data.chat.toString());
    }
    @Test
    public void GetListChatWithoutAccessToken(){
        String access_token = "123";
        ResponseChatList res = Unirest.get(Constant.BASE_URL + "chat")
                .header("Authorization", "Bearer "+ access_token).
                asObject(ResponseChatList.class).
                getBody();
        System.out.println(res);
        assertEquals("1004", res.code);
    }
}
