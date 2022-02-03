<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="it.unisa.model.beans.Utente, it.unisa.model.utils.Carrello" pageEncoding="ISO-8859-1"%>

<% Utente user = (Utente)session.getAttribute("utente");
   Carrello cart = (Carrello) session.getAttribute("carrello");
   if(cart == null)
   {
	   cart = new Carrello();
	   request.setAttribute("carrello", cart);
   }
%>

<nav id="myheader" class="navbar navbar-expand-lg">
  <div class="mylogo">
	<h1 id="my-text-logo"> DecorZone</h1>
			
	</div>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="my-toggler"><i class="fa fa-bars" aria-hidden="true"></i></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mynavbar-center">
      <li class="myli">
        <a class="mynav-link" href="index">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown myli">
        <a class="dropdown-toggle mynav-link" href="#" id="navbarDropdown" role="button"data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categorie
        </a>
        <div id="dropdown-categories" class="dropdown-menu" aria-labelledby="dropdownMenuButton">
   					<a class="dropdown-item" href="categorie"> Tutte le cateogorie</a>
  			</div>
      </li>
      <li class="nav-item myli">
        <a class="mynav-link" href="contatti.jsp">Contatti</a>
      </li>
    </ul>

    <ul class="navbar-nav ml-auto mynavbar-right mr-5">
    
    <li class="nav-item myli">   				
			<div class="mysearch-bar">
				<form id="myform" method="GET" action="risultatiricerca">
   					<input type="text" name="search" class="search-txt" placeholder="Cerca prodotto..."/>
   				</form>
   					<a class="mynav-link search-btn">
    					<i class="fa fa-search" aria-hidden="true"></i>
   					</a>
   		
   			</div>
  	</li>
  			<%if(user == null)
			{
			%>
		<li class="myli"><a class="mynav-link" href="login"> Login</a></li>
			
			<%}
			else
			{
				%>
			   <li class="myli dropwdown">
			     <li class="nav-item myli dropdown ">
        			<a class="mynav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          				<i class="fa fa-user-circle-o" style="margin-right: 2px;"aria-hidden="true"></i>		
  				</a>
				<div class="dropdown-menu" aria-labelledby="dropdownLogButton">
				<%if(user.isRuoloUtente())
					{%>
					<a class="dropdown-item" href="dashboard"> Dashboard</a>
				<%} %>
   					<a class="dropdown-item" href="ilmioaccount"> Il mio profilo</a>
   					<a class="dropdown-item" href="imieiordini"> I miei ordini</a>
   					<a class="dropdown-item" href="logout"> Logout</a>
  				</div>
  				</li>
			<%} %>
			<li class="myli">
				<a class="mynav-link" href="carrello">
					<i class="fa fa-shopping-cart" aria-hidden="true"></i>
					<span id="count-cart-item"><%=cart.calcolaQuantitaProdottiNelCarrello() %></span>
				</a>
			</li>
			
			
			
		</ul>	
  </div>	


</nav>

