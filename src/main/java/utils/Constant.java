import java.util.*;

public class Constant {
    private final static ArrayList<String> baseEndpoints = new ArrayList<>(Arrays.asList("login",
            "signup", "edit", "logout", "auctions", "auctions/listAuctionsByStatus/{statusId}",
            "auctions/listAuctionByUser", "listAuctions/{typeId}", "auctions/detail/{auctionId}",
            "auctions/create", "auctions/edit", "items/create/{auctionId}",
             "comments/{auctionId}", "bids/create" +
                    "/{auctionId}", "bids/{auctionId}", "categories", "brands", "accept",
             "likes/{statusId}", "totalLikes" + "/{auctionId}", "news", "news/read" +
                    "/{newId}", "notifications", "notifications/read/{auctionDenyId}", "slider",
            "search","chat/message/{chatId}", "comments/create/{auctionId}","comments/delete" +
                    "/{commentId}","chat" +
                    "/conversation" +
                    "/{userReceiveId}",
            "changepass","accept" +
                    "/{auctionId}", "chat/listMessages/{chatId}", "info",
            "updateLike/{auctionId}"));
    private final static ArrayList<String> auctionEndpoints = new ArrayList<>(Arrays.asList("listAuctionsByStatus/{statusId}", "listAuctionByUser", "listAuctions/{typeId}", "detail/{auctionId}", "create", "edit/{auctionId}"));
    private final static ArrayList<String> commentEndpoints = new ArrayList<>(Arrays.asList("create/{auctionId}", "{auctionId}", "delete/{commentId}"));
    private final static ArrayList<String> notificationEndpoints = new ArrayList<>(Arrays.asList("", "read/{auctionDenyId}"));
    private final static ArrayList<String> bidEndpoints = new ArrayList<>(Arrays.asList("create" + "/{auctionId}", "{auctionId}"));
    private final static ArrayList<String> newsEndpoints = new ArrayList<>(Arrays.asList("", "read/{newId}"));
    static final String BASE_URL = "https://auctions-app-2.herokuapp.com/api/";
    /** Cac thong tin chung de thuan tien cho viec test*/
    public static String USER_ID = "490";
    public static final HashMap<String, String> BASE_URL_LIST = new HashMap<>() {{
        put("0", "https://auctions-app-2.herokuapp.com/api/");
        put("1", "https://auctions-app-2.herokuapp.com/api/auctions/");
        put("2", "https://auctions-app-2.herokuapp.com/api/comments/");
        put("3", "https://auctions-app-2.herokuapp.com/api/notifications/");
        put("4", "https://auctions-app-2.herokuapp.com/api/bid/");
        put("5", "https://auctions-app-2.herokuapp.com/api/news/");
    }};

    public static HashMap<String, ArrayList<String>> ENDPOINT_LIST = new HashMap<>() {{
        put("0", baseEndpoints);
        put("1", auctionEndpoints);
        put("2", commentEndpoints);
        put("3", notificationEndpoints);
        put("4", bidEndpoints);
        put("5", newsEndpoints);
    }};
    public static final HashMap<String, ArrayList<String>> TEST_SUITES_LIST = new HashMap<>() {{
        put("LoginTest", new ArrayList<>(List.of("0.0")));
        put("SignupTest", new ArrayList<>(List.of("0.1")));
        put("SearchTest", new ArrayList<>(List.of("0.30")));
        put("EditAccountTest", new ArrayList<>(List.of("0.2")));
        put("GetCategoriesTest", new ArrayList<>(List.of("0.18")));
        put("GetListAuctionsByStatusTest", new ArrayList<>(List.of("0.5", "1.0")));
    }};
}
