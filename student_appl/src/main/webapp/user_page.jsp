<%@ page import="Log_db.User_logic" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Page</title>
    <link href="css/nav.css" rel="stylesheet">
</head>
<body>
<%
    String logged = (String) session.getAttribute("logged");
    System.out.println(logged);

    User_logic user_logic = new User_logic();
    if (logged.equalsIgnoreCase("false")) {
        response.sendRedirect("reg_form.html");
        Cookie warning = new Cookie("warning", "You_are_not_logged_in");
        warning.setMaxAge(10);
    } else if (logged.equalsIgnoreCase("true")) {
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
        else if(logged==null){
            response.sendRedirect("/MainController");
            System.out.println("user page send redirect");
        }

    }
%>
<h2 class="offscreen">W3C Web Resources</h2>
<div id="hmenu">
    <ul>
        <li><a href="/main.jsp">Main page</a></li>
        <li><a href="/LogOutController?action=logout">LogOut</a></li>
        <li><a href="/user_page.jsp">My page</a></li>
    </ul>
</div>

<h1>
<div>
    <c:forEach items="${users}" var="user">
        <a>
            <c:out value="${user.id_user}"/> <br/>
            <c:out value="${user.user}"/>  <br/>
            <c:out value="${user.email}"/>  <br/>
            <c:out value="${user.activation}"/>  <br/>
        </a>

    </c:forEach>
</div>
</h1>

</body>
</html>