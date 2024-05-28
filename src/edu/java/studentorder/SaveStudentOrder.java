package edu.java.studentorder;

import edu.java.studentorder.domain.Address;
import edu.java.studentorder.domain.Adult;
import edu.java.studentorder.domain.Child;
import edu.java.studentorder.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) // psvm
    {

    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice("Отдел ЗАГС");

        Address address = new Address("195000", "Заневский пр", "12", "", "142");

        //Husband
        Adult husband = new Adult(
                "Петров",
                LocalDate.of(1998, 11, 12),
                "Сергеевич", "Виктор"
        );
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Отдел милиции № " + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);

        //wife
        Adult wife = new Adult(
                "Петрова",
                LocalDate.of(1998, 7, 6),
                "Александровна", "Вероника"
        );
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Отдел милиции № " + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        //child
        Child child1 = new Child(
                "Петрова",
                LocalDate.of(2018, 7, 19),
                "Александровна", "Ирина"
        );
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018,7,19));
        child1.setIssueDepartment("Отдел ЗАГС № " + id);
        child1.setAddress(address);

        //child
        Child child2 = new Child(
                "Петров",
                LocalDate.of(2018, 7, 19),
                "Александрович", "Chuck"
        );
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        child2.setIssueDepartment("Отдел ЗАГС № " + id);
        child2.setAddress(address);


        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }


}