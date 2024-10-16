<%@page import="checklist1.dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
<td>Task id</td>

<td>Task Name</td>
<td>Task Description</td>
<td>Status</td>
<td>Time</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<% 
List<Task> tasks=(List<Task>) request.getAttribute("tasks");
for(Task t:tasks){
%>
<tr>
    <td><%=t.getTid()%></td>
      <td><%=t.getTName()%></td>
        <td><%=t.getTDescription()%></td>
          <td><%=t.isStatus()%></td>
            <td><%=t.getCT()%></td>
  
</tr>
<%
}
%>
</table>
<a href="addtask.html"><button>Add Task</button></a>
<a href="Logout.html"><button>Logout</button></a>

</body>
</html>