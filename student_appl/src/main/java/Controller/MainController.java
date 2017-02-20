package Controller;

import Log_db.Student_logic;
import Log_db.Subject_logic;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/MainController")
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String MAIN = "/main.jsp";
    private Student_logic log = null;
    private Subject_logic log_sub = null;

    public MainController() {
        super();
        log = new Student_logic();
        log_sub = new Subject_logic();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("main")) {
            forward = MAIN;
            request.setAttribute("students", log.getAllStudent());
            request.setAttribute("subjects", log_sub.getAllSubjects());
        } else {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
