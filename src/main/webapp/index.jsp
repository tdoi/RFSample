<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Web</title>
</head>
<body>

        <form action="./Calc" method="POST">
            <input type="text" name="arg1" value="<%= request.getAttribute("arg1") %>" />
            <span>+</span>
            <input type="text" name="arg2" value="<%= request.getAttribute("arg2") %>" />
            <input type="submit" value="="/>
            <input type="text" name="result" value="<%= request.getAttribute("result") %>" />
        </form>

        <ul>
<%
List<String> history = (List<String>)request.getAttribute("history");
if (history != null) {
for (String item : history) {
%>
        <li><%= item %></li>
<%
}
}
 %>
        </ul>
</body>
</html>