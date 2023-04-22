/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(user, status){
			$('#idEdit').val(user.id);
			$('#usernameEdit').val(user.fullName);
			$('#emailEdit').val(user.email);
			$('#passwordEdit').val(user.password);
			$('#roleEdit').val(user.role);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});