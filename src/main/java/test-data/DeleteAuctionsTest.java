import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
public class DeleteAuctionsTest {
    @Test
    public void DeleteAuctions(){
        String access_token=Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseDeleteAuctions res = Unirest.post(Constant.BASE_URL+"auctions/deleteAuction/1913")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseDeleteAuctions.class)
                .getBody();
        assertEquals("1000",res.code);
        System.out.println(res.message);
    }
    @Test
    public void DeleteAuctionsWithoutAccessToken(){
        String access_token= new String();
        ResponseDeleteAuctions res = Unirest.post(Constant.BASE_URL+"auctions/deleteAuction/1913")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseDeleteAuctions.class)
                .getBody();
        assertNull(res);
    }
    @Test
    public void DeleteAuctionsWithApprovedAuctions(){
        String access_token=Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseDeleteAuctions res = Unirest.post(Constant.BASE_URL+"auctions/deleteAuction/1641")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseDeleteAuctions.class)
                .getBody();
        assertEquals("9994",res.code);
        System.out.println(res.message);
    }
    @Test
    public void DeleteAuctionsThatNotYours(){
        String access_token=Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseDeleteAuctions res = Unirest.post(Constant.BASE_URL+"auctions/deleteAuction/1717")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseDeleteAuctions.class)
                .getBody();
        assertEquals("1006",res.code);
        System.out.println(res.message);
    }
}
