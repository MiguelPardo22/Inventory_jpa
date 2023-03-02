
$(document).ready(function(){
	
	$('#selectAll').click(function(){
		
		$(".BtnAll").prop('checked', $(this).prop('checked'))
		$(".BtnMeseros").prop('checked', $(this).prop('checked'))
		$(".BtnBodegueros").prop('checked', $(this).prop('checked'))
		$(".BtnAdmin").prop('checked', $(this).prop('checked'))
		
	});
	
	$('#selectMeseros').click(function(){
		
		$(".BtnMeseros").prop('checked', $(this).prop('checked'))
		
	});
	
	$('#selectBodegueros').click(function(){
		
		$(".BtnBodegueros").prop('checked', $(this).prop('checked'))
		
	});
	
	$('#selectAdmin').click(function(){
		
		$(".BtnAdmin").prop('checked', $(this).prop('checked'))
		
	});
	
});
