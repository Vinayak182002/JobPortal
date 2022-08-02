package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Jobs;
@WebServlet("/edit_Job")
public class UpdateJobServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String title=req.getParameter("title");
			String location=req.getParameter("Location");
			String category=req.getParameter("category");
			String status=req.getParameter("status");
			
			Jobs j=new Jobs();
			j.setId(id);
			j.setTitle(title);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);
			
			HttpSession session=req.getSession();
			
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f=dao.updateJob(j);
			if(f)
			{
				session.setAttribute("succMsg", "Job update and posted successfully...");
				resp.sendRedirect("View_jobs.jsp");
			}
			else {
				session.setAttribute("succMsg", "Something wrong on server...");
				resp.sendRedirect("View_jobs.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
