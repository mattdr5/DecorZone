<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/style1.css">
<title>Registrati su DecorZone</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


      <!-- Section 1 -->
      <section class="form-registrazione">
        <div class="mycontainer">
          <h1 class="text-primary">Registrazione</h1>
          <p>Completa con i tuoi dati:</p>
        <form id="myform-reg" method="POST" onsubmit="return validaRegistrazione();" action="registrazione">
              <div class="row">

                <!-- Grid column -->
                <div class="col-lg-6">
         
          <div class="form-group">
            <label>Nome</label>
            <input type="text" name="name" id="nome" placeholder="Inserisci il tuo nome...">
            <small>Error message</small>
          </div>
          </div>
           <div class="col-lg-6">
          <div class="form-group">
            <label>Cognome</label>
            <input type="text" name="cognome" id="cognome" placeholder="Inserisci il tuo cognome...">
            <small>Error message</small>
          </div>
          </div>
          </div>
           <div class="row">

                <!-- Grid column -->
                <div class="col-lg-6">
          <div class="form-group">
            <label>Email</label>
            <input type="text" name="email" id="email" placeholder="Inserisci la tua email...">
           <small>Error message</small>
          </div>
          </div>
           <!-- Grid column -->
                <div class="col-lg-6">
           <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" id="password" placeholder="Password (Minimo 8 caratteri)">
           <small>Error message</small>
          </div>
          </div>
          </div>
          
          <div class="row">

                <!-- Grid column -->
                <div class="col-lg-6">
          <div class="form-group">
            <label>Numero di telefono</label>
            <input type="text" name="numTel" id="numTel"  placeholder="Inserisci il tuo numero di telefono">
           <small>Error message</small>
          </div>
          </div>
          </div>
          
    
          <div class="form-group">
             <input type="submit"  class="my-btn"  value="Registrati"/>
            </div>
         



        </form>
      </div>

      </section>

<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/formValidation.js"></script>
</body>

</html>