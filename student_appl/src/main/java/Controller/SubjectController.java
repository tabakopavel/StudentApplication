package Controller;
import Log_db.Student_logic;
import Log_db.Subject_logic;
import Model.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Student_logic log = null;
    private Subject_logic log_sub = null;
    private static String MAIN = "/main.jsp";
    private static String LIST_Subject = "/listSubject.jsp";


    public SubjectController() {
        super();
        log = new Student_logic();
        log_sub = new Subject_logic();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id_sub = Integer.valueOf(request.getParameter("id_sub"));
            log_sub.deleteSubject(id_sub);
            forward = MAIN;
            request.setAttribute("students", log.getAllStudent());
            request.setAttribute("subjects",log_sub.getAllSubjects());
        } else {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Subject subject = new Subject();
        String forward = "";

        subject.setSub_name(request.getParameter("id_name"));
        subject.setSub_tutor(request.getParameter("sub_tutor"));

        try {
            int id_sub = Integer.parseInt(request.getParameter("id_sub"));
            subject.setId_sub(id_sub);
        } catch (NumberFormatException e ) {
        } finally {
            log_sub.checkSubject(subject);
            forward = MAIN;
            request.setAttribute("students", log.getAllStudent());
            request.setAttribute("subjects",log_sub.getAllSubjects());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }
}