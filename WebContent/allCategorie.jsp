
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
import="it.unisa.model.beans.Categoria, java.util.ArrayList"
pageEncoding="ISO-8859-1"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
<title>Tutte le categorie | DecorZone</title>
</head>
<body>
<jsp:include page="header.jsp" /> 

<% 
ArrayList<Categoria> listCategorie = (ArrayList<Categoria>) request.getAttribute("categorie");
if(listCategorie == null)
{
	response.sendError(404);
}

%>
	<section id="categorie">
	<div class="container">
		<h1 class="text-center">Tutte le categorie</h1>
		<hr>

		<div class="row">
		
		<% if(listCategorie!=null && !listCategorie.isEmpty())
		{
		%>
		<% for(Categoria cat : listCategorie)
			{%>
			<!-- Product  -->
			<div class="col-lg-4 col-md-6 col-sm-6 col-6 categoria-grid hidden">
				<div class="image-category">
					<a href="categoria?id=<%= cat.getIdCategoria() %>">
						<img src="imgs/categorie/<%=cat.getSrcImg()%>" class="w-100">
					</a>
				</div>
				<h5 class="text-center"><%= cat.getNomeCategoria() %></h5>
			</div>
			<!-- ./Product -->
			<%}
		}%>
			
		</div>
	</div>
		
		
	
	</section>
	
	<hr>





<jsp:include page="footer.jsp" />  	
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/effectOnHover.js"></script>
</body>
</html>