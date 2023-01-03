<%! import org.nba.application.FormCategory %>

	<table class="table table-bordered">

			<tr class="previewheading">
				<td class="text-center one"><b>2</b></td>
				<td colspan="4"><b>Details and specific information about
						nature of access sought and biological material and associated
						knowledge to be accessed</b></td>
			</tr>

			<tr>
				<td></td>
				<td class="text-center one"><b>(i)</b></td>
				<td colspan="3">Identification (scientific name) of biological
					resources and its traditional use</td>
			</tr>

			
		<g:if test= "${formDetails?.biologicalResources}">	
			<tr>
				<td></td>
				<td></td>
				<td colspan="3">
					<table class="table table-bordered datatable1 wordwrap">
						<thead>
							<tr>
								<th>S.No.</th>
								<th>Intend to access</th>
								<th>Common name</th>
								<th>Scientific name</th>
								<th>Nature of biological resources</th>
								<th>Part of biological resources</th>
								<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
								<th>Quantity of biological resources</th>
								<th>Time span in which the biological</th>
								<th>Traditional use, if any</th>
								</g:if>
							</tr>
						</thead>
						<tbody>
							<%int i=1 %>
							<g:each in="${formDetails?.biologicalResources}" var="bioResource">
								<tr>
									<td class="text-center"><%=i %></td>
									<%i++ %>
									<td>${bioResource?.accessIntention}</td>
									<td>
										${bioResource?.commonName}
									</td>
									<td>
										${bioResource?.scientificName}
									</td>

									<td>
										${bioResource?.nature}
									</td>
									<td>
										${bioResource?.biologicalResource}
									</td>
									<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
									<td>
										${bioResource?.quantity} ${bioResource?.qtyUnit}
									</td>
									<td>
										${bioResource?.fromTime?.format('dd/MM/yyyy')} - ${bioResource?.toTime?.format('dd/MM/yyyy')}
									</td>
									<td>
										${bioResource?.traditionalUse}
									</td>
									</g:if>
								</tr>
							</g:each>
						</tbody>
					</table>
				</td>
			</tr>
		</g:if>	
			<tr>
				<td></td>
				<td class="text-center"><b>(ii)</b></td>
				<td colspan="3">Geographical location of proposed collection</td>
			</tr>
		
		<g:if test="${formDetails?.biologicalResources?.locations}">	
			<tr>
				<td></td>
				<td></td>
				<td colspan="3">
					<table class="table table-bordered datatable1 wordwrap">

						<thead>

							<tr>
								<th>SI.No</th>
								<th>Name of biological resource</th>
								<th>Source of access</th>
								<th>Village / Panchayat</th>
								<th>Town / Taluk</th>
								<th>District</th>
								<th>State</th>
								<th>Name</th>
								<th>Contact Details</th>
							</tr>
						</thead>
						<tbody>
						
								<g:if test="${formDetails?.biologicalResources?.locations}">
										<g:each in="${formDetails?.biologicalResources?.locations}"
											var="giolocation" status="l">
											<g:each in="${giolocation}" var="gioloct" status="m">
												<g:each in="${gioloct}" var="gioloc" status="n">
													<tr>

														<td>
															${l+1}
														</td>
														<td>
														${gioloc?.bioResource?.scientificName?:'NA'}
															
														</td>
														<td>
														${gioloc?.source?:'NA'}	
														</td>
														<td>
														${gioloc?.village?:'NA'}
														</td>
														<td>
															${gioloc?.town?: 'NA'}
														</td>
														<td>
															${gioloc?.district?:'NA'}
														</td>
														<td>
															${gioloc?.state?:'NA'}
														</td>
														<td>
															${gioloc?.traderName?:'NA'}
														</td>
														<td>
															${gioloc?.traderContactDetails?:'NA'}
														</td>
													</tr>
												</g:each>
											</g:each>
										</g:each>
									</g:if>
                       
						</tbody>
					</table>

				</td>

			</tr>
			</g:if>
		</table>
		














