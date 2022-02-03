

$(document).ready(function(){
	
	getConsigliatiDalDb();
		
});


function getConsigliatiDalDb(){
	$.get("consigli", function(responseJson) {   
		let div = $("#consigli-prod");
        $.each(responseJson, function(index, item) { 
 
           div.append(creaTemplate(item));
        });
       
    });
};


function creaTemplate(item)
{
	
	return `<div class="col-lg-4 col-md-4 col-sm-4 col-12 product-grid">
	    	<div class="image">
        		<a href="dettagliprodotto?id=${item.idProdotto}">
          			<img src="imgs/prodotti/${item.srcImgProdotto}" alt="image" class="w-100">
       			</a>
      		</div>
      		<h5 class="text-center">${item.nomeProdotto}</h5>
       		<h5 class="text-center">${item.prezzoProdotto} &euro;</h5>  
      		<a class="btn buy" href="dettagliprodotto?id=${item.idProdotto}">Vedi prodotto</a>
      
    	</div>` ;

}










