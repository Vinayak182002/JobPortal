package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Jobs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/add_Job")
public class AddPostServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String title=req.getParameter("title");
			String location=req.getParameter("Location");
			String category=req.getParameter("category");
			String status=req.getParameter("status");
			
			Jobs j=new Jobs();
			j.setTitle(title);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);
			
			HttpSession session=req.getSession();
			
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f=dao.addJobs(j);
			if(f)
			{
				session.setAttribute("succMsg", "Job post successfully...");
				resp.sendRedirect("add_job.jsp");
			}
			else {
				session.setAttribute("succMsg", "Something wrong on server...");
				resp.sendRedirect("add_job.jsp");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
