import Database.Connections;
import Log_db.*;
import Model.Student;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class qwe {
    public static void main(String[] args) {

        Student_logic tyu = new Student_logic();

        Student student = tyu.getStudentByid(3);
        System.out.println(student);

        int id_st;


    }
}