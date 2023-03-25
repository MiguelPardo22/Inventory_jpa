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
	 
	 
	 
function validarNumero(value) {
   var valor = $(value).val();
    if (!isNaN(valor) && valor >= 0){
      $(value).val(valor);
    }else{
      $(value).val(0);
    }
}
	  
	 
	 
	 
	 
	  function ValidarCampos(){

	if($("#Nit").val() == ''){
	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN NIT!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});/*sucesss*/
	  return 0;
	}
	if($("#nom").val() == ''){
	  	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN NOMBRE!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'
  

});
 return 0;
	}else{var textotelefono = document.getElementById("Nit").value;
    var numerocaracterestextotelefono = textotelefono .length;

    if (numerocaracterestextotelefono < 10) {
        Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR 10 DIGITOS EN EL NIT!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});
       return 0;
    }
	
	
	}
	
	
	
	if($("#Dir").val() == ''){
		
	 	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UNA DIRECCION!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});
 return 0;
	}
	if($("#Tel").val() == ''){
	 	 	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN TELEFONO!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});


/*sucesss*/
	  return 0;
	  
	  }else{var textotelefono = document.getElementById("Tel").value;
    var numerocaracterestextotelefono = textotelefono .length;

    if (numerocaracterestextotelefono < 10) {
        Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR 10 DIGITOS EN EL TELEFONO!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});
       return 0;
    }
   
	  
	  
	}  
	  
	if($("#Mail").val() == ''){
	 	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN MAIL!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});;
	 return 0;}else{
	var emailField = document.getElementById('Mail');
	
	// Define our regular expression.
	var validEmail =  /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/;

	// Using test we can check if the text match the pattern
	if(!validEmail.test(emailField.value)){
	 Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN MAIL CORRECTO!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});
return false;	
		    
	}
	}

	 
	$("#GuardarOri").trigger('click');
}










