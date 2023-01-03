<g:formRemote name="biologicalResources" class="form-horizontal"
	role="form"
	url="[controller:'applicationManagement',action:'saveEditForm1Part2']"
	update="updateBioResources" onSuccess="ClearAllFields()"
	onComplete="loadPage()">
	<div class="form-title col-sm-12 margin-top">
		<label class="register-heading"> (i) Identification
			(scientific name) of biological resources and its traditional use </label>
	</div>
	<g:each in="${listOfBioResources }" var="bioResource">
	
	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(a) Nature of
				biological resources</label>
			<div class="col-sm-8">${bioResource.nature}</div>
		</div>
	</div>
	
	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(b) Common Name</label>
			<div class="col-sm-8">${bioResource?.commonName }</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(c) Scientific Name</label>
			<div class="col-sm-8">
				${bioResource?.scientificName }</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(d) Part of biological
				resources </label>
			<div class="col-sm-8">
				${bioResource?.biologicalResource }</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(e) Quantity of the
				biological resource </label>
			<div class="col-sm-3">${bioResource?.quantity } &nbsp; ${bioResource?.qtyUnit }</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4" for="email">(g)
				Traditional use, if any</label>
			<div class="col-sm-8">${bioResource?.traditionalUse }</div>
		</div>
	</div>
	</g:each>

	<div class="form-group col-sm-12 text-right"></div>

</g:formRemote>