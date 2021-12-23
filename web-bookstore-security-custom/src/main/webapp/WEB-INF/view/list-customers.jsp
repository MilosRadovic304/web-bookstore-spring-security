<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

	<head>	
		<title>List Customers</title>
		
		<!-- reference our style sheet -->
		 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" /> 
		<!--<link href="${pageContext.request.contextPath}/resources/css/registration.css" rel="stylesheet" type="text/css">-->
		
		<%@ include file="header.jsp" %>
	</head>
	
	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>Customers</h2>
			</div>
		
			<div id="container">
			
				<div id="content"></div>
				
			
		
				
					<!-- add html table here -->
				
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
						</tr>
					
						<!-- loop over and print our customers -->
						
						<c:forEach var="tempCustomer" items="${customers}">
						
				
						
						
							<tr>
								<td> ${tempCustomer.firstName} </td>
								<td> ${tempCustomer.lastName} </td>
								<td> ${tempCustomer.email} </td>
								<td>
									
								</td>
							</tr>
						
						</c:forEach>
					
					</table>
					
					<br>
					
					<br>

				
			</div>
		</div>

	
		<div class="footer">
			<p>THE BOOKSTORE, Kneza Mihajla 33/2, 11000 Belgrade </p>
		</div>
	</body>



</html>