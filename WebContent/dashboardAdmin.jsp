<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="it.unisa.model.beans.Utente" pageEncoding="ISO-8859-1"%>

<% 


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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Dashboard Admin | DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
	<jsp:include page="headerAdmin.jsp"></jsp:include>
	
	<div class="container">
	<%
      	String mex = (String) session.getAttribute("mexAggiunta");

      		if(mex!=null)
      		{
      			%>
      				<div class="alert alert-success animated fadeIn fadeOut " role="alert">
      					<%= mex %>
    				</div>
      			<%
      			session.removeAttribute("mexAggiunta");
      		}
      	%>
      <div class="row mt-5 ">
        <div class="col-lg-4 col-md-5 col-sm-12" >
          
          <div class="card">
          	<a class="admin-link" href="utentiAdmin">
            <div class="card-body text-center">
              <img style="max-width: 150px" class="img-fluid" src="imgs/utils/utenti.png" alt="utenti">
               <h1  class="text-uppercase"> Utenti </h1>
               <h2> <%= (Integer)request.getAttribute("numUtenti") %> </h2>
            </div>
                  </a>
          </div>
    
       </div>
          <div class="col-lg-4 col-md-5 col-sm-12 catalogo-admin">
            <a class="admin-link" href="catalogoAdmin">
            <div class="card">
              <div class="card-body text-center">
                <img style="max-width: 150px" class="img-fluid" src="imgs/utils/products.png" alt="prodotti">
                 <h1  class="text-uppercase"> Prodotti </h1>
                 <h2><%= (Integer)request.getAttribute("numProd") %></h2>
              </div>

            </div>
            </a>
            </div>
            <div class="col-lg-4 col-md-5 ordini-utente">
              <a class="admin-link" href="ordiniadmin">
              <div class="card">
                <div class="card-body text-center">
                  <img style="max-width: 150px" class="img-fluid" src="imgs/utils/order_editor.png" alt="ordini">
                   <h1  class="text-uppercase"> Ordini </h1>
                   <h2><%= (Integer)request.getAttribute("numOrdini") %></h2>

                </div>

              </div>
              </a>
            </div>
        
        
              <div class="col-lg-12 col-md-5 col-sm-12 aggiungiProd">
               <a class="admin-link" href="#" data-toggle="modal" data-target="#aggiungiProdottoModal">
                <div class="card">
                  <div class="card-body text-center">
                    <img style="max-width: 150px;" class="img-fluid" src="imgs/utils/aggiungiProd.png" alt="aggiungi">
                    
                     <h1 class="text-uppercase"> Aggiungi prodotto </h1>
                     <small> Clicca qui per inserire un nuovo prodotto</small>
                  </div>
				  
                </div>
                </a>
                <jsp:include page="inserisciProdottoAdmin.jsp"></jsp:include>
            </div>
          
          
    </div>
     </div>
       



<%} %>


<script src="js/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 <script src="js/alertAutoClose.js"></script>
<script src="js/formValidationAdmin.js"></script>
<script src="js/formCategoria.js"></script>

</body>

</html>