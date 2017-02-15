package Log_db;

import java.sql.*;
import java.util.*;
import Model.*;
import Database.Connections;

/**
 * Created by UX303L on 09.02.2017.
 */
public class Omissions_logic {

    private Connection connection;

    public Omissions_logic() {

        Connections connection = new Connections();
        connection.getConnection();
    }

    public  void checkOmissions (Omissions omission){
        try {
            PreparedStatement ps = connection.prepareStatement("select st_id from student_app_db.omissions where st_id=?");
            ps.setInt(1, omission.getSt_id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                //updateOmissions(omission);
            } else {
                //addOmissions(omission);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }


    }


