/*
const url = "/PurchaseOrderCrear/save";
const url2 = "/PurchaseOrderGuardar/guardar";
var resultado = 0;

$(document).ready(function() {
	$("#iniciar").on("click", function() {

		//actualizar();
		bucle();
	});
});



/*function actualizar() {
	
    datos2 = "_csrf=" + crsfValue + "&Fecha=&id_supplier_fk=1&Subtot=100&total=200";
    alert(datos2);
	$.ajax({

		type: "POST",
		data: datos2,
		url: url2,
		success: function(res) {
			alert("RESPUESTA: " + res);
		}

	}).done(function(response){
	 
	 alert("@#@#@#@#@") + response;
	  bucle();
	
	});

}


function bucle() {

	cantidad = $("#numeroFor").val();
	//datos = $("#id_form").serialize();  
	var fecha = $("#fecha").val();
	var id_orden_compra = $("#id_orden_compra").val();


	for (let step = 1; step <= cantidad; step++) {

		//if(cantidad > 1 && step == 1){ 


		var id_prod_fk = $("#id_prod_fk" + step).val();
		var can = $("#can" + step).val();
		var subtot = $("#Subtot" + step).val();

		datos = "_csrf=" + crsfValue + "&id=" + id_orden_compra + "&Fecha=" + fecha + "&Can=" + can + "&id_prod_fk=" + id_prod_fk + "&SubTot=" + subtot + "&Total=1000"
		alert(datos);
		$.ajax({

			type: "POST",
			data: datos,
			url: url,
			success: function(res) {
				alert("RESPUESTA: " + res);
			}

		});
		//}	
	}
}
*/


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

	if($("#Cant").val() == ''){
	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UNA CANTIDAD!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});/*sucesss*/
	  return 0;
	} 
	 
	$("#GuardarOri").trigger('click');
}
	  
	  
	  
function validarRango(elemento){
  var numero = parseInt(elemento.value,10);
  //Validamos que se haya ingresado solo numeros
  if(isNaN(numero)){
    alert('Ingrese solo números.');
    elemento.focus();
    elemento.select();
    return false;
  }
  //Validamos que se cumpla el rango
  if(numero<1 || numero>9){
   	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR DENTRO DEL RANGO 1-9!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});/*sucesss*/
	  return 0;
  }
 
}
	  
	  