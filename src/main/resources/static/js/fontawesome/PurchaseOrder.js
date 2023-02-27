const url = "/PurchaseOrderCrear";
var resultado = 0;

$(document).ready(function() {
	$("#iniciar").on("click", function(e){
		
		bucle();
		
	});
});

function bucle(){
	
	cantidad = $("#numeroFor").val();
      

		for (let step = 0; step < cantidad; step++) {

            $.ajax({
				
				type:"POST",
				url : url
				
			});
			
		}
}