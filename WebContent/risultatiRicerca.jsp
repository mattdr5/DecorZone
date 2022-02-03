<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  import="it.unisa.model.beans.Prodotto, it.unisa.model.utils.CatalogoProdotti"  pageEncoding="ISO-8859-1"%>
    
    <% String testoRicerca = (String)request.getAttribute("ricerca-text"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/mdb.css" rel="stylesheet">
<link rel="stylesheet" href="css/style1.css">
<title>Risultati per <%=testoRicerca %> | DecorZone</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<% 
CatalogoProdotti catalogo = (CatalogoProdotti) request.getAttribute("catalogo");
if(catalogo == null)
{
	response.sendError(404);
}
else
{

%>
	<section id="categorie">
	<div class="container">
		<h1 id="text-ricerca" class="text-center">Risultati della ricerca per "<%=testoRicerca %>"</h1>
		<hr>

<% if(!catalogo.getCatalogo().isEmpty())
		{
		%>
		
		
		<h4 id="text-ricerca-failed" class="mb-3">La ricerca ha prodotto <%=catalogo.getCatalogo().size() %> risultato/i</h4>
		<div class="row">
		<% for(Prodotto prod : catalogo.getCatalogo())
			{%>
			<!-- Product  -->
			<div class="col-md-4 categoria-grid">
				<div class="image-category">
					<a href="dettagliprodotto?id=<%= prod.getIdProdotto() %>">
						<img src="imgs/prodotti/<%=prod.getSrcImgProdotto() %>" alt="FOTO" class="w-100 animated fadeIn">
					</a>
				</div>
				<h5 class="text-center"><%= prod.getNomeProdotto() %></h5>
				<a class="btn buy" href="dettagliprodotto?id=<%=prod.getIdProdotto()%>">Vedi prodotto</a>
			</div>
			<!-- ./Product -->
			<%}%>
		</div>
		<%}
		else
		{%>
		<div class="row">
		<div id="ricerca-fail">
			
			<h1 class="text-center"> Nessun risultato per "<%= testoRicerca %>" </h1>
			<p class="text-center">Prova a controllare l'ortografia o utilizza termini più generici </p>
			
			
		</div>
		</div>
		<%} %>
	
	</div>
		
		
	
	</section>
	
	<hr>

<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/effectOnHover.js"></script>
<%} %>
</body>
</html>