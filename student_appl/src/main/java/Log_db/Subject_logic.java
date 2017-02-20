package Log_db;

import Database.Connections;
import Model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Subject_logic {
    private Connection connection;

    public Subject_logic() {
        connection = Connections.getConnection();
    }

    public void checkSubject(Subject subject){
        try {
            PreparedStatement ps = connection.prepareStatement("select * from student_app_db.subjects where id_sub=?");
            ps.setInt(1, subject.getId_sub());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                updateSubject(subject);
            } else {
                addSubject(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addSubject(Subject subject) {
        try {
            PreparedStatement preparedstatement = connection.prepareStatement("insert into student_app_db.subjects (  sub_name, sub_tutor ) values ( ?, ?)");
            preparedstatement.setString(1, subject.getSub_name());
            preparedstatement.setString(2, subject.getSub_tutor());
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubject(Subject subject){
        try{
            PreparedStatement preparedstatement = connection.prepareStatement("update student_app_db.subjects set sub_name=?, sub_tutor=? where id_sub=?");
            preparedstatement.setString(1, subject.getSub_name());
            preparedstatement.setString(2, subject.getSub_tutor());
            preparedstatement.setInt(3,subject.getId_sub());
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteSubject(int id_sub){

        try {
            PreparedStatement preparedstatement = connection.prepareStatement("DELETE FROM student_app_db.subjects where id_sub=? ");
            preparedstatement.setInt(1,id_sub);
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Subject> getAllSubjects() {
        List <Subject> subjects = new ArrayList<Subject>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from student_app_db.subjects");
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId_sub(rs.getInt("id_sub"));
                subject.setSub_name(rs.getString("sub_name"));
                subject.setSub_tutor(rs.getString("sub_tutor"));
                subjects.add(subject);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }


}
