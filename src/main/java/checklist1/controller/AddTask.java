package checklist1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import checklist1.dao.UserLogic;
import checklist1.dto.Task;
import checklist1.dto.User;
@WebServlet("/addtask")
public class AddTask extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("taskname");
	String des=req.getParameter("taskdescription");
	Task t=new Task();
	t.setTName(name);
	t.setTDescription(des);
	User user=(User)req.getSession().getAttribute("user");
	t.setUser(user);
	UserLogic logic=new UserLogic();
	logic.addTask(t);
	
	List<Task> task=logic.fetchById(user.getId());
	req.setAttribute("tasks", task);
	resp.getWriter().print("<h1>Task added</h1>");
	req.getRequestDispatcher("home.jsp").include(req, resp);
}
}
