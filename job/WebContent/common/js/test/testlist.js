
function goRegistForm(code) {
	$('#testno').val(code);
	$('#f').attr('action', '../test/testview.html');
	$('#f').submit();
}

function goDeleteForm(code) {
	jQuery("#confirm-msg").text($('#message_alert_delete').val());
	jQuery("#dialog-confirm").dialog({
		buttons: {
			"OK": function() {
				$('#testno').val(code);
				$('#f').attr('action', '../test/testdelete.html');
				$('#f').submit();
				jQuery( this ).dialog( "close" );
			},

			"CANCEL": function() {
				jQuery( this ).dialog( "close" );

			}
		}

	});

}
