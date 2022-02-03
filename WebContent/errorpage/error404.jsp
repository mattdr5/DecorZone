<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   isErrorPage = "true" pageEncoding="ISO-8859-1"%>
   
   <% response.setStatus(404);  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>404 Page not found</title>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>

	<div class="page-wrap d-flex flex-row align-items-center" style="min-height: 80vh;">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
            	<span> <img src="./imgs/utils/not_found.png" class="img-responsive w-50 mb-3" alt="NotFOUND"> </span>
                <div class="mb-4 lead">La pagina non esiste!</div>
                <a href="index" class="btn btn-link">Torna alla home</a>
            	</div>
        	</div>
    	</div>
	</div>
	

</body>

</html>