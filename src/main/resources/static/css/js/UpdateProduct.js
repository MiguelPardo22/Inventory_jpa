$('document').ready(function() {
	 
	 $('.table #update').on('click', function(event){
		 
		 event.preventDefault();
		  
		var href= $(this).attr('href');
		 
		 $.get(href, function(product, status){
			 
			 $('#idprodEdit').val(product.id_prod);
			 $('#refEdit').val(product.ref);
			 $('#nomEdit').val(product.nom);
			 $('#precompEdit').val(product.pre_comp);
			 $('#preventEdit').val(product.pre_vent);
			 $('#impEdit').val(product.imp);
			 $('#idcatEdit').val(product.id_cat_fk.nom);
			 $('#idmedEdit').val(product.id_med_fk.nom);
			 $('#estEdit').val(product.est);
			 
		 });
		 
		 $('#editModal').modal();
		 
	 });
	 
	 $('document').ready(function() { 
	 $('.table #updateButton').on('click', function(event){
		 
		 event.preventDefault();
		  
		 var href = $(this).attr('href');
		 	
		 $('#updateEstModal #delRef').attr('href', href);
		  $('#updateEstModal').modal();
	 });
	    });
	 
	  });