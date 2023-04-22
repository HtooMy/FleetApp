/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(supplier, status){
			$('#txtAddressEdit').val(supplier.address);
			$('#txtCityEdit').val(supplier.city);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#txtDetailsEdit').val(supplier.details);
			$('#txtEmailEdit').val(supplier.email);
			$('#txtIdEdit').val(supplier.id);
			$('#txtMobileEdit').val(supplier.mobile);
			$('#txtNameEdit').val(supplier.name);	
			$('#txtPhoneEdit').val(supplier.phone);			
			$('#ddlStateEdit').val(supplier.stateid);	
			$('#txtWebsiteEdit').val(supplier.website);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(supplier, status){
			$('#addressDetails').val(supplier.address);
			$('#cityDetails').val(supplier.city);
			$('#countryDetails').val(supplier.countryid);
			$('#detailDetails').val(supplier.details);
			$('#emailDetails').val(supplier.email);
			$('#idDetails').val(supplier.id);
			$('#mobileDetails').val(supplier.mobile);
			$('#nameDetails').val(supplier.name);	
			$('#phoneDetails').val(supplier.phone);			
			$('#stateDetails').val(supplier.stateid);	
			$('#websiteDetails').val(supplier.website);
			$('#createdByDetails').val(supplier.createdBy);
			$('#createdDateDetails').val(supplier.createdDate.substr(0,19).replace("T", " "));
			$('#lastModifiedByDetails').val(supplier.lastModifiedBy);
			$('#lastModifiedDateDetails').val(cousupplierntry.lastModifiedDate.substr(0,19).replace("T", " "));
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