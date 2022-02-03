

$(document).ready( function(){
	
	getCategorieDalDb();
	
});	

function getCategorieDalDb(){
		$.get("allcategoriedropdown", function(responseJson) {   

			 let select = $("#select-categoria, #select-categoria-mod");
	        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
	           let idCat = item.idCategoria;
	           let nomeCat = item.nomeCategoria;
	           
	           select.append('<option value='+ idCat+ '>' +nomeCat+ '</option>');
	           let idCatMod = $("#idCat").val();
	           if( (idCatMod != null && idCatMod != undefined) )
	        	{
	        	   $('#select-categoria-mod option[value='+idCatMod+']').prop('selected',true);
	        	}
	        });
	       
	    });
};
