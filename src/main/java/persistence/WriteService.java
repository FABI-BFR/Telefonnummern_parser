package persistence;

import data.PhoneNumber;

public interface WriteService {

    void setPhoneNumber(int id, PhoneNumber number);
}
