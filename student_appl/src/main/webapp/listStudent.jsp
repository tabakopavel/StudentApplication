<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Students</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Student id</th>
        <th>Student name</th>
        <th>Student surname</th>
        <th>Student ph_num</th>
        <th>Student's st_book</th>
        <th>Student's year of ???</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.id_st}" /></td>
            <td><c:out value="${student.st_name}" /></td>
            <td><c:out value="${student.st_surname}" /></td>
            <td><c:out value="${student.st_ph_num}" /></td>
            <td><c:out value="${student.num_st_book}" /></td>
            <td><c:out value="${student.year}" /></td>
            <td><a href="StudentController?action=edit&id_st=<c:out value="${student.id_st}"/>">Edit</a></td>
            <td><a href="StudentController?action=delete&id_st=<c:out value="${student.id_st}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="StudentController?action=insert">Add Student</a></p>
</body>
</html>