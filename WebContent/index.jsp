<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Homepage | DecorZone</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/responsive.css">


</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section id="carousel-index">
	<div class="container mycontainer">
      <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-12">
          <!--Carousel Wrapper-->
          <div id="carouselPhoto" class="carousel slide carousel-fade" data-ride="carousel">
            <!--Indicators-->
            <ol class="carousel-indicators">
              <li data-target="#carouselPhoto" data-slide-to="0" class="active"></li>
              <li data-target="#carouselPhoto" data-slide-to="1"></li>
              <li data-target="#carouselPhoto" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <div class="view">
                  <img class="d-block w-100" src="imgs/carosello/soggiorno.jpg" alt="First slide">
                  <div class="mask rgba-black-light"></div>
                </div>
                  <div class="carousel-caption">
                    <h3 class="h3-responsive">Soggiorno</h3>
                    <p>Arredamenti per il tuo soggiorno</p>
                  </div>
                </div>
                <div class="carousel-item">
                    <!--Mask color-->
                    <div class="view">
                      <img class="d-block w-100 animated fadeIn" src="imgs/carosello/cucina.jpg" alt="Second slide">
                      <div class="mask rgba-black-strong"></div>
                    </div>
                    <div class="carousel-caption">
                      <h3 class="h3-responsive">Cucina</h3>
                      <p>Arredamenti per la tua cucina</p>
                    </div>
                  </div>
               <div class="carousel-item">
                 <!--Mask color-->
                 <div class="view">
                   <img class="d-block w-100" src="imgs/carosello/cam-letto.jpg" alt="Third slide">
                   <div class="mask rgba-black-slight"></div>
                 </div>
                 <div class="carousel-caption">
                   <h3 class="h3-responsive">Camera da letto</h3>
                   <p>Arredamenti per la tua camera da letto</p>
                 </div>
               </div>
             </div>
             <!--/.Slides-->
             <!--Controls-->
             <a class="carousel-control-prev" href="#carouselPhoto" role="button" data-slide="prev">
               <span class="carousel-control-prev-icon" aria-hidden="true"></span>
               <span class="sr-only">Previous</span>
             </a>
             <a class="carousel-control-next" href="#carouselPhoto" role="button" data-slide="next">
               <span class="carousel-control-next-icon" aria-hidden="true"></span>
               <span class="sr-only">Next</span>
             </a>
             <!--/.Controls-->
           </div>
      </div>
    </div>
  </div>
  <!-- END CAROUSEL WITH PHOTO -->
</section>

<section id="carousel-prodotti">
	 <!--- Start carousel with PRODUCTS -->
    <div class="container consigli">
      <h1 class="header-text text-center">Prodotti consigliati da noi</h1>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                 <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                      <div id="consigli-prod" class="card-deck">
                             
                    </div>
                    </div>
                    </div>
                    </div>
              </div>
      </div>



</section>
<hr class="featurette-divider">
<section id="la-nostra-storia">
	
<!-- Start our history -->
    <div class="container">
      <h1 class="header-text text-center"> La nostra storia </h1>
      <div class="row ">
        <div class="col-lg-6 col-md-6 col-sm-12 mt-5">
          <img src="imgs/utils/aboutus.png" alt="photo" class="d-block w-100">
        </div>
        <div class="col-lg-6 col-md-6 col-sm-12" id="text">
        	<div class="row">
        	<div class="col-lg-12 col-sm-12 col-12 col-md-12">
            <p id="text-history" class="text-justify">
              Salve siamo <strong> Luca Boffa</strong>  e <strong>Matteo Della Rocca</strong>, due studenti di Informatica presso 
              l'Universita di Fisciano, progettiamo siti e-commerce per aziende 
              che vogliono usare bene Internet per fare crescere il loro business. <br>
              	<strong>DecorZone</strong>, il nostro progetto,  nasce nel 2020.
               	E' stato pensato per consigliarvi nella scelta dell'arredamento di qualita per la vostra casa,
               	offrendo una vasta scelta di arredi. Il cliente è al centro del nostro peculiare modello aziendale, 
               	che integra design, fabbricazione, distribuzione e vendita,
                il tutto attraverso un'ampia rete di punti vendita propri.
               
            	</p>
            </div>
            </div>
            </div>
        </div>
      </div>




</section>



<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script src="js/effectOnHover.js"></script>
<script src="js/prodottiConsigliati.js"></script>


</body>
</html>