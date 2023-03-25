
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


function ValidarCampos(){

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
	
	
	
if($("#Asu").val() == ''){
		
	 	  Swal.fire({
  icon: 'warning',
  title: 'Oops...',
  text: 'DEBE DIGITAR UN ASUNTO!',
  background:'#191919',
  confirmButtonColor:'#ecab0f',
  color:'white'

});
 return 0;
	}


}


