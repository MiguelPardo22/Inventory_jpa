$('document').ready(function() {
	 
	 $('.table #update').on('click', function(event){
		 
		 event.preventDefault();
		  
		var href= $(this).attr('href');
		 
		 $.get(href, function(measure, status){
			 	 
			 $('#id_medEdit').val(measure.id_med);
			 $('#nomEdit').val(measure.nom);
			 $('#estEdit').val(measure.est);
			 
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