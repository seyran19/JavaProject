package edu.java.studentorder;
import edu.java.studentorder.domain.*;
import edu.java.studentorder.mail.MailSender;
import edu.java.studentorder.validator.CheckChildrenValidator;
import edu.java.studentorder.validator.CheckStudentValidator;
import edu.java.studentorder.validator.CheckWeddingValidator;
import edu.java.studentorder.validator.CityRegisterValidator;

public class StudentOrderValidator
{
    private CheckChildrenValidator childrenVal;
    private CheckStudentValidator studentVal;
    private CheckWeddingValidator weddingVal;
    private CityRegisterValidator cityVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        childrenVal = new CheckChildrenValidator();
        studentVal = new CheckStudentValidator();
        weddingVal = new CheckWeddingValidator();
        cityVal = new CityRegisterValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args)
    {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll()
    {
        StudentOrder[] so = readStudentOrders();
        for (StudentOrder studentOrder : so) {
            checkOneOrder(studentOrder);
            System.out.println();
        }
    }

    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister cityAnswer = checkCityRegister(so);
        //AnswerStudent studentAnswer = checkStudent(so);
        //AnswerChildren checkChild = checkChildren(so);
        //AnswerWedding checkWedding = checkWedding(so);
        //sendMail(so);
    }


    public StudentOrder[] readStudentOrders()
    {
        StudentOrder[] soArray = new StudentOrder[3];
        for(int i = 0; i < soArray.length; i ++) {
            soArray[i] = SaveStudentOrder.buildStudentOrder(i);
        }
        return soArray;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so)
    {
        return cityVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so)
    {
       return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so)
    {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so)
    {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so)
    {
        mailSender.sendMail(so);
    }
}