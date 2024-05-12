package edu.java.studentorder.validator;

import edu.java.studentorder.domain.CityRegisterCheckerResponse;
import edu.java.studentorder.domain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker
{
    public CityRegisterCheckerResponse checkPerson(Person person) {
        return null;
    }
}
