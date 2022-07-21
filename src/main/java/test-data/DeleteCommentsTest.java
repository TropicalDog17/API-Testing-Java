import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeleteCommentsTest {
    @Test
    public void DeleteCommentsKhongDuocXoa(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        int commentId = 818;
        ResponseDeleteCommnets res = Unirest.post(Constant.BASE_URL +"comments/delete/" + commentId)
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseDeleteCommnets.class)
                .getBody();
        assertEquals("1006",res.code);
    }
    @Test
    public void DeleteComments(){
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com","thanhpro");
        int commentId = 977;
        ResponseDeleteCommnets res = Unirest.post(Constant.BASE_URL +"comments/delete/" + commentId)
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseDeleteCommnets.class)
                .getBody();
        assertEquals("1006",res.code);
    }
    @Test
    public void DeleteCommentsWhithoutLogin(){
        // bi loi res tra ve null
        String access_token = "1234";
        int commentId = 977;
        ResponseDeleteCommnets res = Unirest.post(Constant.BASE_URL +"comments/delete/" + commentId)
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseDeleteCommnets.class)
                .getBody();
        assertNull(res);
    }
    /*@Test
    public void XoaduocCommnets(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmai.com","12345");
        int commentId = 977;
        ResponseDeleteCommnets res = Unirest.post(Constant.BASE_URL +"comments/delete/" + commentId)
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseDeleteCommnets.class)
                .getBody();
        assertEquals("1000",res.code);
    }*/
}
