$('.product-grid.hidden').fadeIn("5000").removeClass('hidden');
$('.categoria-grid.hidden').slideDown("8000").removeClass('hidden');
$("document").ready(function(){
	

	$('.product-grid .image img').hover(
			
	//Piccola animazione quando passo sopra col mouse
	function(){
		$(this).animate({
			marginTop:"-=1%"},
			200);
		},
	
	
	//piccola animazione qunado levo il mouse
	function(){
		$(this).animate({
			marginTop: "0%"},
			100);
		}
		
	);
	
	$('.categoria-grid .image-category img').hover(
			
			//Piccola animazione quando passo sopra col mouse
			function(){
				$(this).animate({
					marginTop:"-=1%"},
					200);
				},
			
			
			//piccola animazione qunado levo il mouse
			function(){
				$(this).animate({
					marginTop: "0%"},
					100);
				}
				
			);
});




