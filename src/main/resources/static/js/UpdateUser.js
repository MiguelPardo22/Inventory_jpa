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
			 $('#idroleEdit').val(user.roles.id_rol.nom);
			 
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
					columns: [0, 1, 2, 3, 4, 5, 6] //Columnas a exportar
				},
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger'
			},
		]	    
    });
} );
	  
$('form').submit(function(e){
    // si la cantidad de checkboxes "chequeados" es cero,
    // entonces se evita que se envíe el formulario y se
    // muestra una alerta al usuario
    if ($('input[type=checkbox]:checked').length === 0) {
        e.preventDefault();
       Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'Debe seleccionar al menos uno!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

})
    }
}); 
	
	
	  
 
$("#bot").onclick(function(event){
        event.preventDefault();
        let form = event.target;

        swal.fire({
            title: '¿Seguro que desea eliminar el registro?',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar',
            confirmButtonText: '¡Si, eliminar!'
        }).then((result) => {
        if (result.value) {
            form.submit();
        }
    });
});