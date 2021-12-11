<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Poke Monster</title>
</head>
<body>

	<h1>Poke Monster </h1>
		<table>
			<thead>
			
				<tr>
					<th> Cost </th>
					<th> Vendor </th>
					<th> Price </th>
					<th> Actions </th>
				
				</tr>
			
			</thead>
			<tbody>
			
				<c:forEach var="exp" items="${expenses }" >
				<tr> 
				
					<td> <c:out value="${exp.name }"  /></td>
					<td> <c:out value="${exp.vendor }" /> </td>
					<td><fmt:formatNumber value="${exp.amount}" type="currency"/></td>
	         	
	         	<td><a href="/expenses/edit/${exp.id}">edit</a> | <a href="/expenses/${exp.id}">show</a></td>
					
				
				</tr>
				</c:forEach>
			</tbody>
		
		
		</table>
		
		<div>
			<h1>Track Expense </h1>
			<form:form action="/expenses" method="post" modelAttribute="expense" >
				<p>
				
					<form:label path="name"> Expense Label/Name </form:label>
					<form:input path="name" />
					<form:errors path="name" />
					
				</p>
				<p>
				
					<form:label path="vendor"> Vendor </form:label>
					<form:input path="vendor" />
					<form:errors path="vendor"/>				
				</p>
				<p>
					<form:label path="amount"> Expensive Amount </form:label>
					<form:input type="number" path="amount" step="any"/>
		    		<form:errors path="amount"/>
					
				</p>
				<p>
					<form:label path="description" > Description: </form:label>
					<form:input path="description" />
					<form:errors path="amount" />
				</p>
				
				
				<button> Submit Please </button>
		
		</form:form>
		</div>

</body>
</html>