package data_handling;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
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

        return new PhoneNumber(original, "", countryCode, areaCode, number, extensionCode);
    }

    public PhoneNumber parseStringToPhoneNumberEx(String input) {

        String original = input;
        String countryCode = "0049";
        String areaCode = "";
        String number = "";
        String extensionCode = "";
        String countryShort = "";

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber numberProto = phoneUtil.parse(input, "");
            countryCode = String.valueOf(numberProto.getCountryCode());
            areaCode = phoneUtil.getNationalSignificantNumber(numberProto);
            number = String.valueOf(numberProto.getNationalNumber());
            extensionCode = String.valueOf(numberProto.getExtension());

            String country = phoneUtil.getRegionCodeForNumber(numberProto);
            countryShort = country;

        } catch (Exception e) {

            System.err.println("NumberParseException: " + e.toString());
        }
        return new PhoneNumber(original, countryShort, countryCode, areaCode, number, extensionCode);
    }

}
