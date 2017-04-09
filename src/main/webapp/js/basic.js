/**
 * 
 */
$(".requiredSubmitCandidate").on("click", function(e) {
	var chk = false;
	$('.required_entry_candidate').each(function() {
        if ($.trim($(this).val()) == '') {
        	chk = true;
        }
        
    });
	
	if (chk) {
		alert('Please fill out all required fields.');
        e.preventDefault();
	}
	
	
	
});


$(".requiredSubmitEmployer").on("click", function(e) {
	var chk = false;
	$('.required_entry_employer').each(function() {
        if ($.trim($(this).val()) == '') {
        	chk = true;
        }
        
    });
	
	if (chk) {
		alert('Please fill out all required fields.');
        e.preventDefault();
	}
	
	
	
});


$(".requiredSubmitLogin").on("click", function(e) {
	var chk = false;
	$('.required_entry_Login').each(function() {
        if ($.trim($(this).val()) == '') {
        	chk = true;
        }
        
    });
	
	if (chk) {
		alert('Please fill out all required fields.');
        e.preventDefault();
	}
	
	
	
});
