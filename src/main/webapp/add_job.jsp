<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   isELIgnored="false" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job</title>
<%@include file="all_component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2">
		<%@include file="all_component/navbar.jsp" %>

		
		<div class ="row p-2" >
			<div class = "col-md-10 offset-md-1" >
				<div class = "card" >
					<div class = " card-body" >
						<div class = " text-center text-success" >
						<i class = "fa fa-user-plus fa-3x" > </i>
						
						 <c:if test="${not empty succMsg }">
							<div class = "alert alert-success" role="alert" > ${ succMsg} </div>
							<c:remove var = "succMsg" />
						</c:if>
						
						<h5>Add Jobs </h5>
						</div>
						<form action = "add_Job" method = "post">
						<div class = "form-group">
						<label > Enter Title </label> 
						<input type = "text" name = "title"
						<required class="form-control">
						</div>
						
						<div class = "form-row" >
						<div class = "form-group col-md-4" >
						<label> Location </label > <select name = "Location"
						class = "custom-select" id = "inline FormCustomSelectPref" >
						<option selected > Choose ... </option >
						<option value = "Maharashtra" > Maharashtra </option >
						<option value = "Odisha" > Odisha </option >
						<option value = "Jharkhand" >Jharkhand </option >
						<option value = "Gujrat" > Gujrat </option >
						<option value = "Goa" >Goa </option >
						</select>
						</div>
						
						<div class = "form-group col-md-4" >
						<label > Category </label > 
						<select class = "custom-select"
						id = "inlineFormCustomSelectPref" name = "category" >
						<option selected > Choose ... </ option >
						<option value = " IT " > IT </ option >
						<option value = " Devloper " > Devloper </ option >
						<option value = " Banking " > Banking </ option >
						<option value = " Engineer " > Engineer </ option >
						<option value = " Teacher " > Teacher </ option >
						</select >
						</div >
						
						<div class = "form-group col-md-4" >
						<label > Status </label > <select class = "form-control" name ="status" >
						<option class = "Active" value = "Active" > Active </option >
						<option class = "inactive" value = "Inactive" > Inactive </option >
						</select >
						</div >


						<button class ="btn btn-success" > Publish Job </button>
						</form>
						
						</div>
					</div>
				</div>
			</div>
	
</body>
</html>