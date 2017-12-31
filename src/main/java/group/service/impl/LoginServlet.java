package group.service.impl;


import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group.dao.impl.UserDAO;
import group.entity.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao=new UserDAO();

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User u = userDao.findByName(username);
		
		
		if(u!=null&&u.getPassword().equals(password))	
		{
			HttpSession session=request.getSession();

			session.setAttribute("user", u);	
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
				
		response.setContentType("text/html;charset=UTF-8");
	
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
