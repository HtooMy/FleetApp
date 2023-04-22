/**
 * 
 */

$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idEdit').val(vehicleHire.id);
			$('#ddlClientEdit').val(vehicleHire.clientid);			
			
			var dateIn = vehicleHire.dateIn.substr(0,10);
			var dateOut = vehicleHire.dateOut.substr(0,10);
			$('#dateInEdit').val(dateIn);
			$('#dateOutEdit').val(dateOut);
			
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#timeOutEdit').val(vehicleHire.timeOut);
			
			$('#ddlLocationEdit').val(vehicleHire.locationid);
			$('#priceEdit').val(vehicleHire.price);
			$('#remarksEdit').val(vehicleHire.remarks);
			$('#ddlVehicleEdit').val(vehicleHire.vehicleid);			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idDetails').val(vehicleHire.id);
			$('#clientDetails').val(vehicleHire.clientid);
			
			var dateIn = vehicleHire.dateIn.substr(0,10);
			var dateOut = vehicleHire.dateOut.substr(0,10);
			$('#dateInDetails').val(vehicleHire.dateIn);
			$('#dateOutDetails').val(vehicleHire.dateOut);
			$('#locationDetails').val(vehicleHire.locationid);
			$('#priceDetails').val(vehicleHire.price);
			$('#remarksDetails').val(vehicleHire.remarks);
			$('#vehicleDetails').val(vehicleHire.vehicleid);
			$('#createdByDetails').val(vehicleHire.createdBy);
			$('#createdDateDetails').val(vehicleHire.createdDate.substr(0,19).replace("T", " "));
			$('#lastModifiedByDetails').val(vehicleHire.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleHire.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});