<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Students</title>
    <link href="css/student.css" rel="stylesheet">

</head>
<body>

<table class="student_table">
    <thead>
    <tr>
        <th><a href="#addst"><img title="" src="images/add.png" width="35" height="35" alt="" align="right" /> Add New Student</a></th>
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
            <td><c:out value="${student.id_st}" /></td>
            <td><c:out value="${student.st_name}" /></td>
            <td><c:out value="${student.st_surname}" /></td>
            <td><c:out value="${student.st_ph_num}" /></td>
            <td><c:out value="${student.num_st_book}" /></td>
            <td><c:out value="${student.year}" /></td>
            <td><a href="#editst?action=edit&id_st=<c:out value="${student.id_st}"/>"><img src="images/edit.png" width="40" height="40" alt="Edit">  </a>
                <a href="StudentController?action=edit&id_st=<c:out value="${student.id_st}"/>" class="overlay" id="editst?action=edit&id_st=<c:out value="${student.id_st}"/>"></a>
                <div class="popup">
                    <form method="POST" action='/StudentController' >
                        <table class="student_table_add"> <thead>
                        <tr>
                            <th>
                                Student id_st : <input type="text" name="id_st" readonly="readonly"
                                                       value="<c:out value="${student.id_st}" />"  readonly="readonly" /> <br />
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

                                <input  type="submit" value="Submit" />
                            </th>
                        </tr>
                        </table>

                    </form>
                    <a class="close" title="¬©¬Ñ¬Ü¬â¬í¬ä¬î" href="#close"></a>
                </div>
            </td>

            <td><a href="StudentController?action=delete&id_st=<c:out value="${student.id_st}"/>"><img src="images/delete.png" width="40" height="40" alt="Delete"></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!--<p><a href="StudentController?action=insert">Add Student</a></p>-->

<a href="StudentController?action=insert" class="overlay" id="addst"></a>
<div class="popup">
    <form method="POST" action='/StudentController' >
        <table class="student_table_add"> <thead>
        <tr>
            <th>
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

        <input  type="submit" value="Add Student" />
            </th>
        </tr>
        </table>
    </form>
    <a class="close" title="¬©¬Ñ¬Ü¬â¬í¬ä¬î" href="#close"></a>
</div>



</body>
</html>