import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListComment {
    @Test
    public void Getlistcomment() {
        String access_token = Utility.getAccessTokenForTest("annm@gmail.com","12345");
        ResponseGetlistcomment res = Unirest.get(Constant.BASE_URL + "comments/1")
                .header("Authorization", "Bearer" + access_token)
                .queryString("index", "1")
                .queryString("count","1")
                .asObject(ResponseGetlistcomment.class)
                .getBody();
        assertEquals("1000", res.code);
    }
    @Test
    public void GetlistcommentWithoutAccessToken() {
        String access_token = new String();
        ResponseGetlistcomment res = Unirest.get(Constant.BASE_URL + "comments/3")
                .header("Authorization", "Bearer" + access_token)
                .queryString("index", "1")
                .queryString("count", "2")
                .asObject(ResponseGetlistcomment.class)
                .getBody();
        assertEquals("1000", res.code);
        System.out.println(res.data.comments.get(0).user_name);
    }
    @Test
    public void Getlistcomment3() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseGetlistcomment res = Unirest.get(Constant.BASE_URL + "comments/2")
                .header("Authorization", "Bearer" + access_token)
                .queryString("index", "2")
                .queryString("count","1")
                .asObject(ResponseGetlistcomment.class)
                .getBody();
        assertEquals("1000", res.code);
    }
}


