package edu.java.studentorder.validator;

import edu.java.studentorder.domain.CityRegisterCheckerResponse;
import edu.java.studentorder.domain.Person;
import edu.java.studentorder.exeption.CityRegisterException;

public interface CityRegisterChecker
{
    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException;
}
