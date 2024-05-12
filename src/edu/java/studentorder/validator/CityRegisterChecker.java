package edu.java.studentorder.validator;

import edu.java.studentorder.domain.CityRegisterCheckerResponse;
import edu.java.studentorder.domain.Person;

public interface CityRegisterChecker
{
    CityRegisterCheckerResponse checkPerson(Person person);
}
