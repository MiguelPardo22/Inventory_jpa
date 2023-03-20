// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()




var myInput = document.getElementsByTagName('iden')[0];

myInput.addEventListener("keyup", function(e) {

  var key = e.keyCode || e.charCode;
  
  // si la tecla es un cero y el primer carácter es un cero
  if (key == 48 && this.value[0] == "0") {
    // se eliminan los ceros delanteros
    this.value = this.value.replace(/^0+/, '');
  }
  
});
		  
		  