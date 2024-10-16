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
@WebServlet("/login")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	UserLogic logic=new UserLogic();
	User l=logic.fetchByEmail(email);
	if(l!=null) {
		if(l.getPassword().equals(password)) {
		req.getSession().setAttribute("user", l);
		List<Task> tasks=logic.fetchById(l.getId());
	        req.setAttribute("tasks", tasks);
			resp.getWriter().print("<h1 style=color:Green>welcome to home page</h1>");
			req.getRequestDispatcher("home.jsp").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1 style=color:red>incorrect email or password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
	else {
		resp.getWriter().print("<h1 style=color:red>incorrect email or password</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}
