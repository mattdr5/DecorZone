<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="it.unisa.model.beans.Ordine, it.unisa.model.beans.Utente, java.util.ArrayList" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordini | Decorzone</title>
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
	ArrayList<Ordine> listaOrdini = (ArrayList<Ordine>) request.getAttribute("ordini");
	if(listaOrdini == null)
	{
		response.sendError(404);
	}
	else
	{
	
%>
<div class="page-wrap d-flex flex-row " style="min-height: 80vh;">

<div class="container">
   <!-- Section heading -->
    <h1 class="text-center">Ordini </h1>

 <%if (listaOrdini != null &&  !listaOrdini.isEmpty()) 
	{
		%>


  <!--Section: Content-->
  <section class="dark-grey-text text-center mb-5">


 <!--  filter for date -->
 <form id="formFilterDate" action="ordiniadmin" method="get">
 <div class="row d-flex align-items-center justify-content-center">
    <div class="col-lg-5 col-md-5 col-sm-5">
    <div class="form-group">
 <label> Da data:</label>
 <input type="date" name="data1" max="3000-12-31" 
        min="1000-01-01" class="form-control">
</div>
</div>
<div class="col-lg-5 col-md-5 col-sm-5">
<div class="form-group">
 <label >Fino a data:</label>
 <input type="date" name="data2" min="1000-01-01"
        max="3000-12-31" class="form-control">
</div>
</div>
<div class="col-lg-1 col-md-1 col-sm-1">
 <div class="container text-center">
         <button type="submit" class="btn btn-primary">Filtra</button>
 </div>
 </div>
 </div>
 </form>
  <!-- Fine filter for date -->

    
        <!-- Table -->
    <div class="card" style= "margin-top:20px;">
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
              <strong>Data</strong>
              </th>
              <th>
              <strong>Indirizzo spedizione</strong>
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
             <td> <strong> <%= ord.getIdOrdine() %> </strong></td>
             <td> <%= ord.getEmail() %> </td>
             <td> <%= ord.getDataOrdine() %> </td>
              <td> <%= ord.getIndirizzoSpedizione() %></td>
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
	<!-- Order empty -->
             <div class="page-wrap d-flex flex-row align-items-center" style="min-height: 80vh;">
               <div class="container">
                     <div class="row justify-content-center">
                          <div class="col-md-12 text-center">
                           <!--  filter for date -->
								 <form id="formFilterDate" action="ordiniadmin" method="get">
								 <div class="row">
								    <div class="col">
								    <div class="form-group">
								 <label> Da data:</label>
								 <input type="date" name="data1" max="3000-12-31" 
								        min="1000-01-01" class="form-control">
								</div>
								</div>
								<div class="col">
								<div class="form-group">
								 <label >Fino a data:</label>
								 <input type="date" name="data2" min="1000-01-01"
								        max="3000-12-31" class="form-control">
								</div>
								</div>
								 <div class="container text-center">
								         <button type="submit" class="btn btn-primary">Filtra</button>
								 </div>
								 </div>
								 </form>
								 <!-- Fine filter for date -->
                           <h1> Non sono presenti ordini tra queste date </h1><span> <img class="img-responsive" style="width:320px;" src="imgs/utils/ordini_empty.png" style=""alt="No oreder"> </span>
                       </div>
                   </div>
               </div>
               </div>
            <!-- Fine Order empty -->
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