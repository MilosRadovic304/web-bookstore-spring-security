<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
 	<link href="${pageContext.request.contextPath}/resources/css/updateBook.css" rel="stylesheet" type="text/css"> 
	<%@ include file="header.jsp" %>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	
	
<!--  	<script>
		$(document).ready(function(){
			$("input").focus(function () {
				$(this).css("background-color", "##FF6347");
			});
			$("input").blur(function () {
				$(this).css("background-color", "#FFF");
			});
		});
	</script>   -->
	
    
</head>

<body>
	<div id="container">
		
		<h2>Update Book:</h2><br/>
		
	
		<div id="f">
			
	 		<form:form action="saveBook" modelAttribute="book" method="POST"> 
					
					<!--  Need to associate this data with customer id --> 
	 				<form:hidden path="id" /> 
						<table> 
	 						<tbody> 
								<tr> 
									<td><label>Title:</label></td> 
									<td><form:input path="title"/></td> 
								</tr> 
								
								<tr> 
									<td><label>Author:</label></td> 
	 								<td><form:input path="author"/></td> 
								</tr> 
															
								<tr> 
									<td><label></label></td> 
									<td><input type="submit" value="Save" class="save" /></td> 
	 							</tr> 
							
							</tbody>					 
						</table> 
					
					</form:form> 
					
			<p>
				<a href="${ pageContext.request.contextPath}/book/list">Back to List</a>				
			</p>
					  
		</div>
	</div>	
	
	
	<div class="footer">
		<p>THE BOOKSTORE, Kneza Mihajla 33/2, 11000 Belgrade </p>
	</div>

</body>
</html>