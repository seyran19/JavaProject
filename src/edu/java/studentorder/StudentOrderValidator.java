package edu.java.studentorder;
import edu.java.studentorder.domain.*;
import edu.java.studentorder.mail.MailSender;
import edu.java.studentorder.validator.CheckChildrenValidator;
import edu.java.studentorder.validator.CheckStudentValidator;
import edu.java.studentorder.validator.CheckWeddingValidator;
import edu.java.studentorder.validator.CityRegisterValidator;

public class StudentOrderValidator
{
    public static void main(String[] args)
    {
        checkAll();
    }

    static void checkAll()
    {

        StudentOrder so = readStudentOrder();

        AnswerCityRegister cityAnswer =  checkCityRegister(so);
        AnswerWedding weddingAns = checkWedding(so);
        AnswerChildren childrenAns = checkChildren(so);
        AnswerStudent studentAns = checkStudent(so);
        sendMail(so);


    }


    static StudentOrder readStudentOrder()
    {
        StudentOrder so = new StudentOrder();
        return null;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so)
    {   CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "Host_1";
        AnswerCityRegister ans1 = crv1.checkCityRegister(so);

        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hostName = "Host_2";
        AnswerCityRegister ans2 = crv2.checkCityRegister(so);
        return ans1;
    }

    static AnswerWedding checkWedding(StudentOrder so)
    {  CheckWeddingValidator wd = new CheckWeddingValidator();
       return wd.checkWedding(so);
    }

    static AnswerChildren checkChildren(StudentOrder so)
    {
        CheckChildrenValidator ch = new CheckChildrenValidator();
        return ch.checkChildren(so);
    }

    static AnswerStudent checkStudent(StudentOrder so)
    {
        CheckStudentValidator st = new CheckStudentValidator();
        return st.checkStudent(so);
    }

    static void sendMail(StudentOrder so)
    {
        new MailSender().sendMail(so);
    }
}