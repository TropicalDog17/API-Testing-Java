import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptMaxBidsTest {
    @Test
    public void InitialTest() {
        String access_token = Utility.getAccessTokenForTest();
        ResponseAcceptMaxBid res = Unirest.post(Constant.BASE_URL + "accept/8")
                .header("Authorization", "Bearer " + access_token)
                .queryString("selling_info", "1233454542543j5ljldfjlsfjlad;falfjadl;sjfl;a")
                .asObject(ResponseAcceptMaxBid.class)
                .getBody();
        assertEquals("1000", res.code);
    }
}
