package persistence;

import data.PhoneNumber;

import java.util.List;

public interface ReadService {

    PhoneNumber getPhoneNumber(int id);

    List<PhoneNumber> getAllNumbers();

}
