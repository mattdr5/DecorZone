<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import=" it.unisa.model.beans.Prodotto,  it.unisa.model.beans.Utente" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Modifica prodotto | DecorZone</title>
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
	<section id="modificaProdotto">
	<div class="container mt-2 mb-5">
	<%
      	String mex = (String) session.getAttribute("mexModifica");

      		if(mex!=null)
      		{
      			%>
      				<div class="alert alert-success animated fadeIn fadeOut " role="alert">
      					<%= mex %>
    				</div>
      			<%
      			session.removeAttribute("mexModifica");
      		}
      	%>
		<div class="card">
  		<div class="card-body">
    		 <form action="modifica" onsubmit="return validaModificaProdotto();" method="POST">

        <div class="row">
				
				<div class="col-lg-12">
				<!--  Nome -->
				<div class="form-group">
				 <label for="nomeProd"> Nome prodotto:</label>
					<input type ="text" class="form-control" value="<%=prodotto.getNomeProdotto()%>" id="nomeProd" placeholder="Inserisci nome prodotto..." name="nomeProd"/>
					<small>Error message</small>
				</div>
				</div>
			</div>
				
				<!-- Descrizione -->
				<div class="form-group">
				 <label for="descrProd"> Descrizione:</label>
					<textarea style="height: 100px; resize: none;" id="descrProd" class="form-control" placeholder="Inserisci descrizione..." name="descriz"><%=prodotto.getDescrizioneProdotto() %></textarea>
					<small>Error message</small>
				</div>
				
				
				<div class="row">
				<div class="col-lg-6">
				<!-- Prezzo-->
				<div class="form-group">
				 <label for="prezzoProd"> Prezzo prodotto: </label>
					<input type="text" id="prezzoProd" value="<%= prodotto.getPrezzoProdotto()%>" class="form-control" placeholder="Inserisci prezzo( Formato Esempio 10.90 o 10)" name="prezzoProd"/>
					<small>Error message</small>
				</div>
				
				</div>
				<div class="col-lg-6">
				<!-- Categoria-->
				<div class="form-group">
				 <label for="select-categoria-mod" > Categoria:</label>
				 	<input type="hidden" id="idCat" value="<%=prodotto.getCategoriaProdotto().getIdCategoria()%>"/>
					<select id="select-categoria-mod" class="form-control" name="categoria">
					</select>
				</div>
				
				</div>			
				</div>
				
				
				<div class="row">
				<div class="col-lg-6">
					
				<!-- Quantita-->
				<div class="form-group">
				 <label for="qtaDisp"> Quantita disponibile:</label>
					<input type="number" id="qtaDisp" value="<%= prodotto.getQuantitaDisponibile() %>" class="form-control" placeholder="Inserisci quantita disponibile" name="qtaDisp"/>
					<small>Error message</small>
				</div>
				
				</div>
				<div class="col-lg-6">
				<!--IVA-->
				<div class="form-group">
				 <label for="ivaProd"> Iva:</label>
					<input type="number" id="ivaProd" value="<%=prodotto.getIVAProdotto() %>" class="form-control" placeholder="Inserisci iva" name="ivaProd"/>
					<small>Error message</small>
				</div>
				
				</div>
				</div>
				
				<div class="row">
				<div class="col-lg-6">
					
				<!-- Quantita-->
				<div class="form-group">
				 <label for="colore"> Colore:</label>
					<input type="text" id="colore" value="<%=prodotto.getColoreProdotto() %>" class="form-control" placeholder="Inserisci colore.." name="colore"/>
					<small>Error message</small>
				</div>
				
				</div>
				<div class="col-lg-6">
				<!--IVA-->
				<div class="form-group">
				 <label for="dimensione"> Dimensione:</label>
					<input type="text" value="<%=prodotto.getDimensioneProdotto() %>" id="dimensione" class="form-control" placeholder="Inserisci dimensione.." name="dimensione"/>
					<small>Error message</small>
				</div>
				
				</div>
				</div>
				<input type="hidden" value="<%= prodotto.getIdProdotto() %>" name="id">
		
				<div class="container text-center">
						
						<input type="submit"  class="btn btn-primary" value="Modifica"/>
					</div>
		 </form>
      
  		</div>
 
 		
		</div>
	
     
</div>
  
 <%} 
 }%>
 </section>


<script src="js/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 <script src="js/alertAutoClose.js"></script>
<script src="js/formValidationAdmin.js"></script>
<script src="js/formCategoria.js"></script>
</body>
</html>