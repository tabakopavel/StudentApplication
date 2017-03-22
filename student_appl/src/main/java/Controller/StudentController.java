package Controller;

import Log_db.*;
import Model.*;
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
    private static String MAIN = "/main.jsp";
    private Student_logic log = null;
    private Subject_logic log_sub = null;

    public StudentController() {
        super();
        log = new Student_logic();
        log_sub = new Subject_logic();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")) {
            int id_st = Integer.valueOf(request.getParameter("id_st"));
            log.deleteStudent(id_st);
            forward = MAIN;
            request.setAttribute("students", log.getAllStudent());
            request.setAttribute("subjects",log_sub.getAllSubjects());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id_st = Integer.valueOf(request.getParameter("id_st"));
            Student student = log.getStudentByid(id_st);
            request.setAttribute("student", student);
            request.setAttribute("subjects",log_sub.getAllSubjects());
        } else if (action.equalsIgnoreCase("listStudent")) {
            forward = MAIN;
            request.setAttribute("students", log.getAllStudent());
            request.setAttribute("subjects",log_sub.getAllSubjects());
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

        try {
            int id_st = Integer.parseInt(request.getParameter("id_st"));
            student.setId_st(id_st);
        } catch (NullPointerException e) {
        } finally {
            log.checkStudent(student);
            forward = MAIN;
            request.setAttribute("students", log.getAllStudent());
            request.setAttribute("subjects",log_sub.getAllSubjects());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }
}
