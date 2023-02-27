$('document').ready(function() {
	 
	 $('.table #update').on('click', function(event){
		 
		 event.preventDefault();
		  
		var href= $(this).attr('href');
		 
		 $.get(href, function(supplier, status){
			 	 
			 $('#id_ProveedorEdit').val(supplier.id_Proveedor);
			 $('#nitEdit').val(supplier.nit);
			 $('#nomEdit').val(supplier.nom);
			 $('#telEdit').val(supplier.tel);
			 $('#dirEdit').val(supplier.dir);
			 $('#mailEdit').val(supplier.mail);
			 $('#estEdit').val(supplier.est);
			 
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