<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="it.unisa.model.beans.Utente" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
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
}  %>  

    <!-- Modal -->
    <div class="modal fade" id="modificaDatiUtente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-md modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Modifica i tuoi dati </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">

            <form id="modificadatiutente" onsubmit="return validaModificaDatiUtente();" action="modificainfoutente" method="POST">
              <!--  Nome -->
              <div class="row">
                <div class="col-lg-6">
                  <div class="form-group md-outline mt-0">
                    <label for="nomeUtente">Nome</label>
                    <input type="text" value="<%=user.getNomeUtente() %>" name="nomeUtente" id="nomeUtente" placeholder="" class="form-control">
                    <small>Error message</small>
                  </div>
                </div>

                <div class="col-lg-6">
                  <div class="form-group md-outline mt-0">
                    <label for="cognomeUtente">Cognome</label>
                    <input type="text" value="<%= user.getCognomeUtente() %>" name="cognomeUtente" id="cognomeUtente" placeholder="" class="form-control">
                    <small>Error message</small>
                  </div>

                </div>
              </div>
	
			<div class="col-lg-12">
              <div class="form-group md-outline mt-0">
                <label for="cognomeUtente">Numero di telefono </label>
                <input type="text" name="numTelUtente" value="<%= user.getNumeroTelefonoUtente() %>" id="numTelUtente" placeholder="" class="form-control">
                <small>Error message</small>
              </div>
              </div>
              <div class="container text-center">
                <input type="submit"  class="btn btn-primary" value="Modifica"/>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/formValidation.js"></script>
</body>
</html>