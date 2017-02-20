import Database.Connections;
import Log_db.*;
import Model.Student;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class qwe {
    public static void main(String[] args) {
        Student_logic log = new Student_logic();
        Subject_logic log_sub = new Subject_logic();



        Student student = log.getStudentByid(3);
        System.out.println(student);

        System.out.println(log_sub.getAllSubjects());


    }
}