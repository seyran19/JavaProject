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
        return so;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so)
    {
        System.out.println("CityRegisterIsRunning");
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }

    static AnswerWedding checkWedding(StudentOrder so)
    {
        System.out.println("Wedding check is running");
        AnswerWedding ans = new AnswerWedding();
        return ans;
    }

    static AnswerChildren checkChildren(StudentOrder so)
    {
        System.out.println("Children check is running");
        AnswerChildren ans = new AnswerChildren();
        return ans;
    }

    static AnswerStudent checkStudent(StudentOrder so)
    {
        System.out.println("Student check is running");
        AnswerStudent ans = new AnswerStudent();
        return ans;
    }

    static void sendMail(StudentOrder so)
    {

    }
}

