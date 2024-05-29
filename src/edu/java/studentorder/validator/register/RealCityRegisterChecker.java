package edu.java.studentorder.validator.register;

import edu.java.studentorder.domain.register.CityRegisterResponse;
import edu.java.studentorder.domain.Person;
import edu.java.studentorder.exeption.CityRegisterException;
import edu.java.studentorder.exeption.TransportException;

public class RealCityRegisterChecker implements CityRegisterChecker
{
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException
    {
        return null;
    }
}
