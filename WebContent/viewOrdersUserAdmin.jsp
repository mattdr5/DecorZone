<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  import="it.unisa.model.beans.Ordine, it.unisa.model.beans.Utente, java.util.ArrayList"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Ordine utente | DecorZone</title>
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
	ArrayList<Ordine> listaOrdini = (ArrayList<Ordine>) request.getAttribute("ordiniUtente");
	Utente user = (Utente) request.getAttribute("user");
	if(listaOrdini == null || user==null)
	{
		response.sendError(404);
	}
	else
	{
	%>	
<div class="page-wrap d-flex flex-row " style="min-height: 80vh;">

<div class="container">
   <!-- Section heading -->
    <h1 class="text-center">Ordini di <%= user.getNomeUtente() +" " +user.getCognomeUtente() %></h1>

 <%if (listaOrdini != null &&  !listaOrdini.isEmpty()) 
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
                <strong>Email Acquirente</strong>
              </th>
              <th>
                <strong>Data ordine</strong>
              </th>
              <th>
                <strong>Totale</strong>
              </th>
               <th>
                <strong>Azioni</strong>
              </th>
            </tr>
          </thead>
          <tbody>
            <%for(Ordine ord : listaOrdini)
            {%>
          
            <tr>
             <td>  <%= ord.getIdOrdine() %> </td>
             <td> <%= ord.getEmail() %> </td>
             <td> <%=ord.getDataOrdine() %> </td>
             <td>  &euro;<%=String.format("%.2f",ord.getTotaleOrdine()) %> </td>
             <td> <a class="btn btn-primary" href="visualizzadettagliordine?id=<%=ord.getIdOrdine() %>">Vedi dettagli</a> </td>
          </tbody>
          <%}
%>
	 </table>
	<% }
	else 
	{
	%>
	<!-- Order User empty -->
             <div class="page-wrap d-flex flex-row align-items-center" style="min-height: 80vh;">
               <div class="container">
                     <div class="row justify-content-center">
                          <div class="col-md-12 text-center">
                           <h1> Non sono presenti ordini di questo utente </h1><span> <img class="img-responsive" style="width:320px;" src="imgs/utils/ordini_empty.png" style=""alt="No oreder"> </span>
                       </div>
                   </div>
               </div>
               </div>
            <!-- Fine Order  User empty -->
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



<%} 
}%>
<jsp:include page="components/common-script.jsp"></jsp:include>
</body>
</html>