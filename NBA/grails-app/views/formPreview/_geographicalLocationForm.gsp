<g:formRemote name="geoLocation" id="geoLocation"
						class="form-horizontal" role="form"
						url="[controller:'applicationManagement',action:'saveGeoLocation']"
						update="addEditForm1Part2" onSuccess="ClearAllFields()"
						onComplete="loadPage()">

						
					<g:each in = "${listOfLocations }" var= "geoLocation">
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(a) Name of
									biological resource</label>
								<div class="col-sm-8">
									 ${geoLocation?.bioResource?.scientificName}
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(b) Source of
									access </label>
								<div class="col-sm-8">
									${geoLocation?.source}
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(c) Village/Panchayat</label>
							<div class="col-sm-8">
									${geoLocation?.village}
							</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(d) Town/ Taluk</label>
								<div class="col-sm-8">
									${geoLocation?.town }
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(e) District</label>
								<div class="col-sm-8">
									${geoLocation?.district  }
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(f) State / UT</label>
								<div class="col-sm-8">
									${geoLocation?.state  }
								</div>
							</div>
						</div>

						<div class="col-sm-12 cultivate">
							<div class="form-group">
								<label class="control-label col-sm-4">(g) Name</label>
								<div class="col-sm-8">
									${geoLocation?.traderName}
								</div>
							</div>
						</div>

						<div class="col-sm-12 cultivate">
							<div class="form-group">
								<label class="control-label col-sm-4">(h) Contact
									details</label>
								<div class="col-sm-8">
									${geoLocation?.traderContactDetails }
								</div>
							</div>
						</div>
			</g:each>
						

					</g:formRemote>