package Log_db;

import Database.Connections;
import Model.Group;
import Model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class User_logic {

    private Connection connection;

    public User_logic() {

        connection = Connections.getConnection();
    }

    public int checkUser(User user) {
        int exist = 0;
        User user1 = new User();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_app_db.users WHERE user = ?");
            ps.setString(1, user.getUser());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                user1.setUser(rs.getString("user"));
                user1.setPassword(rs.getString("password"));
            }

            if (user1.equals(user)) {
                exist = 1;
            } else {
                exist = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public User getUserByName(String username) {
        User user2 = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_app_db.users WHERE user = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user2 = new User();
                user2.setId_user(rs.getInt("id"));
                user2.setUser(rs.getString("user"));
                user2.setPassword(rs.getString("password"));
                user2.setEmail(rs.getString("email"));
                user2.setActivation(rs.getInt("activation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user2;
    }

    public int checkUserByName(String username) {
        int exist = 0;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_app_db.users WHERE user = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                exist = 1;
            } else {
                exist = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public int getUserId(User user) {
        int id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_app_db.users WHERE user = ?");
            ps.setString(1, user.getUser());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void addUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO student_app_db.users( user, password, email, activation) VALUES ( ?, ?, ?, ? )");
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            if (user.getActivation() == 0 || user.getActivation() == 1) {
                ps.setInt(4, user.getActivation());
            } else {
                ps.setInt(4, 0);
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student_app_db.users WHERE user=?");
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateUser(User user) {
        int id = getUserId(user);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE student_app_db.users SET user=?, password=?, email=? , activation = ? WHERE id=?");
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getActivation());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeToken(User user, String token) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE student_app_db.users SET user_token= ? WHERE user=?");
            ps.setString(1, token);
            ps.setString(2, user.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteToken(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE student_app_db.users SET user_token= ? WHERE user=?");
            ps.setString(1, "");
            ps.setString(2, user.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTokenByName(String username) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE student_app_db.users SET user_token= ? WHERE user=?");
            ps.setString(1, "");
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkToken(User user, String token) {
        boolean exist = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT user_token FROM student_app_db.users WHERE user=?");
            ps.setString(1, user.getUser());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String check_token = rs.getString("user_token");
                if (check_token.equals(token)) {
                    exist = true;
                } else {
                    exist = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public boolean checkTokenByName(String username, String token) {
        boolean exist = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT user_token FROM student_app_db.users WHERE user=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String check_token = rs.getString("user_token");
                if (check_token.equals(token)) {
                    exist = true;
                } else {
                    exist = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM student_app_db.users ");
            while (rs.next()) {
                User user = new User();
                user.setId_user(rs.getInt("id"));
                user.setUser(rs.getString("user"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setActivation(rs.getInt("activation"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
