package data;

/**
 * Telefonnummer
 */
public class PhoneNumber {

    private final CountryCode countryCode;
    private final AreaCode areaCode;
    private final NumberCode numberCode;
    private final ExtensionCode extensionCode;

    public PhoneNumber(CountryCode countryCode, AreaCode areaCode, NumberCode numberCode, ExtensionCode extensionCode) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.numberCode = numberCode;
        this.extensionCode = extensionCode;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public AreaCode getAreaCode() {
        return areaCode;
    }

    public NumberCode getNumberCode() {
        return numberCode;
    }

    public ExtensionCode getExtensionCode() {
        return extensionCode;
    }
}
