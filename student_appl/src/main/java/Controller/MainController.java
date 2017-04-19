package Controller;

import Log_db.Student_logic;
import Log_db.Subject_logic;
import Log_db.User_logic;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/MainController")
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private User_logic user_logic = null;
    private Student_logic log_stu = null;
    private Subject_logic log_sub = null;
    private static String MAIN = "/main.jsp";
    private static String REG_FORM = "/reg_form.html";
    private static String REG_FORMA = "/reg_forma.html";
    private final String log_admin = "admin";
    private final String pass_admin = "admin";
    private final String USER_PAGE = "/user_page.jsp";
    private final String UserController = "/UserController";
    private final String MainController = "/MainController";

    public MainController() {
        user_logic = new User_logic();
        log_stu = new Student_logic();
        log_sub = new Subject_logic();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = null;
        User user = new User();
        int check = 0;
        HttpSession session = request.getSession();
        String logged = (String) session.getAttribute("logged");
        String admin = (String) session.getAttribute("admin");
        if (logged.equalsIgnoreCase("false")) {
            response.sendRedirect("reg_form.html");
            Cookie warning = new Cookie("warning", "You_are_not_logged_in");
            warning.setMaxAge(10);
        } else if (logged.equalsIgnoreCase("true")&&admin.equalsIgnoreCase("true")) {
            forward = MAIN;
            session.setAttribute("students", log_stu.getAllStudent());
            session.setAttribute("subjects", log_sub.getAllSubjects());
            request.setAttribute("students", log_stu.getAllStudent());
            request.setAttribute("subjects", log_sub.getAllSubjects());
        } else if (logged.equalsIgnoreCase("true")&&admin.equalsIgnoreCase("false")) {
            forward=USER_PAGE;
            user.setUser((String)session.getAttribute("username"));
            List<User> users = new ArrayList<User>();
            users.add(user_logic.getUserByName(user.getUser()));
            session.setAttribute("users", users);
            request.setAttribute("users", users);
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = null;
        String action = request.getParameter("submit");
        User user = new User();

        if (action.equalsIgnoreCase("Login")) {
            forward = UserController;
            user.setUser(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            HttpSession session = request.getSession(true);
            session.setAttribute("action_to_do", "check");
            session.setAttribute("user", user);
        }

        if (action.equalsIgnoreCase("Registration")) {
            forward = REG_FORMA;
            request.setAttribute("checking", 1);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }
}
