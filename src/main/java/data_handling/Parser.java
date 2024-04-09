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

    /**
     * Extracting parts of the given phonenumber
     *
     * @param input phone number as string
     * @return PhoneNumber Object containing each part of the phonenumber
     */
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

    /**
     * Extracts the extension of the phonenumber
     *
     * @param input phone number as string
     * @return extension or empty string depending on whether or not there is a extension
     */
    public String getExtension (String input) {
        Pattern pattern = Pattern.compile("-\\d{1,3}");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String extension = matcher.group();
            String ret = extension.replace("-","");
            if(ret.length()<=2) {
                return ret;
            }else {
                return "";
            }
        } else {
            return null;
        }
    }

    /**
     * Removes the extension part from the phonenumber
     *
     * @param input phone number as string
     * @return cleared phonenumber
     */
    public String removeExtension (String input) {
        String pattern = "-\\d{1,3}";
        String cleanedPhoneNumber = input.replaceAll(pattern, "");
        return cleanedPhoneNumber;
    }
}
