let id_prod = [];
let nom = [];

url = "http://localhost:8090/admin/jsonProd";

$(document).ready(function() {
	
	var contadorDetalles = 0;
	
	Product = {
		
		"data": [{
			
			"id_prod": id_prod,
			
			"nom": nom
			
		}]
		
	}
	$("#agregar").click(function() {
		// Crea un nuevo input
		contadorDetalles++;
		
		var newInput = $("<input>").attr({
			type: "number",
			name: 'detalles[' + contadorDetalles + '].cant',
			placeholder: "Ingrese la cantidad",
			max: "9",
			min: "1",
			class: "cantidad"
		});

		var newProd = $("<select>").attr({
			name: 'detalles[' + contadorDetalles + '].id_prod_fk',
			class: "form-select input",
			id: "prod"
		});

		$.ajax({
		
		url: url,
		type: 'GET',
		success: function(Product) {
			
			$.each($(Product.data), function(index, product) {
            newProd.append($("<option>").attr({value: product.id_prod}).text(product.nom));
        });
			
		}
	});
		// Agrega el input al final de un contenedor (por ejemplo, un div)
		$("#contenedor-inputs").append(newInput);
		$("#contenedor-selects").append(newProd);
	});
});

$('document').ready(function() {

	$('.table #update').on('click', function(event) {

		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(order, status) {

			$('#idpedEdit').val(order.id_Ped);
			$('#Name_cliEdit').val(order.name_cli);
			$('#fechaEdit').val(order.fecha);
			$('#id_usu_fkEdit').val(order.id_usu_fk.id_usu);
			$('#id_est_fkEdit').val(order.id_est_fk.id_est);


		});

		$('#editModal').modal();

	});
});
/*Funcion de datatable*/


$(document).ready(function() {
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
				"sLast": "Último",
				"sNext": "Siguiente",
				"sPrevious": "Anterior"
			},
			"sProcessing": "Procesando...",
		},

		responsive: "true",
		dom: 'Bfrtilp',
		buttons: [
			{
				extend: 'excelHtml5',
				text: '<i class="fas fa-file-excel"></i> ',
				titleAttr: 'Exportar a Excel',
				className: 'btn btn-success'
			},
			{
				extend: 'pdfHtml5',
				text: '<i class="fas fa-file-pdf"></i> ',
				exportOptions: {
					columns: [0, 1, 2, 3, 4, 6] //Columnas a exportar
				},
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger'
			},
		]
	});
});


  function ValidarCampos(){

	if($("#Name_cli").val() == ''){
	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN NOMBRE!',
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
  text: 'DEBE DIGITAR UNA CANTIDAD!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'
  

});
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


