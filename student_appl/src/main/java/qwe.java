import Database.Connections;
import Log_db.*;
import Model.Student;
import Model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class qwe {
    public static void main(String[] args) {
        Student_logic log = new Student_logic();
        Subject_logic log_sub = new Subject_logic();
        User_logic user_log = new User_logic();

       user_log.checkTokenByName("admin","B1902A99344F08EEE124EC540B451399");
       System.out.println(user_log.checkTokenByName("admin","B1902A99344F08EEE124EC540B451399"));
       if (user_log.checkTokenByName("admin","B1902A99344F08EEE124EC540B451399")!=true){
           System.out.println("false");
       }
//user_log.deleteUser("admin");
    }
}