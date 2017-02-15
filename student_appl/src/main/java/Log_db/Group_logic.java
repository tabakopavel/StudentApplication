package Log_db;


import java.sql.*;
import java.util.*;
import Model.*;
import Database.Connections;
/**
 * Created by UX303L on 09.02.2017.
 */
public class Group_logic {

    private  Connection connection;

    public Group_logic() {

        connection = Connections.getConnection();
    }

    public  void checkGroup (Group group){
        try {
            PreparedStatement ps = connection.prepareStatement("select num_group from student_app_db.groups where num_group = ?");
            ps.setInt(1, group.getNum_group());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateGroup(group);
            } else {
                addGroup(group);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }

    public void addGroup(Group group){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student_app_db.groups ( id_group, num_group, st_id) values ( ?, ?, ? )");
            preparedStatement.setInt(1,group.getId_group());
            preparedStatement.setInt(2,group.getNum_group());
            preparedStatement.setInt(3,group.getSt_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGroup(int num_group){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student_app_db.groups where num_group=?");
            preparedStatement.setInt(1,num_group);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateGroup(Group group){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update student_app_db.groups set id_group=?, st_id=? where num_group=?");
            preparedStatement.setInt(1,group.getId_group());
            preparedStatement.setInt(2,group.getSt_id());
            preparedStatement.setInt(3,group.getNum_group());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> getAllGroup() {
        List<Group> groups = new ArrayList<Group>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student_app_db.groups ");
            while (rs.next()){
                Group group = new Group();
                group.setId_group(rs.getInt("id_group"));
                group.setNum_group(rs.getInt("num_group"));
                group.setSt_id(rs.getInt("st_id"));
                groups.add(group);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public Group getGroupByNum(int num_group){
        Group group = new Group();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_app_db.groups where num_group=?");
            preparedStatement.setInt(1,num_group);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                group.setId_group(rs.getInt("id_group"));
                group.setNum_group(rs.getInt("num_group"));
                group.setSt_id(rs.getInt("st_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

}
