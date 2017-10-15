$(document).ready(function() {
	var security_header = {};
	security_header[_csrf_header] = _csrf;
	
	// Showing the data table
	$('#example').DataTable({
		processing : true,
		serverSide : true,
		colReorder : true,
		language: {
            url: ctx + 'resources/json/datatables_' + _locale + '.json',
        },
		dom : 'lfrtBip',
		buttons : [ {
			extend : 'colvis',
			text : 'COLUMNS <span class=" glyphicon glyphicon-eye-open" ></span>'
		},{
			extend : 'copy',
			text : 'COPY <span class="glyphicon glyphicon-copy" ></span>'
		}, {
			extend : 'excel',
			text : 'EXCEL  <span class="glyphicon glyphicon-download-alt" ></span>',
			title : 'Examples'
		}, {
			extend : 'csv',
			text : 'CSV  <span class="glyphicon glyphicon-download-alt" ></span>',
			title : 'Examples'
		}, {
			extend : 'pdf',
			text : 'PDF  <span class="glyphicon glyphicon-download-alt" ></span>',
			title : 'Examples'
		} ],
		columns : [ {
			data : 'id',
			searchable : true,
			orderable : true
		}, {
			data : 'someString',
			searchable : true,
			orderable : true
		}, {
			data : 'startDate',
			searchable : true,
			orderable : true,
			render : function(data) {
				return dateAsString(data, false);
			}
		}, {
			data : 'id',
			searchable : false,
			orderable : false,
			render : function(data) {
				return '<button class="btn btn-info" onclick="showEdit(' + data  + ')" >' + data + '</button>';
			}
		} ],
		ajax : {
			url : ctx + 'api/example/paged',
			type : 'POST',
			dataType : 'json',
			processData : false,
			contentType : 'application/json;charset=UTF-8',
			headers : security_header,
			data : function(data) {
				return JSON.stringify(data);
			}
		}
	});
	
	// set common button functionality
	
	$('#newButton').click(function(){
		$('#saveDiv').show();
		$('#mainDiv').hide();
	});
	
	$('#cancelSaveButton').click(function(){
		$('#saveDiv').hide();
		$('#mainDiv').show();
	});
	
	$('#cancelUpdateButton').click(function(){
		$('#updateDiv').hide();
		$('#mainDiv').show();
	});
	
	$('#saveButton').click(function(){
	});
	
	$('#updateButton').click(function(){
	});
	
	
	
});

function showEdit(id){
	$('#updateDiv').show();
	$('#mainDiv').hide();
}
