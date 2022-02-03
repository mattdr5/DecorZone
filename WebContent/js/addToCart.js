

$(document).ready(function(){

//Funzione aggiungi al carrello
	  $(".addtocart").on("click", function(){

		    //Salvo l'id
		      let idProdotto = $(this).val();
		      let countItemInCart = $("#count-cart-item").text();
		      $.ajax({
		    	  	async: true,
	                type: "POST",
	                url: "aggiungialcarrello",                
	                dataType: "text",
	                cache: false,
	                data: {"id" : idProdotto},
		                success:function(response){
		                    if(response){
		                    	$("#addcart-mex").text(response);
		                    	$("#addcart-mex").fadeIn("slow");
		                       
		                        let newCount = parseInt(countItemInCart, 10) + 1;
		                        $("#count-cart-item").text( newCount );
		                        setTimeout(() => {
		                        	$("#addcart-mex").fadeOut(3000);
								}, 1000);
		                        
		                    }
		                
		                }

	            });
		      });
	  
	  

});