<%! import org.nba.common.Country %>
<g:if test="${listOfIprDetails}">
<table class="table table-bordered datatable">
	<thead>
		<tr>
			<th>S.no.</th>

			<th>Country/Territory name</th>
			<th>Patent Application No.</th>
			<th>Date</th>
			<th>Status</th>
			<th>Patent no. & date if granted</th>
			<th>Specify reason</th>
			<th>Action</th>

		</tr>
	</thead>
	<tbody>
		<%i=1 %>
		<g:each in="${listOfIprDetails}" var="ipr">
			<tr>
				<td scope="row"><%=i%></td>
				<% i++ %>
				<td scope="row">
				${Country.get(ipr?.country)?.country}
				</td>
				<td scope="row">
					${ipr?.patentApplicationNo}
				</td>
				<td scope="row">
					${ipr?.patentApplicationDate?.format('dd/MM/yyyy')}
				</td>
				<td scope="row">
					${ipr?.status}
				</td>
				<td scope="row">
					${ipr?.patentNo} ${ipr?.patentDate?.format('dd/MM/yyyy')}
				</td>
				<td scope="row">
				<g:if test="${ipr?.status?.contains('-')}">
					N/A
				</g:if>
				<g:elseif test= "${!ipr?.status?.contains('-') }">
					${ipr?.reasons}
				</g:elseif>
				<g:else>N/A</g:else>
				</td>
				<td>
				<g:remoteLink controller="form3"
					action="part2" onSuccess="showStatusForForm3Part2(null,'${ipr?.status}')" 
					params='[iprId:ipr?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]' update = "iprDetailForm">
					<img src="../images/edit.png" width="16" height="16" alt="edit"
						title="edit" />
				</g:remoteLink>		
				<g:remoteLink controller="form3" action="deleteIprDetails" update = "updateIprDetails"
					params='[iprId:ipr?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]' onSuccess="form3Part2()">
					<img src="../images/delete.png" width="16" height="16" alt="delete"
						title="delete"/>
				</g:remoteLink>
				</td>

			</tr>
		</g:each>
	</tbody>
</table>
</g:if>