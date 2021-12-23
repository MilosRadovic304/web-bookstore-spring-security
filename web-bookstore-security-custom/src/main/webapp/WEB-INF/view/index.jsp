<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Header</title>
		<link href="${pageContext.request.contextPath}/resources/css/registration.css" rel="stylesheet" type="text/css">
		<%@ include file="header.jsp" %>		

	</head>
	
	<body>
	<div id="container">
		
		<br/><br/>
		<label><h1>Welcome to our bookshop</h1></label>

		<img id="b3" src="${pageContext.request.contextPath}/resources/images/book5.jpg" alt="book" >
		
		<div id="f">
			<form action="${pageContext.request.contextPath}/book/search" method="GET">
				<label for="search">Search Books</label>
				<input type="text" id="search" name="theSearchName" placeholder="Search for books..">
				<input type="submit" value="Submit">
			</form>
			

		</div>	
	</div>
	
	<div class="footer">
		<p>THE BOOKSTORE, Kneza Mihajla 33/2, 11000 Belgrade </p>
	</div>

	</body>
</html>
