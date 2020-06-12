function eliminar (id){
	swal({
		  title: "¿Seguro quiere eliminar el registro?",
		  text: "El registro se eliminara permanentemente.",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/eliminar/"+id,
				  success: function(res){
					  console.log(res);
				  },
			  });
		    swal("Registro eliminado exitosamene!", {
		      icon: "success",		      
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/index";
		    	}
		    });
		  } else {
		    swal("Ningun registro afectado!");
		  }
		});
}
(function validacion() {
	'use strict';
	window.addEventListener('load',
			function() {
				var forms = document
						.getElementsByClassName('needs-validation');
				var validation = Array.prototype.filter.call(forms,
						function(form) {
							form.addEventListener('submit', function(
									event) {
								if (form.checkValidity() === false) {
									event.preventDefault();
									event.stopPropagation();
								}
								form.classList.add('was-validated');
							}, false);
						});
			}, false);
})();