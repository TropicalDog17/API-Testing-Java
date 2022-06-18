import java.lang.reflect.Array;
import java.util.*;

public class Constant {
    private final static ArrayList<String> baseEndpoints = new ArrayList<String>(Arrays.asList("login", "signup", "edit", "logout", "auctions", "auctions/listAuctionsByStatus/{statusId}", "auctions/listAuctionByUser", "listAuctions/{typeId}", "auctions/detail/{auctionId}", "auctions/create", "auctions/edit", "{auctionId}", "items/create/{auctionId}", "comments/create/{auctionId}", "comments", "bids/create/{auctionId}", "bids/{auctionId}", "categories", "brands", "accept", "{auctionId}", "contactUs", "updateLike", "likes/{statusId}", "totalLikes" + "/{auctionId}", "news", "news/read/{newId}", "notifications", "notifications/read/{auctionDenyId}", "slider", "search", "comments/delete/{commentId}"));
    private final static ArrayList<String> auctionEndpoints = new ArrayList<String>(Arrays.asList("listAuctionsByStatus/{statusId}", "listAuctionByUser", "listAuctions/{typeId}", "detail/{auctionId}", "create", "edit/{auctionId}"));
    private final static ArrayList<String> commentEndpoints = new ArrayList<String>(Arrays.asList("create/{auctionId}", "{auctionId}", "delete/{commentId}"));
    private final static ArrayList<String> notificationEndpoints = new ArrayList<String>(Arrays.asList("", "read/{auctionDenyId}"));
    private final static ArrayList<String> bidEndpoints = new ArrayList<String>(Arrays.asList("create" + "/{auctionId}", "{auctionId}"));
    private final static ArrayList<String> newsEndpoints = new ArrayList<String>(Arrays.asList("", "read/{newId}"));
    static final String BASE_URL = "https://auctions-app-2.herokuapp.com/api/";
    private static Set<String> IGNORED_CLASS_METHODS = new HashSet<String>(Arrays.asList("wait", "equals", "toString", "hashCode", "getClass", "notify", "notifyAll"));
    public static Map<String, String> TEST_SUITES = new HashMap<String, String>() {{
        put("login", "LoginTest");
        put("categories", "GetCategoriesTest");
    }};
    public static final HashMap<String, String> BASE_URL_LIST = new HashMap<String, String>() {{
        put("1", "https://auctions-app-2.herokuapp.com/api/auctions/");
        put("2", "https://auctions-app-2.herokuapp.com/api/comments/");
        put("3", "https://auctions-app-2.herokuapp.com/api/notifications/");
        put("4", "https://auctions-app-2.herokuapp.com/api/bid/");
        put("5", "https://auctions-app-2.herokuapp.com/api/news/");
    }};

    public static HashMap<String, ArrayList<String>> ENDPOINT_LIST = new HashMap<String, ArrayList<String>>() {{
        put("0", baseEndpoints);
        put("1", auctionEndpoints);
        put("2", commentEndpoints);
        put("3", notificationEndpoints);
        put("4", bidEndpoints);
        put("5", newsEndpoints);
    }};
}
