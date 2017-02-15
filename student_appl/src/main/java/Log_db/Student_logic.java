package Log_db;
import java.sql.*;
import java.util.*;
import Model.*;
import Database.*;

public class Student_logic {

        private  Connection connection;

        public Student_logic() {
            connection = Connections.getConnection();
        }


        public void checkStudent(Student student) {
            try {
                PreparedStatement ps = connection.prepareStatement("select * from student_app_db.student where id_st name = ?");
                ps.setInt(1, student.getId_st());
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    updateStudent(student);
                } else {
                    addStudent(student);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void addStudent(Student student) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into student_app_db.student ( st_name, st_surname, st_ph_num, num_st_book, year ) values ( ?, ?, ?, ?, ? )");
                preparedStatement.setString(1, student.getSt_name());
                preparedStatement.setString(2, student.getSt_surname());
                preparedStatement.setString(3, student.getSt_ph_num());
                preparedStatement.setString(4, student.getNum_st_book());
                preparedStatement.setInt(5, student.getYear());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void deleteStudent(int id_st) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from student_app_db.student where id_st=?");
                preparedStatement.setInt(1, id_st);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateStudent(Student student) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("update student_app_db.student set  st_surname=?, st_ph_num=?, num_st_book=?, year=?, st_name=? where id_st=?");
                preparedStatement.setString(1, student.getSt_surname());
                preparedStatement.setString(2, student.getSt_ph_num());
                preparedStatement.setString(3, student.getNum_st_book());
                preparedStatement.setInt(4, student.getYear());
                preparedStatement.setString(5, student.getSt_name());
                preparedStatement.setInt(6, student.getId_st());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Student> getAllStudent() {
            List<Student> students = new ArrayList<Student>();
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from student_app_db.student");
                while (rs.next()) {
                    Student student = new Student();
                    student.setId_st(rs.getInt("id_st"));
                    student.setSt_name(rs.getString("st_name"));
                    student.setSt_surname(rs.getString("st_surname"));
                    student.setSt_ph_num(rs.getString("st_ph_num"));
                    student.setNum_st_book(rs.getString("num_st_book"));
                    student.setYear(rs.getInt("year"));
                    students.add(student);
                }
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return students;
        }

        public Student getStudentByStBook(String num_st_book) {
            Student student = new Student();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from student_app_db.student where num_st_book=?");
                preparedStatement.setString(1, num_st_book);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    student.setId_st(rs.getInt("id_st"));
                    student.setSt_name(rs.getString("st_name"));
                    student.setSt_surname(rs.getString("st_surname"));
                    student.setSt_ph_num(rs.getString("st_ph_num"));
                    student.setNum_st_book(rs.getString("num_st_book"));
                    student.setYear(rs.getInt("year"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return student;
        }

        public Student getStudentByid(int id_st) {
        Student student = new Student();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_app_db.student where id_st=?");
            preparedStatement.setInt(1, id_st);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                student.setId_st(rs.getInt("id_st"));
                student.setSt_name(rs.getString("st_name"));
                student.setSt_surname(rs.getString("st_surname"));
                student.setSt_ph_num(rs.getString("st_ph_num"));
                student.setNum_st_book(rs.getString("num_st_book"));
                student.setYear(rs.getInt("year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
    }

