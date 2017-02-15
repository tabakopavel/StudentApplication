import Database.Connections;
import Log_db.*;
import Model.Student;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class qwe
{
    public static void main(String[] args) {

        Student_logic tyu = new Student_logic();

Student student = tyu.getStudentByid(3);
        System.out.println(student);


/*
        Connections qwe = new Connections();
                qwe.getConnection();

        if (qwe==null){System.out.print("null");}

        List qweq = new ArrayList();
        qweq.add(1);
        qweq.add(2);

        List qwer = new ArrayList();
        qwer.addAll(qweq);
        for (Object x:qwer){
            System.out.println(x);
        }

        qweq.clear();

        for (Object x:qwer){
            System.out.println(x);
        }

        Student rew = new Student();
        rew.setYear(1234);
        rew.setNum_st_book("qwe");
        rew.setSt_ph_num("qwe");
        //rew.setId_st(123);
        rew.setSt_surname("qwe");
        rew.setSt_name("qwe1");

       // System.out.println(rew);

        Student_logic tr = new Student_logic();
List qw= new ArrayList<Student>();
qw = tr.getAllStudent();
        tr.addStudent(rew);

            tr.checkStudent(rew);
System.out.print(qw);
*/
    }
}
