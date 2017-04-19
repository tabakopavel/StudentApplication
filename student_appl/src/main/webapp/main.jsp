<%@ page import="Log_db.User_logic" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Students and Subjects</title>
    <link href="css/student.css" rel="stylesheet">
    <link href="css/subject.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/nav.css" rel="stylesheet">
</head>
<body>
<%
    String logged = (String) session.getAttribute("logged");
    String admin = (String) session.getAttribute("admin");
    System.out.println(logged);
    if (logged == null) {
        response.sendRedirect("/MainController");
        System.out.println("user page send redirect");
    } else {
        User_logic user_logic = new User_logic();
        if (logged.equalsIgnoreCase("false")) {
            response.sendRedirect("reg_form.html");
            Cookie warning = new Cookie("warning", "You_are_not_logged_in");
            warning.setMaxAge(10);
        } else if (admin.equalsIgnoreCase("false")) {
            response.sendRedirect("/UserController");
        } else if (logged.equalsIgnoreCase("true") && admin.equalsIgnoreCase("true")) {
            String user_name = (String) session.getAttribute("username");
            String user_token = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user_token")) user_token = cookie.getValue();
                }
            }
            boolean check = user_logic.checkTokenByName(user_name, user_token);
            if (check == false) {
                response.sendRedirect("reg_form.html");
                Cookie warning = new Cookie("warning", "You_are_not_logged_in");
                warning.setMaxAge(10);
            }

        } else if (logged.equalsIgnoreCase("true") && admin.equalsIgnoreCase("false")) {
            response.sendRedirect("/UserController");
        } else if (logged == null) {
            response.sendRedirect("/MainController");
            System.out.println("user page send redirect");
        }
    }

