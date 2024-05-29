package edu.java.studentorder.validator.register;

import edu.java.studentorder.domain.register.CityRegisterResponse;
import edu.java.studentorder.domain.Person;
import edu.java.studentorder.exeption.CityRegisterException;
import edu.java.studentorder.exeption.TransportException;

public interface CityRegisterChecker
{
    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException;
}
