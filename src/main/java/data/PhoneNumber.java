package data;

/**
 * Telefonnummer
 */
public class PhoneNumber {

    private final String original;
    private final String countryShort;
    private final String countryCode;
    private final String areaCode;
    private final String numberCode;
    private final String extensionCode;

    public PhoneNumber(String original, String countryShort, String countryCode, String areaCode, String numberCode, String extensionCode) {
        this.original = original;
        this.countryShort = countryShort;
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.numberCode = numberCode;
        this.extensionCode = extensionCode;
    }

    @Override
    public String toString() {
        return "PhoneNumber {countryShort = '" +this.countryShort+ "','countryCode='" + this.countryCode + "', areaCode='" + this.areaCode + "', numberCode='" + this.numberCode + "', extenstionCode='" + this.extensionCode + "'}";
    }

    public String getOriginal() {
        return original;
    }

    public String getCountryShort() {
        return countryShort;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public String getExtensionCode() {
        return extensionCode;
    }


}
