package edu.java.studentorder.validator;

import edu.java.studentorder.domain.Person;
import edu.java.studentorder.domain.register.AnswerCityRegister;
import edu.java.studentorder.domain.Child;
import edu.java.studentorder.domain.register.AnswerCityRegisterItem;
import edu.java.studentorder.domain.register.CityRegisterResponse;
import edu.java.studentorder.domain.StudentOrder;
import edu.java.studentorder.exeption.CityRegisterException;
import edu.java.studentorder.exeption.TransportException;
import edu.java.studentorder.validator.register.CityRegisterChecker;
import edu.java.studentorder.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    public static final String IN_CODE = "NO_GRN";

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

        AnswerCityRegisterItem.CityStatus status;
        AnswerCityRegisterItem.CityError error = null;

        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ? AnswerCityRegisterItem.CityStatus.YES : AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());

        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());


        }

        return new AnswerCityRegisterItem(person, status, error);
    }
}
