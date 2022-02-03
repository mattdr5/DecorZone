

$(document).ready( function(){
  
	$("#ordCat").on("change", function(){
		ordinaCatalogo();	
	});
	
	    
	
	
});	


function ordinaCatalogo(){
	
	// get inputs
	let parameter = new Object();
	parameter.idCat = $("#idCat").val();
	parameter.ord = $("#ordCat").children("option:selected").val();
	         
        $.ajax({
            url: "ordinacategoria",
            datatype: "text",
            data: { "idCat": parameter.idCat, "order": parameter.ord},		
            aysnc:true,
            success:
            	function(response) { 
            	
   
            	let div = $("#products");
            	div.empty();
       	for (var i=0; i<response.catalogo.length; i++) {            		
       		div.append(creaTemplate(response.catalogo[i]))
           	
       	}
          
         }
        });   
	
};


function creaTemplate(item)
{
	return `<div class="col-lg-4 col-md-6 col-sm-6 col-6 mb-5  p-4 product-grid">
    <div class="image">
    <a href="dettagliprodotto?id=${item.idProdotto}">
      <img src="imgs/prodotti/${item.srcImgProdotto}" class="w-100">
    </a>
  </div>
  <h5 class="text-center">${item.nomeProdotto}</h5>
    <h5 class="text-center"> ${item.prezzoProdotto} &euro;</h5>  
	<a class="btn buy" href="dettagliprodotto?id=${item.idProdotto}"> Vedi prodotto</a>
  
</div>`;
}
