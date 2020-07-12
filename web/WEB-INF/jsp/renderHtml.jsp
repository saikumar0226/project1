<%@ page import="java.util.List" %>
<%@ page import="database.PersonEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Render Templace in JSP </title>
</head>
<body>
    <% List<PersonEntity> persons = (List)request.getAttribute("personList"); %>
        out.println("<table border=1px>");

        <% for(PersonEntity person : persons) {
            out.println("<tr>");
            out.println("<td> " + person.getId() + "</td>");
            out.println("<td> " + person.getName() + "</td>");
            out.println("<td> " + person.getAddress() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    %>
</body>
</html>
