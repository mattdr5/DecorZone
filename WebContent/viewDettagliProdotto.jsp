<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="it.unisa.model.beans.Prodotto" pageEncoding="ISO-8859-1"%>
    
<%
Prodotto prodotto = (Prodotto) request.getAttribute("prodotto");
if(prodotto != null)
{

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
<title><%= prodotto.getNomeProdotto() %> | DecorZone </title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section id="dettagli-prodotto">
  <div class="container mt-2">
  
  <div id="addcart-mex" class="alert alert-success" role="alert" style="display: none;">
   </div>
	<div class="col-lg-12 border p-4 mb-4 mt-4 bg-white">
		<div class="row m-0">
			<div class="col-lg-4 col-md-10 col-sm-12 left-side-product-box pb-3">
				<img id="img-product" src="imgs/prodotti/<%=prodotto.getSrcImgProdotto() %>" class="border p-4">
       			 <small>Passa col mouse sull'immagine per ingrandire</small>
			</div>
			<div class="col-lg-8">
				<div class="right-side-pro-detail border p-3 m-0">
					<div class="row">
						<div class="col-lg-12">
							<p class="m-0 p-0"><%=prodotto.getNomeProdotto() %></p>
						</div>
						<div class="col-lg-12">
							<p class="m-0 p-0 price-pro"><%=String.format("%.2f", prodotto.getPrezzoConIva()) %>&euro;<span id="text-tax"> IVA compresa </span></p>
							<hr class="p-0 m-0">
						</div>
						<div class="col-lg-12 pt-2">
							<h5>Descrizione:</h5>
              <span><%=prodotto.getDescrizioneProdotto() %></span>
                <hr class="m-0 pt-2 mt-2">
            </div>
            <div class="col-lg-12 pt-2">
            <div class="row">

             <div class="col-lg-6 ">
                <h5>Colore: </h5>
                <span><%=prodotto.getColoreProdotto() %></span>
              </div>
              <div class="col-lg-6">
                <h5>Dimensione: </h5>
                <span><%=prodotto.getDimensioneProdotto() %></span>

              </div>
            </div>
            <hr class="m-0 pt-2 mt-2">
          </div>
						<div class="col-lg-12">
							<p class="categoria-section"><strong>Categoria: </strong>
							<a href="categoria?id=<%=prodotto.getCategoriaProdotto().getIdCategoria()%>">
							<%=prodotto.getCategoriaProdotto().getNomeCategoria() %></a></p>
						</div>
						<div class="col-lg-12 mt-3">
							<div class="row">
							<% if(prodotto.getQuantitaDisponibile() == 0)
								{%>
								<div class="col-lg-12 text-center pb-2">
									<p> Prodotto attualmente non disponibile </p>
								</div>
								<%}
							else
							{%>
								<div class="col-lg-12 text-center pb-2">
									<button class="btn addtocart buy w-50" value="<%=prodotto.getIdProdotto() %>">Aggiungi al carrello</button>
								</div>
								
							<%} %>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		</div>
		
</section>


<div id="load-modal" class="modal"><!-- Place at bottom of page --></div>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/plugin/jquery.zoom.js"></script>
<script src="js/imgZoom.js"></script>
<script src="js/addToCart.js"></script>

</body>
</html>
<%
}else
{
	response.sendError(404);
}
%>