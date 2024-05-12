package edu.java.studentorder;

import edu.java.studentorder.domain.StudentOrder;

public class SaveStudentOrder
{
    public static void main(String[] args) // psvm
    {

    }

    static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        return so;
    }


}