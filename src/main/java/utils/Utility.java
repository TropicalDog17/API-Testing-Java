import kong.unirest.Unirest;
import org.apache.commons.lang3.math.NumberUtils;
import org.jetbrains.annotations.NotNull;


import java.util.*;

public class Utility {


    public static String getAccessTokenForTest(String email, String password) {
        //Login successfully first
        ResponseWithAccessToken res = Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", email)
                .field("password", password)
                .asObject(ResponseWithAccessToken.class)//ObjectMapper
                .getBody();
        //If successfully login, return access token for use
        if (res.code.equals("1000")) {
            return res.data.access_token;
        }
        return "Wrong user info";
    }

    //Get default access token
    public static String getAccessTokenForTest() {
        return getAccessTokenForTest("oop123456@gmail.com", "123456");
    }

    public static String chooseBaseUrl() {
        Scanner sc = new Scanner(System.in);
        String baseUrl;
        String baseUrlID;
        displayMenu();
        baseUrlID = sc.nextLine()
                .trim();
        if (baseUrlID.isEmpty()) {
            System.out.println("Base URL is: https://auctions-app-2.herokuapp.com/api/");
            return "0";
        }
        while (!Constant.BASE_URL_LIST.containsKey(baseUrlID)) { //Users enter wrong option
            System.out.println("Wrong options");
            displayMenu();
            baseUrlID = sc.nextLine()
                    .trim();
            if (baseUrlID.isEmpty()) {
                System.out.println("Base URL is: https://auctions-app-2.herokuapp.com/api/");
                return "0";
            }
        }
        baseUrl = Constant.BASE_URL_LIST.get(baseUrlID);
        System.out.println("Base URL is: " + baseUrl);


        return baseUrlID;
    }

    private static ArrayList<Integer> getImplementedOptions(String baseUrlId) {
        ArrayList<Integer> implementedOptionsList = new ArrayList<>();
        for (ArrayList<String> list : Constant.TEST_SUITES_LIST.values()) {
            for (String element : list) {
                if (element.startsWith(baseUrlId)) {
                    implementedOptionsList.add(Integer.parseInt(element.substring(2)));
                }
            }
        }
        Collections.sort(implementedOptionsList);
        return implementedOptionsList;
    }

    public static String chooseAPIEndPoint(String baseUrlId) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> endPointList = Constant.ENDPOINT_LIST.get(baseUrlId);
        ArrayList<Integer> implementedOptionsList = getImplementedOptions(baseUrlId);
        displayAPIOption(endPointList, implementedOptionsList);
        String endPointId = sc.nextLine()
                .trim();
        if(endPointId.isEmpty()){
            displayAPIOption(endPointList, implementedOptionsList);
            System.out.println("Please enter an option: ");
        }
        //If user inputs unexpected options, display the menu and ask for user input again
        while(!implementedOptionsList.contains(NumberUtils.toInt(endPointId, -1))){
            if(endPointId.isEmpty()){
                displayAPIOption(endPointList, implementedOptionsList);
                System.out.println("Please enter an option: ");
            }
            else{
                displayAPIOption(endPointList, implementedOptionsList);
                System.out.println("Option not implemented! Please choose another one: ");
            }
            endPointId = sc.nextLine().trim();

        }
        System.out.println(baseUrlId + "." + endPointId);
        return baseUrlId + "." + endPointId;
    }
    // Register a new account with fixed password and random email
    /**
     * @return AbstractMap.SimpleEntry<String, String>
     */
    public static AbstractMap.SimpleEntry<String, String> RandomSignup() {
        String randomEmail = getRandomEmail(20);
        Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", randomEmail)
                .field("password", "123456")
                .field("re_pass", "123456")
                .field("address", "")
                .field("name", "Tuan Tran")
                .field("phone", "034209874")
                .field("avatar", "")
                .asObject(Response.class)
                .getBody();
        //Return credential for further use
        return new AbstractMap.SimpleEntry<>(randomEmail, "123456");
    }

        public static Response doLogin(String email, String password) {
            return Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                    .field("email", email)
                    .field("password", password)
                    .asObject(Response.class)
                    .getBody();
        }
        /** length should be equal or greater than 9*/
        public static String getRandomEmail(int length) { //length: So ki tu bao gom ca @gmail.com
            if (length < 9) return "@gmail.com";
            String generatedString = getRandomString(length - 9);

            return generatedString.concat("@gmail.com");
        }

        public static String getRandomString(int length) {
            // create a string of uppercase and lowercase characters and numbers
            String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            // combine all strings
            String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
            // create random string builder
            StringBuilder sb = new StringBuilder();
            // create an object of Random class
            Random random = new Random();
            // specify length of random string
            for (int i = 0; i < length; i++) {

                // generate random index number
                int index = random.nextInt(alphaNumeric.length());

                // get character specified by index
                // from the string
                char randomChar = alphaNumeric.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }
            return sb.toString();
        }
    public static String getRandomPhone(int length) {
        // create a string of uppercase and lowercase characters and numbers

        String numbers = "0123456789";
        // combine all strings
        String alphaNumeric = numbers;
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        return sb.toString();
    }

        private static void displayMenu() {
            System.out.println("==============MENU==============");
            System.out.println("Choose base URL(0/1/2/3/4/Enter): ");

            System.out.println("Enter(0): https://auctions-app-2.herokuapp.com/api/");
            System.out.println("1: https://auctions-app-2.herokuapp.com/api/auctions/");
            System.out.println("2: https://auctions-app-2.herokuapp.com/api/comments/");
            System.out.println("3: https://auctions-app-2.herokuapp.com/api/notifications/");
            System.out.println("4: https://auctions-app-2.herokuapp.com/api/bid/");
            System.out.println("5: https://auctions-app-2.herokuapp.com/api/news/");
        }
        private static void displayAPIOption(@NotNull ArrayList<String> endPointList,
                                             ArrayList<Integer> implementedOptionsList){
            System.out.println("Choose an endpoint" + "(0-" + endPointList.size() + ")");
            System.out.println("Implemented option: " + implementedOptionsList);
            int index = 0;
            for (String endPoint : endPointList) System.out.println(index++ + ":/" + endPoint);
        }
    }
