import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GetListAuctionsByStatusTest {
    @Test
    void GetListAuctionsByStatusWithoutLogin() {
        String statusId = "1";
        ResponseDataAuction res = getListAuctionsByStatusId(statusId);
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
        assertEquals(statusId, res.data.auctions.get(0).statusId);
    }

    @Test
    void getListAuctionsByStatusWrongStatusId() {
        String statusId = "10"; //outside 1-6;

        ResponseDataAuction res = getListAuctionsByStatusId(statusId);
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
        assertEquals(0, res.data.auctions.size());

    }

    private ResponseDataAuction getListAuctionsByStatusId(String statusId) {
        ResponseDataAuction res = Unirest.get(Constant.BASE_URL + "auctions/listAuctionsByStatus" + "/{statusId}")
                .routeParam("statusId", statusId)
                .queryString("index", "1")
                .queryString("count", "10")
                .asObject(ResponseDataAuction.class)
                .getBody();
        return res;
    }
}

