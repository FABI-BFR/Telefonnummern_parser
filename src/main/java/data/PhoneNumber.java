package data;

/**
 * The Phonenumber class is responsible for the representation of the phonenumber as a datastructure.
 * <p>
 * @version 1.0
 * @author Fabian Unger
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

    /**
     * Prints the parts of the phonenumber
     *
     * @return phonenumber as string
     */
    @Override
    public String toString() {
        return "PhoneNumber {countryShort = '" + this.countryShort + "','countryCode='" + this.countryCode + "', areaCode='" + this.areaCode + "', numberCode='" + this.numberCode + "', extensionCode='" + this.extensionCode + "'}";
    }

    /**
     * Returns the phonenumber put in initially
     * @return original phonenumber
     */
    public String getOriginal() {
        return original;
    }

    /**
     * Returns the countryshort of a phonenumber
     * @return countryshort of a phonenumber
     */
    public String getCountryShort() {
        return countryShort;
    }

    /**
     * Returns the country code of a phonenumber
     * @return country code of a phonenumber
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Returns the area code of a phonenumber
     * @return area code of a phonenumber
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Returns the number of a phonenumber
     * @return number of a phonenumber
     */
    public String getNumberCode() {
        return numberCode;
    }

    /**
     * Returns the extension code of a phonenumber
     * @return extension code of a phonenumber
     */
    public String getExtensionCode() {
        return extensionCode;
    }


}
