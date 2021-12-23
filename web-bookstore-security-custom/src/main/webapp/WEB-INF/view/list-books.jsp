<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- adding support for JSTL core tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

	<head>	
		<title>List Books</title>
		
		<%@ include file="header.jsp" %>
		
		<!-- reference css-->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" /> 
		
		
	</head>
	
	<body>
	
		<script type="text/javascript">
			function alertBuy(){
			alert("You have bought the book! Check SALES table in the DB");
			} 
		</script> 
	

		<div id="wrapper">
			<div id="header2">
				<h2>Books</h2>
			</div>
		
			<div id="container">
			
				<div id="content"></div>
							
					<!-- add html table here -->
				
					<table>
						<tr>
							<th>Title</th>
							<th>Author</th>
							<th>Action</th>
						</tr>
					
						<!-- loop over and print our books -->
						
						<c:forEach var="tempBook" items="${books}"> <!-- attribute name from controller (from Spring Model)-->
										
				
						<security:authorize access="hasRole('ADMIN')">
				
							<!-- construct an 'update' link with book id -->
							<c:url var="updateLink" value="showFormForUpdate">
								<c:param name="bookId" value="${tempBook.id}" />						
							</c:url>
							
							<!-- construct an 'delete' link with book id -->
							<c:url var="deleteLink" value="../book/delete">
								<c:param name="bookId" value="${tempBook.id}" />						
							</c:url>
						</security:authorize>
							
						<!-- construct an 'buy' link with book id -->
						<c:url var="buyLink" value="../book/buy">
							<c:param name="bookId" value="${tempBook.id}" />
							<c:param name="customerId" value="${pageContext.request.remoteUser}" />												
						</c:url>
						
							<tr>
								<td> ${tempBook.title} </td>
								<td> ${tempBook.author} </td>
								<td>
								
								<security:authorize access="hasRole('ADMIN')">
									<!-- Display the update link -->
									<a href="${updateLink}">Update</a>
									|
									<a href="${deleteLink}" onclick ="if(!(confirm('Are you shure you want to delete this book?')))return false">Delete</a>
									|
								</security:authorize>
									<a href="${buyLink}" onclick ="alertBuy()">Buy</a>
									
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