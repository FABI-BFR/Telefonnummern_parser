package data_handling;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import data.PhoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Parser class is responsible for the parsing of a phonenumber.
 * <p>
 *
 * @author Fabian Eilber
 * @version 1.0
 */

public class Parser {

    public PhoneNumber parseStringToPhoneNumberEx(String input) {

        String original = input;
        String countryCode = "0049";
        String areaCode = "";
        String number = "";
        String extensionCode = "";
        String countryShort = "";

        extensionCode = getExtension(input) == null ? "": getExtension(input);
        input =  removeExtension(input);

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber numberProto = phoneUtil.parseAndKeepRawInput(input, "DE");
            countryCode = String.valueOf(numberProto.getCountryCode());
            String nationalSignificantNumber = phoneUtil.getNationalSignificantNumber(numberProto);
            int areaCodeLength = phoneUtil.getLengthOfGeographicalAreaCode(numberProto);

            if (areaCodeLength > 0) {
                areaCode = nationalSignificantNumber.substring(0, areaCodeLength);
                number = nationalSignificantNumber.substring(areaCodeLength);
            } else {
                number = nationalSignificantNumber;
            }

            //extensionCode = numberProto.hasExtension() ? numberProto.getExtension() : "";
            countryShort = phoneUtil.getRegionCodeForNumber(numberProto);

        } catch (Exception e) {
            System.err.println("NumberParseException: " + e.toString());
        }
        return new PhoneNumber(original, countryShort, countryCode, areaCode, number, extensionCode);
    }


    public String getExtension (String input) {
        Pattern pattern = Pattern.compile("-\\d{1,3}");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String extension = matcher.group();
            extension.replace("-","");
            if(extension.length()<=3) {
                return extension;
            }else {
                return "";
            }
        } else {
            return null;
        }
    }

    public String removeExtension (String input) {
        String pattern = "-\\d{1,3}";
        String cleanedPhoneNumber = input.replaceAll(pattern, "");
        return cleanedPhoneNumber;
    }
}
