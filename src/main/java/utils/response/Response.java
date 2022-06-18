import java.util.ArrayList;

public class Response {
    public String code;
    public String message;
}

class ResponseDataAccount extends Response {
    public DataAccount data;
}

class ResponseDataAuction extends Response {
    public DataAuction data;
}

class ResponseSearchResult extends Response {
    public ArrayList<Product> data;
}

class ResponseWithAccessToken extends Response {
    public DataWithAccessToken data;
}