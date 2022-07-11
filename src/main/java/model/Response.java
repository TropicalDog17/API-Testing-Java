import java.util.ArrayList;

public class Response {
    public String code;
    public String message;
}

class ResponseDataAccount extends Response {
    public DataUser data;
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

class ResponseNews extends Response {
    public DataNews data;
}

class ResponseReadNews extends Response {
    public DataReadNews data;
}

class ResponseAcceptMaxBid extends Response {
    public DataAcceptMaxBid data;
}

class ResponseCreateAuction extends Response {
    public DataCreateAuction data;
}