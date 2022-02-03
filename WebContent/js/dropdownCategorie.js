

$(document).ready( function(){
     
	getCategorieDalDb();
	
	
});	

function getCategorieDalDb(){
		$.get("allcategoriedropdown", function(responseJson) {   

			 let menu = $("#dropdown-categories");
	        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
	           let idCat = item.idCategoria;
	           let nomeCat = item.nomeCategoria;
	           
	           menu.append('<a class="dropdown-item" href="categoria?id='+ idCat+"\"" +' >' +nomeCat+ '</a>'); 
	           
	        });
	       
	    });
};
 






