package Controller;

import Log_db.Student_logic;
import Log_db.Subject_logic;
import Log_db.User_logic;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LogOutController")
public class LogOutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    User_logic user_logic;
    private Student_logic log = null;
    private Subject_logic log_sub = null;
    private static String MAIN = "/main.jsp";
    private static String REG_FORM = "/reg_form.html";
    private static String REG_FORMA = "/reg_forma.html";
    private final String log_admin = "admin";
    private final String pass_admin = "admin";
    private final String USER_PAGE = "/user_page.jsp";


    public LogOutController() {
        user_logic = new User_logic();
        log = new Student_logic();
        log_sub = new Subject_logic();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
        System.out.println("go get");
        String forward = null;

        HttpSession session = request.getSession();
        String action = "logout";//request.getParameter("action");
        String user_name = (String) session.getAttribute("username");
        String logged = (String) session.getAttribute("logged");
        String admin = (String) session.getAttribute("admin");


        System.out.println(logged);
        System.out.println(admin);
        System.out.println(user_name);

        String user_token_s = session.getId();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_token")) {
                    user_token_s = cookie.getValue();
                }

            }
        }


        if (action == "logout" /*&& logged == "true"*/) {
            System.out.println("work delete method");
            user_logic.deleteTokenByName(user_name);
            session.removeAttribute("logged");
            session.removeAttribute("username");
            session.removeAttribute("admin");
            session.removeAttribute("users");
            session.removeAttribute("students");
            session.removeAttribute("subjects");

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    System.out.println(cookie.getName());
                    if (cookie.getName().equalsIgnoreCase("user_token")) {
                        Cookie cookiee = new Cookie("user_token", "");
                        cookiee.setMaxAge(0);
                        response.addCookie(cookiee);
                    }
                    if (cookie.getName().equalsIgnoreCase("warning")) {
                        Cookie cookieq = new Cookie("warning", "");
                        cookieq.setMaxAge(0);
                        response.addCookie(cookieq);

                    }

                }
            }
            if (session != null) {
                session.invalidate();
                session.setMaxInactiveInterval(0);
            }
            forward = REG_FORM;

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post");
    }
}
