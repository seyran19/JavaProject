package edu.java.studentorder;
import edu.java.studentorder.domain.*;
import edu.java.studentorder.domain.children.AnswerChildren;
import edu.java.studentorder.domain.register.AnswerCityRegister;
import edu.java.studentorder.domain.student.AnswerStudent;
import edu.java.studentorder.domain.wedding.AnswerWedding;
import edu.java.studentorder.mail.MailSender;
import edu.java.studentorder.validator.CheckChildrenValidator;
import edu.java.studentorder.validator.CheckStudentValidator;
import edu.java.studentorder.validator.CheckWeddingValidator;
import edu.java.studentorder.validator.CityRegisterValidator;

import java.util.LinkedList;
import java.util.List;

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
        List<StudentOrder> soList = readStudentOrders();
        for (StudentOrder studentOrder : soList) {
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


    public List<StudentOrder> readStudentOrders()
    {
        List<StudentOrder> soList = new LinkedList<>();
        for(int i = 0; i < 5; i ++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }
        return soList;
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