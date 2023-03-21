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
			 $('#idcatEdit').val(product.id_cat_fk.id_cat);
			 $('#idmedEdit').val(product.id_med_fk.id_med);
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
	  
	  
	 /*Funcion de datatable*/	  
	  

$(document).ready( function () {
    $('#myTable').DataTable({
    
    language: {
                "lengthMenu": "Mostrar _MENU_ registros",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sSearch": "Buscar:",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast":"Último",
                    "sNext":"Siguiente",
                    "sPrevious": "Anterior"
			     },
			     "sProcessing":"Procesando...",
            },
    
    responsive: "true",
        dom: 'Bfrtilp',       
        buttons:[ 
			{
				extend:    'excelHtml5',
				text:      '<i class="fas fa-file-excel"></i> ',
				titleAttr: 'Exportar a Excel',
				className: 'btn btn-success'
			},
			{
				extend:    'pdfHtml5',
				text:      '<i class="fas fa-file-pdf"></i> ',
				exportOptions: {
					columns: [0, 1, 2, 3, 4, 5, 6, 7, 8] //Columnas a exportar
				},
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger',
			},
		]	    
    });
} );
	  
	  
	  
	  