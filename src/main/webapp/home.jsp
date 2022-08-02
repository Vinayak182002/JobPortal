<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.entity.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.JobDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   isELIgnored="false" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User : view jobs</title>
<%@include file="all_component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2">
<%@include file="all_component/navbar.jsp" %>

	<c:if test="${empty userobj }">
		<c:redirect url = "login.jsp" />
	</c:if>
			
	<div class = "container" >
		<div class = "row" >
			<div class = "col-md-12" >
		
				<br><hr>
				<h2 class = " text-center text-primary " > All Jobs </h2>
				
				<hr>
						
						<% 
			JobDAO dao= new JobDAO(DBConnect.getConn());
			List<Jobs> list = dao.getAllJobsForUser();
			for(Jobs j: list)
			{%>	
			<div class="card mt-2">
				<div class="card-body">
					<div class="text-center text-primary">
						<i class="far fa-clipboard fa-2x"></i>
					</div>
					<h6><%=j.getTitle() %></h6>
					<br>
					
					<div class="form-row">
						<div class="form-group col-md-3">
							<input type="text" class="form-control form-control-sm" value="Location: <%=j.getLocation()%>" readonly>
						</div>
						<div class="form-group col-md-3">
							<input type="text" class="form-control form-control-sm" value="Category: <%=j.getCategory()%>" readonly>
						</div>
					</div>
					<div class="text-center">
					<a href="#" class="btn btn-sm bg-success text-white">View More about this Job..</a>
					</div>
		
					</div>
				</div>
							<%
					}
			%>
			</div>
			<br>
			<br>
</body>
</html>