<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new student</title>
</head>
<body>
<form method="POST" action='/StudentController' >
    <% String action = request.getParameter("action");
        System.out.println(action);
    %>
    <% if (action.equalsIgnoreCase("edit")) {%>

    Student id_st : <c:out value="${student.id_st}" /> <br />

    Student Name : <input type="text" name="st_name"
                          value="<c:out value="${student.st_name}" />" /> <br />
    Student SurName : <input type="text" name="st_surname"
                          value="<c:out value="${student.st_surname}" />" /> <br />
    Student St_ph_num : <input type="text" name="st_ph_num"
                          value="<c:out value="${student.st_ph_num}" />" /> <br />
    Student Num_st_book : <input type="text" name="num_st_book"
                          value="<c:out value="${student.num_st_book}" />" /> <br />
    Student Year : <input type="text" name="year"
                          value="<c:out value="${student.year}" />" /> <br />



    <%} else {%>

    Student Name : <input type="text" name="st_name"
                          value="<c:out value="${student.st_name}" />" /> <br />
    Student SurName : <input type="text" name="st_surname"
                             value="<c:out value="${student.st_surname}" />" /> <br />
    Student St_ph_num : <input type="text" name="st_ph_num"
                               value="<c:out value="${student.st_ph_num}" />" /> <br />
    Student Num_st_book : <input type="text" name="num_st_book"
                                 value="<c:out value="${student.num_st_book}" />" /> <br />
    Student Year : <input type="text" name="year"
                          value="<c:out value="${student.year}" />" /> <br />



    <%} %>


    <input  type="submit" value="Submit" />
</form>
</body>
</html>
