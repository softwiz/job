
function goRegistForm(code) {
	$('#maincode').val(code);
	$('#f').attr('action', '../admin/categoryview.html');
	$('#f').submit();
}

function goDeleteForm(code) {
	jQuery("#confirm-msg").text($('#message_alert_delete').val());
	jQuery("#dialog-confirm").dialog({
		buttons: {
			"OK": function() {
				$('#maincode').val(code);
				$('#f').attr('action', '../admin/categorydelete.html');
				$('#f').submit();
				jQuery( this ).dialog( "close" );
			},

			"CANCEL": function() {
				jQuery( this ).dialog( "close" );

			}
		}

	});

}
