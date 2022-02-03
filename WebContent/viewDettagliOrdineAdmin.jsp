<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="it.unisa.model.beans.Ordine, it.unisa.model.beans.Utente, it.unisa.model.beans.DettaglioOrdine" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Dettagli ordine | DecorZone</title>
  <link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/style1.css">
  </head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>


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
	Ordine ordine = (Ordine) request.getAttribute("ordine");
	if(ordine == null || ordine.getDettagliOrdine().isEmpty())
	{
		response.sendError(404);
	}
	else
	{

%>
      <!-- Start  -->
      <!--Section: Content-->
      <section class="dark-grey-text text-center">
       <!-- Section heading -->
    <h1>Dettagli ordine : #<%=ordine.getIdOrdine() %> </h1>
    <h3>Acquirente: <%= ordine.getEmail() %></h3>
    	<div class="container mb-3">


    
        <!-- Table -->
        <div class="card">
          <div class="card-body">
            <table class="table table-responsive-md">
              <thead>
                <tr>
                  <th>
                    <strong>Prodotto</strong>
                  </th>
                  <th>
                    <strong>Quantità Acquistata</strong>
                  </th>
                  <th>
                    <strong>Prezzo Unitario</strong>
                  </th>
                  <th>
                    <strong>IVA</strong>
                  </th>
                  <th>
                    <strong>Sub Totale</strong>
                  </th>
                </tr>
              </thead>
              <% for(DettaglioOrdine prodotto : ordine.getDettagliOrdine() )
              {
                
           %>
                <tbody>
                <tr>
                <td> <%= prodotto.getProdottoAssociato().getNomeProdotto()%></td>
                <td> <%= prodotto.getQuantitaAcquistata()%> </td>
                <td> &euro;<%=String.format("%.2f", prodotto.getPrezzoUnitario())  %> </td>
                <td> <%=String.format("%.0f", prodotto.getIvaDettaglio())  %> %</td>
                <td> &euro;<%= String.format("%.2f", prodotto.getSubtotaleDettOrdine())  %> </td>
      
                </tr>
                </tbody>
                
                <%}
                %>
                   </table>
                  <% }
                    %>
        <!-- Table -->
      </div>
      </div>
      </div>
      </section>
      <!--Section: Content-->


<%}
%>
<jsp:include page="components/common-script.jsp"></jsp:include>
</body>
</html>
