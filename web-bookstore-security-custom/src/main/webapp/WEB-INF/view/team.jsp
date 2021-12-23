<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Header</title>
		<link href="${pageContext.request.contextPath}/resources/css/registration.css" rel="stylesheet" type="text/css">
		<link href="https://code.jquery.com/ui/1.10.4/themes/ui-darkness/jquery-ui.css" rel="stylesheet"> 
		<%@ include file="header.jsp" %>
		
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
				
		<script>
		$(function(){
			$("#accordion-1").accordion();			
		});
		</script>
	</head>
	
	<body>
	<div id="container">
	
			
		<div id="accordion-1">
			<h3>John Smith - Chairman</h3>
				<div>
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
						Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an 
						unknown printer took a galley of type and scrambled it to make a type specimen book. 
						It has survived not only five centuries, but also the leap into electronic typesetting, 
						remaining essentially unchanged. It was popularised in the 1960s with the release of 
						Letraset sheets containing Lorem Ipsum passages, and more recently with desktop 
						publishing software like Aldus PageMaker including versions of Lorem Ipsum.
					</p>
				</div>
			<h3>Stephen King - CEO</h3>
				<div>
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
						Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an 
						unknown printer took a galley of type and scrambled it to make a type specimen book. 
						It has survived not only five centuries, but also the leap into electronic typesetting, 
						remaining essentially unchanged. It was popularised in the 1960s with the release of 
						Letraset sheets containing Lorem Ipsum passages, and more recently with desktop 
						publishing software like Aldus PageMaker including versions of Lorem Ipsum.
					</p>
				</div>
			<h3>Linus Torvalds - Manager</h3>
				<div>
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
						Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an 
						unknown printer took a galley of type and scrambled it to make a type specimen book. 
						It has survived not only five centuries, but also the leap into electronic typesetting, 
						remaining essentially unchanged. It was popularised in the 1960s with the release of 
						Letraset sheets containing Lorem Ipsum passages, and more recently with desktop 
						publishing software like Aldus PageMaker including versions of Lorem Ipsum.
					</p>
				</div>
	</div>
	
	
	</div>
	<div class="footer">
		<p>THE BOOKSTORE, Kneza Mihajla 33/2, 11000 Belgrade </p>
	</div>
	</body>
</html>
