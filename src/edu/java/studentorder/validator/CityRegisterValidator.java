package edu.java.studentorder.validator;

import edu.java.studentorder.domain.AnswerCityRegister;
import edu.java.studentorder.domain.StudentOrder;

public class CityRegisterValidator
{
    public String hostName;
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so)
    {
        personChecker.checkPerson(so.getHusband());
        personChecker.checkPerson(so.getWife());
        personChecker.checkPerson(so.getChild());

        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
