<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="it.unisa.model.beans.DettaglioOrdine,   java.util.ArrayList"
    pageEncoding="ISO-8859-1"%>
    
    <% ArrayList<DettaglioOrdine> dettaglio = (ArrayList<DettaglioOrdine>) request.getAttribute("prodotti");
if(dettaglio == null)
{
	response.sendError(404);
}
else
{
	int numOrdine = (Integer) request.getAttribute("idOrder");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Dettagli ordine #<%=numOrdine %> | DecorZone</title>
</head>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

 <div class="page-wrap d-flex flex-row " style="min-height: 80vh;">

<div class="container">

  <%if (dettaglio != null &&  !dettaglio.isEmpty()) 
	{
		%>
		
  <!--Section: Content-->
  <section class="dark-grey-text text-center">
      <h1>Ordine #<%= numOrdine %></h1>
	<div class="container mb-2">

    
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
          <% for(DettaglioOrdine prodotto : dettaglio )
       		{
       			
       %>
            <tbody>
            <tr>
            <td> <a href="dettagliprodotto?id=<%=prodotto.getProdottoAssociato().getIdProdotto()%>"><%= prodotto.getProdottoAssociato().getNomeProdotto()%></a></td>
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


</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<%} %>
<jsp:include page="components/common-script.jsp"></jsp:include>
</body>
</html>