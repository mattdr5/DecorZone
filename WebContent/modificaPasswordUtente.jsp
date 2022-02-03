<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 import="it.unisa.model.beans.Utente"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
</head>
<body>

<% Utente user = (Utente) session.getAttribute("utente"); 
if(user == null)
{
	response.sendRedirect("login.jsp");
}  %>  

    <!-- Modal -->
    <div class="modal fade" id="modificaPasswordUtente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-md modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Modifica la tua password</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">

            <form id="modificaPasswordUtente" onsubmit="return validaModificaPasswordUtente();" action="modificapassword" method="POST">

              <div class="form-group md-outline mt-0">
                <label for="passwordUtente1">Inserisci nuova password</label>
                <input type="password" id="passwordUtente1" name="password1" placeholder="Inserisci password(Minimo 8 caratteri)" class="form-control">
                <small>Error message</small>
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