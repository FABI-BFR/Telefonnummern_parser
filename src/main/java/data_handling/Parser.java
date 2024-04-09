package data_handling;

import data.PhoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public PhoneNumber parseStringToPhonenumber(String input) {

        String original = input;

        String normalizedNumber = input.replaceAll("[^\\d+]", "");
        String regex = "^(\\+?\\d{1,2})?(\\d{3,4})?(\\d{6,7})(\\d{2,})?$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(normalizedNumber);

        String countryCode = "0049";
        String areaCode = "";
        String number = "";
        String extensionCode = "";

        if(matcher.find()) {
            countryCode = matcher.group(1);
            areaCode = matcher.group(2);
            number = matcher.group(3);
            extensionCode = matcher.group(4);
        }

        PhoneNumber phoneNumber = new PhoneNumber(original, countryCode, areaCode, number, extensionCode);
        return phoneNumber;
    }

}
