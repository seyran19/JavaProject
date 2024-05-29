package edu.java.studentorder.validator.register;

import edu.java.studentorder.domain.Adult;
import edu.java.studentorder.domain.Child;
import edu.java.studentorder.domain.register.CityRegisterResponse;
import edu.java.studentorder.domain.Person;
import edu.java.studentorder.exeption.CityRegisterException;
import edu.java.studentorder.exeption.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker
{
    private static final String GOOD_1 = "1000"; //psfs
    private static final String GOOD_2 = "2000";

    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";

    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";

    private static final String ERROR_T_1 = "1003";
    private static final String ERROR_T_2 = "2003";


    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException
    {
        CityRegisterResponse res = new CityRegisterResponse();
        if (person instanceof Adult){

            Adult t = (Adult) person;

            if (t.getPassportSeria().equals(GOOD_1) || t.getPassportSeria().equals(GOOD_2)) {
                res.setExisting(true);
                res.setTemporal(false);
            }

            if (t.getPassportSeria().equals(BAD_1) || t.getPassportSeria().equals(BAD_2)) {
                res.setExisting(false);
            }

            if (t.getPassportSeria().equals(ERROR_1) || t.getPassportSeria().equals(ERROR_2)) {
                CityRegisterException ex = new CityRegisterException("1", "GRN Error " + t.getPassportSeria());
                throw ex;
            }

            if (t.getPassportSeria().equals(ERROR_T_1) || t.getPassportSeria().equals(ERROR_T_2)) {
                TransportException ex = new TransportException( "Transport Error" + t.getPassportSeria());
                throw ex;
            }

        }

        if (person instanceof Child) {
            res.setExisting(true);
            res.setTemporal(true);
        }
        System.out.println(res);
        return res;
    }
}
