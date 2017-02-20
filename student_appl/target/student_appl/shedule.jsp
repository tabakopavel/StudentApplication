
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>Student Schedule</TITLE>
</HEAD>

<BODY>
<FORM  method="post" action="">
    Course Name: <INPUT type="text" name="title" size="35"><BR>

    Course Time:
    Mon<INPUT type="checkbox" name="day" value="Monday">
    Tue<INPUT type="checkbox" name="day" value="Tuesday">
    Wed<INPUT type="checkbox" name="day" value="Wednesday">
    Thu<INPUT type="checkbox" name="day" value="Thursday">
    Fri<INPUT type="checkbox" name="day" value="Friday">
    Sat<INPUT type="checkbox" name="day" value="Saturday">
    Sun<INPUT type="checkbox" name="day" value="Sunday">
    <SELECT name="Pare">
        <OPTION value="1">8:15-9:35</OPTION>
        <OPTION value="2">9:45-11:05</OPTION>
        <OPTION value="3">11:15-12:35</OPTION>
        <OPTION value="4">12:45-14:05</OPTION>
        <OPTION value="5">14:25-15:45</OPTION>
        <OPTION value="6">15:55-17:15</OPTION>
        <OPTION value="7">17:25-18:45</OPTION>
        <OPTION value="8">18:55-20:15</OPTION>
        <OPTION value="9">20:25-21:45</OPTION>
    </SELECT>
    <BR>
    <BR>
    <INPUT type="submit" name="Submit" value="Add Course">
</FORM>



</BODY>
</HTML>