$('document').ready(function() {
	 
	 $('.table #update').on('click', function(event){
		 
		 event.preventDefault();
		  
		var href= $(this).attr('href');
		 
		 $.get(href, function(user, status){
			 
			 $('#idusuEdit').val(user.id_usu);
			 $('#IdenEdit').val(user.iden);
			 $('#NomEdit').val(user.nom);
			 $('#TelEdit').val(user.tel);
			 $('#MailEdit').val(user.mail);
			 $('#ConEdit').val(user.con);
			 $('#EstEdit').val(user.est);
			 $('#idroleEdit').val(user.roles);
			 
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