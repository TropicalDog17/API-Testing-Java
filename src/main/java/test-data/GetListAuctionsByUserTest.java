import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GetListAuctionsByUserTest {
    @Test
    void GetListAuctionsByNewUser() {
        String access_token = Utility.mockLogin("ludlz@gmail.com", "123456");
        ResponseDataAuction res = Unirest.get(Constant.BASE_URL + "auctions/listAuctionsByUser" + "/{statusId}")
                .routeParam("statusId", "3")
                .queryString("index", "0")
                .queryString("count", "10")
                .header("Authentication", "Bearer " + access_token)
                .asObject(ResponseDataAuction.class)
                .getBody();
        assertEquals("1004", res.code);
        assertNotEquals("OK", res.message);
    }
}
