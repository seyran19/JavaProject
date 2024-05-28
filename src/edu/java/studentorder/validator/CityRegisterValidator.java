package edu.java.studentorder.validator;

import edu.java.studentorder.domain.Person;
import edu.java.studentorder.domain.register.AnswerCityRegister;
import edu.java.studentorder.domain.Child;
import edu.java.studentorder.domain.register.AnswerCityRegisterItem;
import edu.java.studentorder.domain.register.CityRegisterResponse;
import edu.java.studentorder.domain.StudentOrder;
import edu.java.studentorder.exeption.CityRegisterException;
import edu.java.studentorder.validator.register.CityRegisterChecker;
import edu.java.studentorder.validator.register.FakeCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));

        for (Child c : so.getChildren()) {
            ans.addItem(checkPerson(c));
        }


        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        try {
            CityRegisterResponse childAns = personChecker.checkPerson(person);

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
