

$(document).ready(function(){
	$(".alert").fadeTo(5000, 0).fadeOut(2000, function(){
	    $(this).remove(); 
	});
});
