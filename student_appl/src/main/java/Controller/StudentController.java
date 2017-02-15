package Controller;

import Log_db.Student_logic;
import Model.Student;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/student.jsp";
    private static String LIST_USER = "/listStudent.jsp";
    private Student_logic log = null;

    public StudentController() {
        super();
        log = new Student_logic();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")) {
            int id_st = Integer.valueOf(request.getParameter("id_st"));
            log.deleteStudent(id_st);
            forward = LIST_USER;
            request.setAttribute("students", log.getAllStudent());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id_st = Integer.valueOf(request.getParameter("id_st"));
            Student student = log.getStudentByid(id_st);
            request.setAttribute("student", student);
        } else if (action.equalsIgnoreCase("listStudent")) {
            forward = LIST_USER;
            request.setAttribute("students", log.getAllStudent());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        String forward = "";
        student.setSt_name(request.getParameter("st_name"));
        student.setSt_surname(request.getParameter("st_surname"));
        student.setSt_ph_num(request.getParameter("st_ph_num"));
        student.setNum_st_book(request.getParameter("num_st_book"));
        student.setYear(Integer.parseInt(request.getParameter("year")));
        int id_st = 0;
        try {
            id_st = Integer.parseInt(request.getParameter("id_st"));
        } catch (NullPointerException e) {
        } finally {
            if (id_st > 0) {
                student.setId_st(id_st);
                log.checkStudent(student);
            } else {
                log.addStudent(student);
            }

            forward = LIST_USER;
            request.setAttribute("students", log.getAllStudent());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }
}