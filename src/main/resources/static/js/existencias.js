$(document).ready(function() {
	$('#myTable').DataTable({

       ajax: {
			url: 'http://localhost:8090/inventario',

		},
		columns: [
			{
                data: "exis",
                render: function(data) {
                    if (data <= 100) {
                        return '<span class="" style="color: red;">'+data+'&nbsp;&nbsp;&nbsp; <a href="/admin/PurchaseOrderWEB" style="color: red" target="_blank">Por favor es necesario comprar aqui</a> </span>';
                    } else {
                        return '<span class="" style="color: green;">'+data+'</span>';
                    }
                }
            },
			{ data: "id_prod_fk.nom" },
			
		],

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
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger'
			},
		]

	});

});




