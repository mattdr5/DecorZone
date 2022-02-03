<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  import="it.unisa.model.beans.Utente, it.unisa.model.beans.Prodotto"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Modifica foto | DecorZone</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>
<%
	
		Prodotto prodotto = (Prodotto) request.getAttribute("prodotto");
		if(prodotto == null)
		{
			response.sendError(404);
		}
		else
		{
			Utente utente = (Utente) session.getAttribute("utente");
			
			if(utente == null)
			{
				response.sendRedirect(this.getServletContext().getContextPath()+"/login");
			}
			else if(utente!= null && !utente.isRuoloUtente())
			{
				response.sendError(404);
			}
			else
			{
			
	%>
<section id="modificaFoto">
	<div class="container mt-2 mb-5">
	<%
      	String mex = (String) session.getAttribute("mexModFoto");

      		if(mex!=null)
      		{
      			%>
      				<div class="alert alert-success animated fadeIn fadeOut " role="alert">
      					<%= mex %>
    				</div>
      			<%
      			session.removeAttribute("mexModFoto");
      		}
      	%>
		<div class="card">
  		<div class="card-body">
  		<h1 class="text-center"> Modifica foto: <%= prodotto.getNomeProdotto() %></h1>
    		 <form id="modFoto" action="modificafoto"  enctype="multipart/form-data" method="POST">
    		 <div class="row d-flex flex-direction-row align-items-center mb-3">
    		 <div class="col-lg-3">
				<div id="image_frame">
					<img id="imgProd" src="./imgs/prodotti/<%= prodotto.getSrcImgProdotto() %>" class="img-responsive w-100 mb-2">
				</div>
				
				</div>
			<div class="col-lg-9">
                <input id="foto" type="file" name="newImage">
            </div>
			</div>
				<input id="id" type="hidden" value="<%= prodotto.getIdProdotto() %>" name="id">
		
				<div class="container text-center">
						
					<input type="submit"  class="btn btn-primary" value="Modifica"/>
				</div>
		
		 </form>
      </div>
  		</div>
   </div>
 </section>

<%}
		
		}%>
		<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/alertAutoClose.js"></script>
</body>
</html>