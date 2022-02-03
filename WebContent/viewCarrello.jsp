<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import=" it.unisa.model.beans.DettaglioOrdine, it.unisa.model.utils.Carrello , java.util.ArrayList" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
<title>Il tuo carrello | DecorZone</title>
</head>
<body>
<jsp:include page="header.jsp" />  
	<%
		Carrello carrello = (Carrello) request.getAttribute("carrello");
		if(carrello.getProdottiCarrello().isEmpty())
		{
	%>
			<!-- Carrello vuoto -->
        	 <div class="page-wrap d-flex flex-row align-items-center" style="min-height: 80vh;">
           	<div class="container">
             		<div class="row justify-content-center">
              			<div class="col-md-12 text-center">
               			<h1> Il tuo carrello è vuoto </h1><span> <img src="imgs/utils/sad-cart2.png" alt="Carrello vuoto"> </span>
              	 			<h4 class="mb-4 lead">Torna alla home per aggiungere nuovi prodotti</h4>
               			<a href="index.jsp" class="btn btn-link">Torna alla home</a>
           			</div>
       			</div>
   			</div>
	   		</div>
			<!-- Fine carrello vuoto -->
	<%	}
		else
		{
			ArrayList<DettaglioOrdine> prodottiInCarrello = carrello.getProdottiCarrello();
		   	
	%>
	  <!-- Start carrello -->
	<section id="carrello">

    <div class="container">
    	<h1 class="text-center"> Il tuo carrello </h1>
      	
      	<%
      	String mex = (String) session.getAttribute("messaggio");

      		if(mex!=null)
      		{
      			if(mex.equals("true"))
      			{%>
      				<div class="alert alert-success" role="alert">
      					Carrello aggiornato con successo!
    				</div>
    				
      			<% 
      			session.removeAttribute("messaggio");
      			}
      			else if(mex.equals("false"))
      			{%>
      			<div class="alert alert-danger" role="alert">
      					Controlla la quantità, è maggiore di ciò che abbiamo a disposizione! 
    			</div>
    			
    			<%
    			session.removeAttribute("messaggio");
    			}
      			else
      			{%>
      				<div class="alert alert-danger" role="alert">
  					Quantità non inseribile!
				</div>
      			<%
      			session.removeAttribute("messaggio");
				}
      			
      		}
      	%>

      <div class="card mt-2 mb-3">
        <div class="card-header bg-dark text-light">
          <a href="index.jsp" class="btn btn-outline-info btn-sm pull-right">Continua shopping</a>
                <div class="clearfix"></div>
        </div>
        <div class="card-body">	
      	<div class="prodotti-in-cart">
        <% for(DettaglioOrdine ordP: prodottiInCarrello) 
   			{ 
   		%>
   		
   			<div class="row">
   			<div class="col-lg-6 col-md-5 col-sm-8 col-7">
   			 <div class="row">
   			 <div class="col-lg-6 col-sm-6 col-md-6 col-12">
   			 	<img class="img-responsive" src="imgs/prodotti/<%=ordP.getProdottoAssociato().getSrcImgProdotto() %>" alt="immagine" width="120px" height="90px">		 
   			 </div>
   			 <div class="col-lg-6 col-sm-6 col-md-6 col-12">
   			 	<h4 class="product-name"><strong><%= ordP.getProdottoAssociato().getNomeProdotto() %></strong></h4>
              <h4>
                <small style="font-size:13px"><strong>Categoria:</strong> <%= ordP.getProdottoAssociato().getCategoriaProdotto().getNomeCategoria() %></small>
              </h4>
   			 </div>
   			 </div>
   			
   			</div>
   			<div class="col-lg-6 col-md-7 col-sm-4 col-5">
   			 <div class="row">
   			 <div class="col-lg-5 col-md-5 col-sm-12  col-12">
   			 <div class=" d-flex flex-column text-center">
   			  <h5 class="p-1" style="color:black;"><strong><%= String.format("%.2f", ordP.getSubtotaleDettOrdine()) %>&euro;</strong></h5>
               <small class=" p-1" style="color:gray;">&euro;<%= String.format("%.2f",ordP.getPrezzoUnitario()) %>&euro;/<%=ordP.getQuantitaAcquistata() %>pezzi </small>
 
   			 </div>
   			 </div>
   			 <div class="col-lg-5 col-md-5 col-sm-8 col-8">
   			 	<div class="quantity">
                 <form id="modificaQuantita" action="modificaquanititacarrello" method="GET" >
                 <input type="number" size="2" onchange="submit(this.form)" value="<%= ordP.getQuantitaAcquistata() %>" name="numProdOrd" min="0"/>
                 
                <input type="hidden" name="id" value="<%=ordP.getProdottoAssociato().getIdProdotto() %>">
                  </form>
                  </div>
   			 
   			 </div>
   			 <div class="col-lg-2 col-md-2 col-sm-4 col-4">
   			 <a href="cancelladacarrello?id=<%=ordP.getProdottoAssociato().getIdProdotto() %>" class="btn btn-outline-danger btn-xs">
                  <i class="fa fa-trash" aria-hidden="true"></i>
                </a>
   			 
   			 </div>
   			 
   			 </div>
   			</div>
   		</div>
         <hr class="mb-2 mt-2">
          <%} %>
          </div>
            
            </div>
 
        <div class="card-footer">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-4">
                  Prezzo totale: <b><%=String.format("%.2f", carrello.calcolaTotaleCarrello()) %>&euro;</b>
            </div>
            <div class="col-md-3 col-sm-3 col-4">
              <a href="svuotacarrello" class="btn btn-primary">Svuota carrello</a>
            </div>
            <div class="col-md-3 col-sm-3 col-4">
              <a href="CarrelloCheckout" class="btn btn-success">Checkout</a>
            </div>
        </div>
      </div>
      </div>
      </div>


  </section>
    <!--- ENND CARRELLO -->


	<%
		}
	%>

<jsp:include page="footer.jsp" /> 
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/alertAutoClose.js"></script>
</body>
</html>