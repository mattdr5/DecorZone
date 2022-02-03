<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Ordine registrato | DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section id="ordine-success">
	<div class="mycontainer">
		<div class="content">
		
			 <% String mex = (String) request.getAttribute("mex");

	      		if(mex!=null)
		      		{
		      			if(mex.equals("true"))
		      			{%>
		      				<h1 align="CENTER">	  Acquisto riuscito!   
								<i class="fa fa-check-square" style="font-size:36px;color:green"></i></h1>
								<p> Puoi visualizzare il riepilogo dell'ordine nella sezione <a href="imieiordini">i miei ordini</a><a href="index.jsp"> </a>
				
		    				
		      			<% 
		      			session.removeAttribute("messaggio");
		      			}
		      			else if(mex.equals("false"))
		      			{%>
		      			<h1 align="CENTER">	 Acquisto non riuscito! 
								<i class="fa fa-exclamation-triangle" style="font-size:36px;color:red"></i> </h1>
								<p> Riprova, val al <a href="carrello">carrello</a><a href="index.jsp"> </a>
		    			
		    			<%
		    			session.removeAttribute("messaggio");
		    			}
		      			else
		      			{%>
		      				<h1 align="CENTER">	  Acquisto non riuscito Saldo insufficiente!
								<i class="fa fa-exclamation-triangle" style="font-size:36px;color:red"></i> </h1>
								<p> Ricarica la carta <a href="index">Vai alla homepage</a></p>
		      			<%
		      			session.removeAttribute("messaggio");
						}
		      			
		      		}
		      	%>
		      	
		
		

		
		</div>



</section>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="components/common-script.jsp"></jsp:include>
</body>
</html>