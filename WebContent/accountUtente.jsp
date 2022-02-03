<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="it.unisa.model.beans.Utente" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Il mio profilo | DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<% Utente user = (Utente) session.getAttribute("utente"); 
if(user == null)
{
	response.sendRedirect(this.getServletContext().getContextPath()+"/login");
}
else
{

if(user.isRuoloUtente())
{%>
<jsp:include page="headerAdmin.jsp"></jsp:include>
<%} 
else if(!user.isRuoloUtente())
{
%>
<jsp:include page="header.jsp"></jsp:include>
<%}
%>

    <!--Section: Block Content-->
    <section class="account-utente">
    <h1 class="text-center mb-3">Il mio profilo</h1>
      <hr>
      <div class="container mt-3 mb-3">
        
      
      <!--Grid row-->
      <% String mex = (String) session.getAttribute("messaggioModifica"); %>
      <%if(mex != null)
    	  {%>
          	<div id="modifiche-mex" class="alert alert-success" role="alert">
          		<%= mex %>
     		</div>
     		
     	<%	session.removeAttribute("messaggioModifica");
    	  }
      	
    	  %>

      <div class="row">
        <div class="col lg-3">
          <div class="card">
            <div class="card-body text-center">
               <h4>  Ciao <%= user.getNomeUtente() %> </h4>
               <small> Benvenuto nella tua pagina personale </small>
            </div>
          </div>
        </div>

        <!--Grid column-->
        <div class="col-lg-9">
              <div class="row">
				

               <div class="col-lg-6 col-md-6">
              
              <a href="#" data-toggle="modal" data-target="#modificaDatiUtente" class="user-link">
              <div class="card">
                <div class="card-body text-center">
                  <img style="max-width: 150px" class="img-fluid" src="imgs/utils/dati-user.png" alt="userDati">
                   <h4 class="text-uppercase"> Modifica i tuoi dati </h4>
                   <small> Modifica il nome, il cognome e il tuo numero di cellulare </small>
                </div>
              </div>
             </a>
              </div>
              <div class="col-lg-6 col-md-6">
                    <a href="modificaCredenziali" class="user-link" data-toggle="modal" data-target="#modificaPasswordUtente" class="user-link">
                      <div class="card">
                        <div class="card-body text-center">
                          <img style="max-width: 150px" class="img-fluid" src="imgs/utils/userInfo.png" alt="userPassword">
                           <h4 class="text-uppercase">  Modifica la tua password </h4>
                           <small> Modifica la tua password </small>
                        </div>
                      </div>
                      </a>
                    </div> 
              </div>
                      <% 
            if(!user.isRuoloUtente())
            {
            %>
                <div class="row mt-2">
                    <div class="col-lg-6 col-md-6">
                    <a href="contatti.jsp" class="user-link">
                      <div class="card">
                        <div class="card-body text-center">
                          <img style="max-width: 150px" class="img-fluid" src="imgs/utils/aiutoUtente.png" alt="userHelp">
                           <h4 class="text-uppercase">  Aiuto </h4>
                           <small> Contattaci per qualsiasi chiarimento. </small>
                        </div>
                      </div>
                      </a>
                    </div>
                    
            
              <div class="col-lg-6 col-md-6">
             
           
  			<a href="imieiordini" class="user-link">
                <div class="card">
                
                  <div class="card-body text-center">
                    <img style="max-width: 150px" class="img-fluid" src="imgs/utils/orderUser.png" alt="orderUser">
                     <h3  class="text-uppercase"> I miei ordini </h3>
                     <small>Visualizza il riepilogo dei tuoi ordini</small>
                  </div>
				 
                </div>
             </a>
               
                </div>
             
                                                      
                </div>
                  <%} %>

            </div>

          </div>
          <!-- Card -->

        </div>
        <!--Grid column-->
    </section>
    <!--Section: Block Content-->

<jsp:include page="modificaDatiUtente.jsp"></jsp:include>
<jsp:include page="modificaPasswordUtente.jsp"></jsp:include>
<%} %>

<%if(!user.isRuoloUtente())
{
%>
<jsp:include page="footer.jsp"></jsp:include>
<%}%>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/alertAutoClose.js"></script>
</body>
</html>