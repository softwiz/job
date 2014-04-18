jQuery(function() {
	$( "#f" ).validate({
	  rules: {
		  subname: {
		      required: true,
		      minlength: 1, maxlength:50
	      },
	      subvalue: {
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
		  form.attr('disabled','disabled');
		  form.submit();
	  }

	});

});
