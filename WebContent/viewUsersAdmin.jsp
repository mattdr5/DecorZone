<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="it.unisa.model.beans.Utente, java.util.ArrayList" pageEncoding="ISO-8859-1"%>
<% 
	Utente utenteSession = (Utente) session.getAttribute("utente");
	
	if(utenteSession == null)
	{
		response.sendRedirect(this.getServletContext().getContextPath()+"/login");
	}
	else if(utenteSession!= null && !utenteSession.isRuoloUtente())
	{
		response.sendError(404);
	}
	else
	{
		
	ArrayList<Utente> listaUtenti = (ArrayList<Utente>) request.getAttribute("utenti");
	if(listaUtenti == null)
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
<title>Utenti | Decorzone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>


<div class="page-wrap d-flex flex-row " style="min-height: 80vh;">

<div class="container">
	
    <!-- Section heading -->
    <h1 class="text-center">Utenti</h1>
 <%if (listaUtenti != null &&  !listaUtenti.isEmpty()) 
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
                <strong>Email</strong>
              </th>
              <th>
                <strong>Nome</strong>
              </th>
               <th>
                <strong>Azioni</strong>
              </th>
            </tr>
          </thead>
          <tbody>
              <% for(Utente utente : listaUtenti )
		{
			
%>
          
            <tr>
             <td> <%= utente.getEmailUtente() %> </td>
             <td> <%= utente.getNomeUtente() +" " +utente.getCognomeUtente()%> </td>
              <td> <a href="ordineutente?user=<%=utente.getEmailUtente() %>" class="btn btn-primary">Vedi ordini</a> </td>
          </tbody>
          <%}
%>
	 </table>
	<% }
	else 
	{
	%>
	<!-- User empty -->
             <div class="page-wrap d-flex flex-row align-items-center" style="min-height: 80vh;">
               <div class="container">
                     <div class="row justify-content-center">
                          <div class="col-md-12 text-center">
                           <h1> Non sono presenti utenti registrati al sito </h1><span> <img class="img-responsive" style="width:320px;" src="imgs/utils/ordini_empty.png" style=""alt="No user"> </span>
                       </div>
                   </div>
               </div>
               </div>
            <!-- Fine User empty -->
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