%>
<div class="bodyflex">


    <h2 class="offscreen">W3C Web Resources</h2>
    <div id="hmenu">
        <ul>
            <li><a href="/MainController">Main page</a></li>
            <li><a href="/LogOutController">LogOut</a></li>
            <li><a href="/UserController">My page</a></li>
        </ul>
    </div>

    <div class="bodyflex1">
        <table class="subject_table">
            <thead>
            <tr>
                <th><a href="#addsub"><img title="" src="images/add.png" width="35" height="35" alt="" align="right"/>Add
                    New Subject</a></th>
            </tr>
            </thead>
        </table>
        <table class="subject_table">
            <thead>
            <tr>
                <th>Subject</th>
                <th>Tutor</th>
                <th colspan=2></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${subjects}" var="subject">
                <tr>
                    <td><c:out value="${subject.sub_name}"/></td>
                    <td><c:out value="${subject.sub_tutor}"/></td>
                    <td><a href="#editsub?action=edit&id_sub=<c:out value="${subject.id_sub}"/>"><img
                            src="images/edit.png" width="25" height="25" alt="Edit"> </a>
                        <a href="SubjectController?action=edit&id_sub=<c:out value="${subject.id_sub}"/>"
                           class="overlay" id="editsub?action=edit&id_sub=<c:out value="${subject.id_sub}"/>"></a>
                        <div class="popup">
                            <form method="POST" action='/SubjectController'>
                                <table class="subject_table_add">
                                    <thead>
                                    <tr>
                                        <th>
                                            Subject id_sub : <input type="text" name="id_sub" readonly="readonly"
                                                                    value="<c:out value="${subject.id_sub}" />"
                                                                    readonly="readonly"/> <br/>
                                            Subject Name : <input type="text" name="sub_name"
                                                                  value="<c:out value="${subject.sub_name}" />"/> <br/>
                                            Subject Tutor : <input type="text" name="sub_tutor"
                                                                   value="<c:out value="${subject.sub_tutor}" />"/>
                                            <br/>


                                            <input type="submit" value="Submit"/>
                                        </th>
                                    </tr>
                                </table>

                            </form>
                            <a class="close" title="¬©¬Ñ¬Ü¬â¬í¬ä¬î" href="#close"></a>
                        </div>
                    </td>
                    <td><a href="SubjectController?action=delete&id_sub=<c:out value="${subject.id_sub}"/>"><img
                            src="images/delete.png" width="25" height="25" alt="Delete"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="SubjectController?action=insert" class="overlay" id="addsub"></a>
        <div class="popup">
            <form method="POST" action='/SubjectController'>
                <table class="subject_table_add">
                    <thead>
                    <tr>
                        <th>
                            Subject Name : <input type="text" name="sub_name"
                                                  value="<c:out value="${subject.sub_name}" />"/> <br/>
                            Subject Tutor : <input type="text" name="sub_tutor"
                                                   value="<c:out value="${subject.sub_tutor}" />"/> <br/>

                            <input type="submit" value="Add Subject"/>
                        </th>
                    </tr>
                </table>
            </form>
            <a class="close" title="¬©¬Ñ¬Ü¬â¬í¬ä¬î" href="#close"></a>
        </div>
    </div>

    <div class="bodyflex2">
        <table class="student_table">
            <thead>
            <tr>
                <th><a href="#addst"><img title="" src="images/add.png" width="35" height="35" alt="" align="right"/>Add
                    New Student</a></th>
            </tr>
        </table>
        <table class="student_table">
            <thead>
            <tr>
                <th>Student id</th>
                <th>Student name</th>
                <th>Student surname</th>
                <th>Student ph_num</th>
                <th>Number of student's book</th>
                <th>Year of enter</th>
                <th colspan=2></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value="${student.id_st}"/></td>
                    <td><c:out value="${student.st_name}"/></td>
                    <td><c:out value="${student.st_surname}"/></td>
                    <td><c:out value="${student.st_ph_num}"/></td>
                    <td><c:out value="${student.num_st_book}"/></td>
                    <td><c:out value="${student.year}"/></td>
                    <td><a href="#editst?action=edit&id_st=<c:out value="${student.id_st}"/>"><img src="images/edit.png"
                                                                                                   width="40"
                                                                                                   height="40"
                                                                                                   alt="Edit"> </a>
                        <a href="StudentController?action=edit&id_st=<c:out value="${student.id_st}"/>" class="overlay"
                           id="editst?action=edit&id_st=<c:out value="${student.id_st}"/>"></a>
                        <div class="popup">
                            <form method="POST" action='/StudentController'>
                                <table class="student_table_add">
                                    <thead>
                                    <tr>
                                        <th>
                                            Student id_st : <input type="text" name="id_st" readonly="readonly"
                                                                   value="<c:out value="${student.id_st}" />"
                                                                   readonly="readonly"/> <br/>
                                            Student Name : <input type="text" name="st_name"
                                                                  value="<c:out value="${student.st_name}" />"/> <br/>
                                            Student SurName : <input type="text" name="st_surname"
                                                                     value="<c:out value="${student.st_surname}" />"/>
                                            <br/>
                                            Student St_ph_num : <input type="text" name="st_ph_num"
                                                                       value="<c:out value="${student.st_ph_num}" />"/>
                                            <br/>
                                            Student Num_st_book : <input type="text" name="num_st_book"
                                                                         value="<c:out value="${student.num_st_book}" />"/>
                                            <br/>
                                            Student Year : <input type="text" name="year"
                                                                  value="<c:out value="${student.year}" />"/> <br/>

                                            <input type="submit" value="Submit"/>
                                        </th>
                                    </tr>
                                </table>

                            </form>
                            <a class="close" title="¬©¬Ñ¬Ü¬â¬í¬ä¬î" href="#close"></a>
                        </div>
                    </td>
                    <td><a href="StudentController?action=delete&id_st=<c:out value="${student.id_st}"/>"><img
                            src="images/delete.png" width="40" height="40" alt="Delete"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="StudentController?action=insert" class="overlay" id="addst"></a>
        <div class="popup">
            <form method="POST" action='/StudentController'>
                <table class="student_table_add">
                    <thead>
                    <tr>
                        <th>
                            Student Name : <input type="text" name="st_name"
                                                  value="<c:out value="${student.st_name}" />"/> <br/>
                            Student SurName : <input type="text" name="st_surname"
                                                     value="<c:out value="${student.st_surname}" />"/> <br/>
                            Student St_ph_num : <input type="text" name="st_ph_num"
                                                       value="<c:out value="${student.st_ph_num}" />"/> <br/>
                            Student Num_st_book : <input type="text" name="num_st_book"
                                                         value="<c:out value="${student.num_st_book}" />"/> <br/>
                            Student Year : <input type="text" name="year"
                                                  value="<c:out value="${student.year}" />"/> <br/>

                            <input type="submit" value="Add Student"/>
                        </th>
                    </tr>
                </table>
            </form>
            <a class="close" title="¬©¬Ñ¬Ü¬â¬í¬ä¬î" href="#close"></a>
        </div>
    </div>

</div>
</body>
</html>