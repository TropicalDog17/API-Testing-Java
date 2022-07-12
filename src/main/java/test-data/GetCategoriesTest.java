import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GetCategoriesTest {
    @Test
    public void getCategories() {
        Response res = Unirest.get("https://auctions-app-2.herokuapp.com/api/categories")
                .asObject(Response.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }
}
