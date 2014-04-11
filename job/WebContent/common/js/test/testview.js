jQuery(function() {
	$( "#f" ).validate({
	  rules: {
		  testname: {
		      required: true,
		      minlength: 1, maxlength:50
	    }
	  },
	  errorElement: "span",
	    errorPlacement: function(error, element) {
	        error.insertAfter(element);
	        error.css("margin", "0 0 0 5px");
	    },
	  submitHandler: function(form) {
		  form.submit();
	  }

	});

});
