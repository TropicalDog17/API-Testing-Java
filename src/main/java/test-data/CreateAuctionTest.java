import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreateAuctionTest {
    @Test
    public void CreateWithAccessToken() {
        String access_token = Utility.getAccessTokenForTest();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start_date = now.plusDays(1);
        LocalDateTime end_date = now.plusDays(100);
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL + "auctions/create")
                .header("Authorization", "Bearer " + access_token)
                .queryString("category_id", "1")
                .queryString("start_date", dtf.format(start_date))
                .queryString("end_date", dtf.format(end_date))
                .queryString("title_ni", Utility.getRandomString(10))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1000", res.code);
    }
}
