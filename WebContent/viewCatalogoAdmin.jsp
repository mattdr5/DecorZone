<%@ page language="java" contentType="text/html; charset=utf-8"
    import="it.unisa.model.beans.Utente, it.unisa.model.beans.Prodotto, it.unisa.model.utils.CatalogoProdotti " pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Prodotti | DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>

<% 

  Utente utente = (Utente) session.getAttribute("utente");
  CatalogoProdotti catalogo = (CatalogoProdotti) request.getAttribute("catalogo");
  if(utente == null)
  {
    response.sendRedirect(this.getServletContext().getContextPath()+"/login");
  }
  else if(utente!= null && !utente.isRuoloUtente() || catalogo == null)
  {
	response.sendError(404);
  }
  else
  {

	  if(!catalogo.getCatalogo().isEmpty())
	  {
   %>
   
   <div class="page-wrap d-flex flex-row " style="min-height: 80vh;">

<div class="container">
	      <!-- Section heading -->
    <h1 class="text-center">Prodotti del catalogo DecorZone</h1>
	
	<%
      	String mex = (String) session.getAttribute("mexDelete");

      		if(mex!=null)
      		{
      			if(mex.equals("true"))
      			{%>
      				<div class="alert alert-success animated fadeIn" role="alert">
      					Prodotto reso non disponibile
    				</div>
      			<% }
      			else
      			{%>
      			<div class="alert alert-danger animated fadeIn" role="alert">
      					Attenzione, qualcosa è andato storto! 
    			</div>
    			<%}
      			session.removeAttribute("mexDelete");
      		}
      	%>

  <!--Section: Content-->
  <section class="dark-grey-text text-center mb-5">


    
        <!-- Table -->
    <div class="card">
      <div class="card-body">
        <table class="table table-hover table-responsive ">
          <thead>
            <tr>
              <th scope="col">
                <strong>Immagine</strong>
              </th>
              <th scope="col">
                <strong>Nome <a href="catalogoAdmin?sort=nomeProdotto"> <i class="fa fa-sort"></i> </a> </strong>
              </th>
               <th scope="col">
                <strong>Categoria <a href="catalogoAdmin?sort=nomeCategoria"> <i class="fa fa-sort"></i> </a> </strong>
              </th>
              <th scope="col">
                <strong>Prezzo Unitario <a href="catalogoAdmin?sort=prezzoProdotto"> <i class="fa fa-sort"></i> </a> </strong>
              </th>
              <th scope="col">
                <strong>IVA</strong>
              </th>
              <th scope="col">
                <strong>Quantità disponibile <a href="catalogoAdmin?sort=quantitàDisponibile"> <i class="fa fa-sort"></i> </a></strong> <!-- cambiare il cahrset  -->
              </th>
              <th scope="col">
                <strong>Azioni</strong>
              </th>
            </tr>
          </thead>
          
  				<tbody>
  				<%
  				for(Prodotto prod : catalogo.getCatalogo())
  				{%>
    			<tr>
     				 <td><img class="img-responsive"  src="imgs/prodotti/<%=prod.getSrcImgProdotto() %>" alt="prewiew" width="60px" height="50px"></td>
      				 <td><h5> <strong><%= prod.getNomeProdotto() %></strong> </h5> </td>
      				 <td><h5> <strong><%= prod.getCategoriaProdotto().getNomeCategoria() %></strong> </h5> </td>
      				<td><h5><strong><%= prod.getPrezzoProdotto() %>&euro;</strong></h5>  </td>
      				<td><%= prod.getIVAProdotto() %>%</td>
     				 <td><h5><strong><%=prod.getQuantitaDisponibile() %></strong> pezzi/o</h5></td>
      				<td>
      				<% if(prod.getQuantitaDisponibile() == 0)
      					{%>
      					<a  class="btn btn-outline-danger btn-xs mb-2 disabled" href="javascript:void(0)">Cancella &nbsp;<i class="fa fa-trash mr-2" aria-hidden="true"></i></a>
      				<%}
      				else
      				{
      					%>
        				<a  class="btn btn-outline-danger btn-xs mb-2" href="cancellaprod?id=<%=prod.getIdProdotto() %>">Cancella &nbsp;<i class="fa fa-trash mr-2" aria-hidden="true"></i></a>
        			<%}%>	
        				<a class="btn btn-primary btn-xs mb-2" href="modifica?id=<%=prod.getIdProdotto() %>">Modifica &nbsp;<i class="fa fa-edit mr-2"></i></a>
        				
        				<a  class="btn btn-warning btn-xs mb-2" href="modificafoto?id=<%=prod.getIdProdotto() %>">Modifica foto &nbsp; <i class="fa fa-file-image-o" aria-hidden="true"></i></a>
    				</td>
    			</tr>
    			<%} %>
    		</tbody>
    		</table>
		</div>
		</div>
		</section>
		</div>
		</div>


		
	<%}
	  else
	  {
	  %>    
	  	<h1> Il catalogo è attualmente vuoto!</h1>
	  
	  <%} %>
<%} %>

<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/alertAutoClose.js"></script>
</body>
</html>