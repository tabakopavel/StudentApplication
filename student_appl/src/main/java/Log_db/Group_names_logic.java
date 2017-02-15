package Log_db;

import java.sql.*;
import java.util.*;
import Model.*;
import Database.Connections;

/**
 * Created by UX303L on 09.02.2017.
 */
public class Group_names_logic {

    private Connection connection;

    public Group_names_logic() {

        Connections connection = new Connections();
        connection.getConnection();
    }

    public void checkGroup_names(Group_names group_name) {
        try {
            PreparedStatement ps = connection.prepareStatement("select group_name from student_app_db.group_names where group_name=?");
            ps.setString(1, group_name.getGroup_name());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateGroup_names(group_name);
            } else {
                addGroup_names(group_name);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }

    public void addGroup_names(Group_names group_name){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student_app_db.group_names ( id_group_name, num_group, group_name) values ( ?, ?, ? )");
            preparedStatement.setInt(1,group_name.getId_group_name());
            preparedStatement.setInt(2,group_name.getNum_group());
            preparedStatement.setString(3,group_name.getGroup_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGroup(int num_group){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student_app_db.group_names where num_group=?");
            preparedStatement.setInt(1,num_group);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateGroup_names(Group_names group_name){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update student_app_db.group_names set id_group_name=?, group_name=? where num_group=?");
            preparedStatement.setInt(1,group_name.getId_group_name());
            preparedStatement.setString(2, group_name.getGroup_name());
            preparedStatement.setInt(3,group_name.getNum_group());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group_names> getAllGroup_names() {
        List<Group_names> group_names = new ArrayList<Group_names>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student_app_db.group_names ");
            while (rs.next()){
                Group_names group_name = new Group_names();
                group_name.setId_group_name(rs.getInt("id_group_name"));
                group_name.setNum_group(rs.getInt("num_group"));
                group_name.setId_group_name(rs.getInt("group_name"));
                group_names.add(group_name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group_names;
    }

    public Group_names getGroup_namesByNum(int num_group){
        Group_names group_name = new Group_names();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_app_db.group_names where num_group=?");
            preparedStatement.setInt(1,num_group);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                group_name.setId_group_name(rs.getInt("id_group_name"));
                group_name.setNum_group(rs.getInt("num_group"));
                group_name.setId_group_name(rs.getInt("group_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group_name;
    }

}

