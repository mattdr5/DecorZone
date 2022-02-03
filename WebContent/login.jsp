<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login | DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<% 
	
	 //Controllo se l'utente è già loggato 
	 if(session.getAttribute("utente") == null)
	{
			
		
%>
<jsp:include page="header.jsp"></jsp:include>
	
	
	  <!--- Login --->
    <section id="mylogin">
    <div class="container d-flex align-items-center justify-content-center">
      <div class="row mt-5 mb-5">
        <div class="col-lg-12 col-md-12 col-sm-12">
          <div class="card ">
            <div class="card-header text-black">
              <h2 class="text-center"> Login</h2>

            </div>
            <div class="card-body">
            	<% String messaggioLogin = (String) session.getAttribute("messaggioLogin");
            		String messaggioPass = (String) request.getAttribute("messaggioPassw");	
            	if(messaggioLogin!=null)
            	{
            	%>
            		<div class="alert alert-danger text-center">
  						<strong><%= messaggioLogin%></strong><br>
					</div>
					
            	<% session.removeAttribute("messaggioLogin"); 
            	} 
            	if(messaggioPass !=null)
            	{%>
            		<div class="alert alert-success text-center">
  						<strong><%= messaggioPass%></strong><br>
					</div>
            	<%request.removeAttribute("messaggioPassw");
            	}
            	
            	%>
              <form id="formLogin" action="loginutente" onsubmit="return validaLogin();" method="post">
                <div class="form-group">
                  <label>Email</label>
                  <input type="text" placeholder="Inserisci email..." name="email" class="form-control" id="emailLogin">
                  <small>Error message</small>
                </div>
                <div class="form-group">
                  <label>Password</label>
                  <input type="password" placeholder="Inserisci password..." name="password" class="form-control" id="passwordLogin">
                  <small>Error message</small>
                </div>
                <a class="text-center d-block mb-2 p-3" href="registrati">Non sei registrato? Cosa aspetti a farlo?</a>
                <div class="container text-center">
                    <button type="submit" class="my-btn">Login</button>
                </div>

              </form>
            </div>
      
          </div>

        </div>

      </div>

    </div>
    </section>
    <!---END LOGIN --->
<jsp:include page="footer.jsp"></jsp:include>
<%}
	else
	{
		response.sendRedirect(this.getServletContext().getContextPath()+"/index");
	}
		
		
%>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/formValidation.js"></script>
</body>
</html>