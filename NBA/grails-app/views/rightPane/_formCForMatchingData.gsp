<%! import org.nba.common.*%>
<% char alpha = 65 %>
<g:if test="${allDataforMatching?.listOfDepositionOfMicroOrganism.size()>0}">
<g:each in="${allDataforMatching?.listOfDepositionOfMicroOrganism}" var="profile" status="i">
<tr>
	<td></td>
	<td width="35px"><b>(${alpha})</b></td>
	<td colspan="2"><b>Depositor ${i+1}</b></td>
	<td></td>
	
</tr>
<% alpha++%>

<tr>
	<td width="35px"></td>
	<td width="35px" rowspan="3"><b>(i)</b></td>
	<td width="35px"><b>(a)</b></td>
	<td style="width: 50% !important"><b>Name of depositor </b></td>
<%--"grails-app/views/applicationManagement"	<td><b>:</b></td>--%>
	<td class="righttd">${profile?.nameOfDepositor} </td>
</tr>

<tr>
	<td></td>
	<td width="35px"><b>(ii)</b></td>
	<td colspan="2"><b>Complete Address for the communication: </b><br/>
<%--	<td><b>:</b></td>--%>
	${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city}, 
							Pin:${profile?.zip }, ${profile?.state }, ${profile?.country?.country}<br/>
							<span><b>Mobile:</b>${profile?.mobile}</span><br/>
							<span><b>Phone:</b>${profile?.phone}</span><br/>
							<span><b>Email:</b>${profile?.email}</span><br/>
	</td>
</tr>
			<%  char alphaSmall = 97 %>
			<g:each in="${allDataforMatching?.listOfScientistName}" var="scientist" status="j">
				<tr>
					<td></td>
					<td width="35px"></td>
	               <td width="35px"><b>(${alphaSmall })</b></td>
					<td><b>Scientific Name :</b>${j+1}<span style="margin-left: 30px">${scientist?.scientistName}</span></td>
				</tr>
				<%  alphaSmall++ %>
			</g:each>
	</g:each>
	</g:if>


