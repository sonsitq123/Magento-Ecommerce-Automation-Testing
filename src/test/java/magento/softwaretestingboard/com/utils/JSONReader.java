package magento.softwaretestingboard.com.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    public static String existingAccount(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/resources/TestData/ExistingAccount.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingAccount = (JSONObject) obj;
        return (String) existingAccount.get(data);
    }

    public static String personalInformation(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/resources/TestData/PersonalInformation.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingAccount = (JSONObject) obj;
        return (String) existingAccount.get(data);
    }
}