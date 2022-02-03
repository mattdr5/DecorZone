<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- START HEADER -->
<nav id="myheader" class="navbar navbar-expand-lg">
  <div class="mylogo">
	<h1 id="my-text-logo"><a href="index"> DecorZone</a></h1>
			
	</div>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="my-toggler"><i class="fa fa-bars" aria-hidden="true"></i></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mynavbar-center">
     <li class="myli"><a class="mynav-link" href="dashboard"> Dashboard</a></li>
			<li class="myli">
				<a class="mynav-link" href="utentiAdmin">Visualizza utenti</a>
			 </li>
			 <li class="myli">
				<a class="mynav-link" href="ordiniadmin">Visualizza ordini</a>
				</li>
				<li class="myli">
				<a class="mynav-link" href="catalogoAdmin">Visualizza prodotti</a>
				</li>
    </ul>

    <ul class="navbar-nav ml-auto mynavbar-right mr-5">
    
    		
			   <li class="myli dropwdown">
			     <li class="nav-item myli dropdown ">
        			<a class="mynav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          				<i class="fa fa-user-circle-o" style="margin-right: 2px;"aria-hidden="true"></i>		
  				</a>
				<div class="dropdown-menu" aria-labelledby="dropdownLogButton">
   					<a class="dropdown-item" href="ilmioaccount"> Il mio profilo</a>
  				</div>
  				</li>
  				 <li class="myli">
  				 	<a class="mynav-link" href="logout">Logout </a>
  				 </li>
		
			
			
			
		</ul>	
  </div>	


</nav>
