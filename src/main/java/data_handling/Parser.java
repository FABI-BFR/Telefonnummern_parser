package data_handling;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import data.PhoneNumber;

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

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber numberProto = phoneUtil.parse(input, "DE");
            countryCode = String.valueOf(numberProto.getCountryCode());
            String nationalSignificantNumber = phoneUtil.getNationalSignificantNumber(numberProto);
            int areaCodeLength = phoneUtil.getLengthOfGeographicalAreaCode(numberProto);

            if (areaCodeLength > 0) {
                areaCode = nationalSignificantNumber.substring(0, areaCodeLength);
                number = nationalSignificantNumber.substring(areaCodeLength);
            } else {
                number = nationalSignificantNumber;
            }

            extensionCode = numberProto.hasExtension() ? numberProto.getExtension() : "";
            countryShort = phoneUtil.getRegionCodeForNumber(numberProto);

        } catch (Exception e) {
            System.err.println("NumberParseException: " + e.toString());
        }
        return new PhoneNumber(original, countryShort, countryCode, areaCode, number, extensionCode);
    }

}
