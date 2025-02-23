<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>To-Do List</title>
</head>
<body>
<h2>To-Do List</h2>

<%
    List<String> tasks = (List<String>) session.getAttribute("tasks");
    if (tasks == null || tasks.isEmpty()) {
%>
<p>No tasks found.</p>
<%
} else {
%>
<p>Number of tasks: <%= tasks.size() %></p>
<ul>
    <%
        for (int i = 0; i < tasks.size(); i++) {
    %>
    <li>
        <%= tasks.get(i) %>
        <a href="DeleteTodo?index=<%= i %>">Delete</a>
    </li>
    <%
        }
    %>
</ul>
<%
    }
%>
<a href="index.html">Back to Home</a>
</body>
</html>
