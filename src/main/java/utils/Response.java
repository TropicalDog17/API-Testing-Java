import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Response {
    public String code;
    public String message;
}

class ResponseSearchResult extends Response {
    public ArrayList<Product> data;
}

class ResponseWithAccessToken extends Response {
    public DataWithAccessToken data;
}

class ResponseDataAuction extends Response {
    public DataAuction data;
}

class ResponseDataAccount extends Response {
    public DataAccount data;
}

class DataAccount {
    public String name;
    public String email;
    public String phone;
    public String address;
    public String avatar;
    public String role;

}

class DataWithAccessToken {
    public String access_token;
}

class Product {
    public String id;
    public String name;
    public String key;
}

class DataAuction {
    public ArrayList<Auction> auctions;
    public String total;
}

class Auction {
    public String auction_id;
    public String selling_user_id;
    public String title;
    public String start_date;
    public String end_date;
    public String statusId;
    public String status;
    public Category category;
}

class Category {
    public String categoryId;
    public String name;
    public String image;
    public String type;
}