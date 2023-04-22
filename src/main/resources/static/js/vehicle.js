/**
 * 
 */

$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicle, status) {
			var acDate = vehicle.acquisitionDate.substr(0, 10);
			$('#txtAcquisitionDateEdit').val(acDate);
			$('#txtDescriptionEdit').val(vehicle.description);
			$('#ddlEmployeeEdit').val(vehicle.employeeid);
			$('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#txtIdEdit').val(vehicle.id);
			$('#ddlLocationEdit').val(vehicle.locationid);
			$('#txtNameEdit').val(vehicle.name);
			$('#txtNetWeightEdit').val(vehicle.netWeight);
			$('#txtPowerEdit').val(vehicle.power);
			var regDate = vehicle.registrationDate.substr(0, 10);
			$('#txtRegistrationDateEdit').val(regDate);
			$('#txtRemarksEdit').val(vehicle.remarks);
			$('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
			$('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
			$('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);
			$('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicle, status) {
			$('#acquisitionDateDetails').val(vehicle.acquisitionDate);
			$('#descriptionDetails').val(vehicle.description);
			$('#employeeDetails').val(vehicle.employeeid);
			$('#fuelCapacityDetails').val(vehicle.fuelCapacity);
			$('#idDetails').val(vehicle.id);
			$('#locationDetails').val(vehicle.locationid);
			$('#nameDetails').val(vehicle.name);
			$('#netWeightDetails').val(vehicle.netWeight);
			$('#powerDetails').val(vehicle.power);
			$('#registrationDateDetails').val(vehicle.registrationDate);
			$('#remarksDetails').val(vehicle.remarks);
			$('#vehicleMakeDetails').val(vehicle.vehiclemakeid);
			$('#vehicleModelDetails').val(vehicle.vehiclemodelid);
			$('#vehicleNumberDetails').val(vehicle.vehicleNumber);
			$('#vehicleStatusDetails').val(vehicle.vehiclestatusid);
			$('#vehicleTypeDetails').val(vehicle.vehicletypeid);
			$('#createdByDetails').val(vehicle.createdBy);
			$('#createdDateDetails').val(vehicle.createdDate.substr(0, 19).replace("T", " "));
			$('#lastModifiedByDetails').val(vehicle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicle.lastModifiedDate.substr(0, 19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});

	$('.table #photoButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #vehiclePhoto').attr('src', href);
		$('#photoModal').modal();
	});
});