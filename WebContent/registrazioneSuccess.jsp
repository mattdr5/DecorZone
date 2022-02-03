<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Benvenuto in DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section id="registration-success">
	<div class="mycontainer">
		<div class="content">
		
			<div id="reg-success-text">
				<h1 class="text-center"> Registrazione completa <i class="fa fa-check-square" style="font-size:36px;color:green"></i></h1>
				<p> Per usufruire dei nostri servizi effettua il <a href="login.jsp">login </a>
			</div>
		

		
		</div>
	
	</div>


</section>
<jsp:include page="components/common-script.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>