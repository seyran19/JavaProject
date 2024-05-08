package edu.java.studentorder.validator;

import edu.java.studentorder.domain.AnswerCityRegister;
import edu.java.studentorder.domain.StudentOrder;

public class CityRegisterValidator
{
    public String hostName;
    public AnswerCityRegister checkCityRegister(StudentOrder so)
    {
        System.out.println("CityRegisterIsRunning: " + hostName);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
