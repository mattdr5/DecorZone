
$(document).ready(function(){
	$(".search-btn").on("click", function(){
	
		
		
		let searchInput = $(".search-txt").val();
		if(searchInput ==="" || searchInput === undefined)
		{
			$(".search-txt").toggle("slow");
		}
		else
		{
			 $("#myform").submit(); 
		}
		
	});

});