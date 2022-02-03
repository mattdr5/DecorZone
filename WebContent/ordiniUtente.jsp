<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="it.unisa.model.beans.Ordine, it.unisa.model.beans.Utente, java.util.ArrayList"
    pageEncoding="ISO-8859-1"%>
  
    
    <% ArrayList<Ordine> ordini = (ArrayList<Ordine>) request.getAttribute("ordini");
		if(ordini == null)
		{
			response.sendError(404);
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>I miei Ordini | DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<%
Utente user = (Utente) session.getAttribute("utente"); 
if(user == null)
{
	response.sendRedirect(this.getServletContext().getContextPath()+"/login");
}
else
{%>
<jsp:include page="header.jsp"></jsp:include>

  <div class="page-wrap d-flex flex-row " style="min-height: 80vh;">

<div class="container">
   <!-- Section heading -->
    <h1 class="text-center">I miei Ordini</h1>
    <hr>
 <%if (ordini != null &&  !ordini.isEmpty()) 
	{
		%>
	


  <!--Section: Content-->
  <section class="dark-grey-text text-center mb-5">

 
    
        <!-- Table -->
    <div class="card">
      <div class="card-body">
        <table class="table table-responsive-md mb-0">
          <thead>
            <tr>
              <th>
                <strong>#Ordine</strong>
              </th>
              <th>
                <strong>Data Ordine</strong>
              </th>
               <th>
                <strong>Indirizzo Spedizione</strong>
              </th>
              <th>
                <strong>Quantità Ordine</strong>
              </th>
              <th>
                <strong>Totale</strong>
              </th>
               <th>
                <strong>Visualizza Fattura</strong>
              </th>
              <th>
                <strong>Dettagli</strong>
              </th>
            </tr>
          </thead>
              <% for(Ordine ordine : ordini )
		{
			
%>
          <tbody>
            <tr>
             <td id="idOrd"> <%= ordine.getIdOrdine() %> </td>
             <td> <%= ordine.getDataOrdine().substring(0, 10) %> </td>
              <td> <%= ordine.getIndirizzoSpedizione() %> </td>
             <td> <%=String.format("%.0f",  ordine.getQuantitaTotaleOrdinata())%></td>
             <td> &euro; <%= String.format("%.2f", ordine.getTotaleOrdine())%></td>
               <td>  <iframe src="fattura?id=<%=ordine.getIdOrdine()%>" style="display: none;" name="frame<%=ordine.getIdOrdine()%>"></iframe>
               <button class="my-btn" onclick="frames['frame<%=ordine.getIdOrdine() %>'].print()" class="download"> <i class="fa fa-download mr-1" style="font-size: 10px" aria-hidden="true"></i>Fattura</button></td>
             <td> <a href="dettaglioordine?id=<%=ordine.getIdOrdine()%>" >Dettagli ordine</a></td>
           </tr>
          </tbody>
          <%}
%>
	 </table>
	<% }
	else 
	{
	%>
	<!-- Ordini empty -->
             <div class="page-wrap d-flex flex-row align-items-center" style="min-height: 80vh;">
               <div class="container">
                     <div class="row justify-content-center">
                          <div class="col-md-12 text-center">
                           <h1> Non hai ancora effettuato ordini </h1><span> <img class="img-responsive" style="width:320px;" src="imgs/utils/ordini_empty.png" style=""alt="Ordini vuoti"> </span>
                               <h4 class="mb-4 lead">Visita il nostro <a href="categorie">catalogo </a> </h4>   
                       </div>
                   </div>
               </div>
               </div>
            <!-- Fine ordini empty -->
	<%
		}
	%>
      </div>
    </div>
    <!-- Table -->

	</section>
  <!--Section: Content-->


</div>

</div>
<%} %>
<jsp:include page="components/common-script.jsp"></jsp:include>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
