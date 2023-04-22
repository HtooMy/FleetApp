$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(admin, status){
			$('#idEdit').val(admin.id);
			$('#nameEdit').val(admin.fullName);
			$('#mobileEdit').val(admin.mobile);
			$('#occupationEdit').val(admin.occupation);
			$('#aboutmeEdit').val(admin.aboutMe);
		});			
		$('#edit-profile').modal();		
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});