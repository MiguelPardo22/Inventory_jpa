$(document).ready(function() {
	$('#myTable').DataTable({
		ajax: {
			url: 'http://localhost:8090/inventario'
		},
		columns: [
			{ data: "id_inventario" },
			{ data: "exis" },
			{ data: "id_prod_fk.nom" },
		]
		
		 });

});


