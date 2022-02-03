<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import=" it.unisa.model.beans.DettaglioOrdine, it.unisa.model.utils.Carrello , it.unisa.model.beans.Utente, java.util.ArrayList" 
    pageEncoding="ISO-8859-1"%>
    
    <% Utente utente  = (Utente) session.getAttribute("utente");
    	if(utente!= null){
    		

  %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Checkout | DecorZone </title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/responsive.css">
</head>
<body>
<%
		Carrello carrello = (Carrello) request.getAttribute("carrello");
%>
<jsp:include page="header.jsp"></jsp:include>

<h1 class="text-center">Checkout</h1>
<hr>

  <!--Section: Block Content-->
    <section class="form-checkout">
      <div class="container">
      <!--Grid row-->
      <div class="row">

        <!--Grid column-->
        <div class="col-lg-8 mb-4">

          <!-- Card -->
          <div class="card wish-list pb-1">
            <div class="card-body">


    		<!-- Email -->
          <form id="formCheckout" action="checkout" onsubmit="return validaCheckout();" method="POST">
              <div class="form-group md-form md-outline mt-">
                    <label for="email">Email</label>
                      <input type="email"  id="email" value="<%= utente.getEmailUtente() %>" class="form-control" readonly>
              <small>Error message</small>
              </div>


              <!-- email -->
              <div class="row">

                <!-- Grid column -->
                <div class="col-lg-6 col-md-6 col-sm-12 col-6">

                  <!-- First name -->
                  <div class="form-group md-form md-outline mb-0 mb-lg-4">

                   <label for="firstName">Nome</label>
                    <input type="text"  id="firstName" value="<%=utente.getNomeUtente() %>" class="form-control mb-0 mb-lg-2" readonly>
                    <small>Error message</small>
                  </div>
                  </div>

                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-lg-6 col-md-6 col-sm-12 col-6">

                  <!-- Last name -->
                  <div class="form-group md-form md-outline">
                  <label for="lastName">Cognome</label>
                    <input type="text"  id="lastName" value="<%=utente.getCognomeUtente() %>" class="form-control" readonly>
                    <small>Error message</small>
                  </div>

                </div>
                <!-- Grid column -->

              </div>
              <!-- Grid row -->


              <!-- Address  -->
			<div class="card p-3">
				<h5 class="text-center"> Dettagli spedizione:</h5>
              <div class="form-group md-outline mt-0">
              <label for="indirizzo">Indirizzo</label>
                <input type="text" name="indirizzo" id="indirizzo" placeholder="Inserisci indirizzo.. Esempio: Via/Piazza/Vicolo, Numero civico" class="form-control">
              <small>Error message</small>
        	   </div>

            <div class="row">
              <!-- CAP -->
                <div class="col-lg-6 col-md-6 col-sm-12 col-12">
               <div class="form-group md-form md-outline">
                 <label for="citta">Citta</label>
                   <input type="text" name="citta" placeholder="Inserisci la tua citta.." id="citta" class="form-control">
              <small>Error message</small>

               </div>
              </div>

                <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                <!--  Citta -->
                <div class="form-group md-form md-outline">
                  <label for="cap">CAP</label>
                    <input type="text" name="cap" placeholder="Inserisci CAP.." id="cap" class="form-control">
                    <small>Error message</small>

                  </div>

              </div>
              </div>
               <!-- Phone -->
              <div class="form-group md-form md-outline">
              <label for="numTelCheckout">Telefono</label>
                <input type="text" id="numTelCheckout" value="<%=utente.getNumeroTelefonoUtente() %>" class="form-control">
                <small>Error message</small>
             </div>
              
			</div>
             <!-- Address  -->
			<div class="card mt-1 p-3">
				<h5 class="text-center"> Modalità pagamento:</h5>
					<!-- Phone -->
              <div class="form-group md-form md-outline">
              <label for="numCarta">Numero carta di credito:</label>
                <input type="text" id="numCarta" class="form-control" name="numCarta">
                <small>Error message</small>
             </div>
			</div>


     		</form>
            </div>
            
            
          </div>
          
            
				
			</div>
          <!-- Card -->
	
 
        <!--Grid column-->

		 <!--Grid column-->
        <div class="col-lg-4">

          <!-- Card -->
          <div class="card mb-4">
            <div class="card-body">

              <h5 class="mb-3">Totale</h5>

              <ul class="list-group list-group-flush">
                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                  Subtotale
                  <span>&euro; <%= String.format("%.2f", carrello.calcolaTotaleCarrello()) %></span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                  Spedizione
                  <span>Gratis</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                  <div>
                    <strong>Totale</strong>

                      <p class="mb-0"><strong>(IVA inclusa)</strong></p>

                  </div>
                  <span><strong>&euro; <%= String.format("%.2f", carrello.calcolaTotaleCarrello()) %></strong></span>
                </li>
              </ul>

              <input type="submit"  class="my-btn " form="formCheckout" value="Acquista"/>

            </div>
          </div>
          <!-- Card -->
      

        </div>
        <!--Grid column-->

      </div>
      <!--Grid row-->

    </div>
    </section>
    <!--Section: Block Content-->


<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/formValidation.js"></script>

</body>
</html>
<% } 
else
{
response.sendRedirect(this.getServletContext().getContextPath()+"/login");

}
%>
