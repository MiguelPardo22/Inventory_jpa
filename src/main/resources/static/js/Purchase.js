
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
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger'
			},
		]	    
    });
} );
	  
	  
	  
	  
 function ValidarCampos(){	  
	  
	  if($("#Num_fac").val() == ''){
	 	 	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN NUMERO DE FACTURA',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});/*sucesss*/
	  return 0;
	}

	if($("#cant").val() == ''){
	 	 	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UNA CANTIDAD',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});/*sucesss*/
	  return 0;
	}
	$("#GuardarOri").trigger('click');
	
}	  









	  