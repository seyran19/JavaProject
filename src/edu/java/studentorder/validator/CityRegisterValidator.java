package edu.java.studentorder.validator;

import edu.java.studentorder.domain.AnswerCityRegister;
import edu.java.studentorder.domain.CityRegisterCheckerResponse;
import edu.java.studentorder.domain.StudentOrder;
import edu.java.studentorder.exeption.CityRegisterException;

public class CityRegisterValidator
{
    public String hostName;
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so)
    {   try
        {
        CityRegisterCheckerResponse hasAns = personChecker.checkPerson(so.getHusband());
        CityRegisterCheckerResponse wifeAns = personChecker.checkPerson(so.getWife());
        CityRegisterCheckerResponse childAns = personChecker.checkPerson(so.getChild());

        }
        catch (CityRegisterException ex)
        {
            ex.printStackTrace(System.out);
        }

        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
