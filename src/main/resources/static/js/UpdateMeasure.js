$('document').ready(function() {
	 
	 $('.table #update').on('click', function(event){
		 
		 event.preventDefault();
		  
		var href= $(this).attr('href');
		 
		 $.get(href, function(measure, status){
			 	 
			 $('#idmedEdit').val(measure.id_med);
			 $('#NomEdit').val(measure.nom);
			 $('#EstEdit').val(measure.est);
			 
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
				exportOptions: {
					columns: [0, 1, 2] //Columnas a exportar
				},
				text:      '<i class="fas fa-file-pdf"></i> ',
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger',
				customize: function(doc) {
					
					doc.styles.tableHeader = { fillColor: '#ffff00', textColor: '#000', fontSize: 10, bold: true };
					doc.styles.tableBodyEven = { fillColor: '#f5f5f5', textColor: '#000', fontSize: 10 };
					doc.styles.tableBodyOdd = { fillColor: '#fff', textColor: '#000', fontSize: 10 };
					doc.content[1].margin = [0, 0, 0, 0];
					doc.content[1].table.widths = Array(doc.content[1].table.body[0].length + 1).join('*').split('');
					doc.content[1].table.widths[0] = 25;
					doc.content[1].table.headerRows = 1;
				}
			},
		]	    
    });
} );
	  
 
  function ValidarCampos(){

	if($("#Med").val() == ''){
	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UNA MEDIDA!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});/*sucesss*/
	  return 0;
	}

	 
	$("#GuardarOri").trigger('click');
}


 function LETRAS(e){

                tecla = (document.all) ? e.keyCode : e.which;
                //Tecla de retroceso para borrar, siempre la permite
                if (tecla==8){
                  return true;
                }
                  
                // Patron de entrada, en este caso solo acepta numeros
                patron =/[a-z-A-Z. ]/;
                tecla_final = String.fromCharCode(tecla);
                return patron.test(tecla_final);
            }
	  
	  
	  