jQuery(function() {
	$( "#f" ).validate({
	  rules: {
		  mainname: {
		      required: true,
		      minlength: 1, maxlength:50
	    },
	 	  etcdesc: {
		      maxlength:150
	    }
	  },
	  errorElement: "span",
	    errorPlacement: function(error, element) {
	        error.insertAfter(element);
	        error.css("margin", "0 0 0 5px");
	    },
	  submitHandler: function(form) {
		  $( "#f" ).submit();
	  }

	});

});
