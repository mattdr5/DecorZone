<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Contatti | DecorZone</title>
</head>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/responsive.css">
<body>
<jsp:include page="header.jsp"></jsp:include>

  <!-- Section 1 -->
      <section class="form-contact">
        <div class="mycontainer">
          <h1 class="text-primary">Completa il form con il tuoi dati</h1>
          <p>Presto riceverete una risposta dal team DecorZone</p>
        <form>
          <div class="form-group">
            <label for="name">Nome</label>
            <input type="text" placeholder="Inserisci il tuo nome..." name="name" id="name">
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="text" placeholder="Inserisci la tua email..." name="email" id="email">
          </div>
          <div class="form-group">
            <label for="messaggio">Cosa vuoi dirci?</label>
            <textarea name="messaggio" placeholder="Inserisci il tuo messaggio..."  id="messaggio" rows="8" cols="30"></textarea>
            <button type="submit" class="my-btn" name="invia"> Invia </button>

          </div>


        </form>
      </div>

      </section>


      <!-- end section 1 -->


    <!-- Sezione 2 <-->
    <section class="info-contatti">
      <div class="mycontainer">
        <div class="info-box">
          <i class="fa fa-map-marker fa-3x"></i>
          <h3>Dove siamo?</h3>
          <p>Salerno, SA 84121</p>
        </div>
        <div class="info-box">
          <i class="fa fa-phone fa-3x"></i>
          <h3>Numero Telefonico</h3>
          <p>800.97.09.09</p>
        </div>
        <div class="info-box">
          <i class="fa fa-envelope fa-3x" ></i>
          <h3>E-mail</h3>
          <p>DecorZone@gmail.com</p>
        </div>
      </div>
    </section>

    <!-- end sezione2 -->



<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="components/common-script.jsp"></jsp:include>
</body>
</html>