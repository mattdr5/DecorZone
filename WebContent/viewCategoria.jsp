<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="it.unisa.model.utils.CatalogoProdotti, it.unisa.model.beans.Prodotto , it.unisa.model.beans.Categoria" pageEncoding="ISO-8859-1"
%>
<%
CatalogoProdotti catalogo = (CatalogoProdotti) request.getAttribute("catalogo");
%>
<%
if(catalogo != null && !catalogo.getCatalogo().isEmpty())
{

	 String nomeCat = catalogo.getCategoriaCatalogo().getNomeCategoria();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style1.css">
<title> <%= nomeCat %> | DecorZone</title>
</head>
<body>
<jsp:include page="header.jsp" />

<section id="product-category">
<h1 class="text-center mt-2"><%= catalogo.getCategoriaCatalogo().getNomeCategoria() %></h1>
<hr>
<div class="container">
<div class="row  align-items-center justify-content-center">
	 <div class="col-lg-12 col-md-12 col-sm-12 ">
	 	<input type="hidden" id="idCat" value="<%=catalogo.getCategoriaCatalogo().getIdCategoria() %>">
	 	<label class="mr-2">Ordina per</label>
	 	<select id="ordCat">
	 		<option value="" selected="selected" disabled="disabled">Seleziona ordinamento</option>
	 		<option value="prezzoProdotto desc">Prezzo decrescente</option>
	 		<option value="prezzoProdotto asc">Prezzo crescente</option>
	 		<option value="nomeProdotto asc">A-Z</option>
	 		<option value="nomeProdotto desc">Z-A</option>
	 	</select>
	 </div>

</div>
</div>

<div class="container">

   		
  <div class="row " id="products">
	
    <%
    		if(catalogo.getCatalogo().isEmpty() )
    			%> <h1>Categoria Vuota</h1>
  	
           <% for(Prodotto prod : catalogo.getCatalogo() )
           {

   %>
    <!-- Product  -->
 
    <div class="col-lg-4 col-md-6 col-sm-6 col-6 mb-5  p-4 product-grid hidden">
      <div class="image">
        <a href="dettagliprodotto?id=<%=prod.getIdProdotto()%>">
          <img src="imgs/prodotti/<%=prod.getSrcImgProdotto() %>" class="w-100">
        </a>
      </div>
      <h5 class="text-center"><%= prod.getNomeProdotto() %></h5>
        <h5 class="text-center"><%=  String.format("%.2f", prod.getPrezzoConIva()) %> &euro;</h5>  
      <a class="btn buy" href="dettagliprodotto?id=<%=prod.getIdProdotto()%>">Vedi prodotto</a>
      
    </div>
    <!-- ./Product -->
<%
           }
   %>

  </div>
  </div>
  </section>


<jsp:include page="footer.jsp"></jsp:include>

<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/effectOnHover.js"></script>

<script src="js/ordinaCatalogo.js"></script>
</body>
</html>
<% 
}
else 
{
	
 response.sendError(404);
 

} %>

