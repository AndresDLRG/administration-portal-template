
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript" src="${contextPath}/resources/js/example.js"></script>

<br />
<div class="container">
	<div id="mainDiv">
		<button id="newButton" class="btn btn-info">Nuevo ejemplo</button>
		<br />
		<br />
		<table id="example" class="table table-striped table-hover">
			<thead>
				<tr>
					<th><spring:message code="example.table.column.id" /></th>
					<th><spring:message code="example.table.column.somestring" /></th>
					<th><spring:message code="example.table.column.startdate" /></th>
					<th><spring:message code="common.table.column.edit" /></th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="saveDiv" style="display: none">
		updateDiv
		<form id="saveForm">
			<div class="form-group">
				<label for="someString">Alguna cadena</label> <input id="s_someString" class="form-control" />
			</div>
			<div class="form-group">
				<label for="startDate">Fecha inicio</label> <input id="s_startDate" class="form-control" type="date" />
			</div>
			<button id="cancelSaveButton" class="btn btn-danger">Cancelar</button>
			<button id="saveButton" class="btn btn-info">Guardar</button>
		</form>
	</div>

	<div id="updateDiv" style="display: none">
		<form id="updateForm">
			<input id="u_id" type="hidden">
			<div class="form-group">
				<label for="u_someString">Alguna cadena</label> <input id="u_someString" class="form-control" />
			</div>
			<div class="form-group">
				<label for="u_startDate">Fecha inicio</label> <input id="u_startDate" class="form-control" type="date" />
			</div>
			<button id="cancelUpdateButton" class="btn btn-danger">Cancelar</button>
			<button id="updateButton" class="btn btn-info">Actualizar</button>
		</form>
	</div>

</div>

