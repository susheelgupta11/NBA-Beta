<html>
<head>
<title>Recommendation</title>

<style>

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>

<table>
						<tbody>
							<tr>
								<td colspan="4" class="text-center"><b><u>Part B: To be checked by the Expert Committee</u></b></td>
							</tr>
							<tr>
								<td><b>13.</b></td>
								<td colspan="2"><b>Whether Traditional Knowledge has
										been used</b></td>
								<td>${agendaInstance?.whetherTraditional}</td>
							</tr>
							<tr>
								<td><b>14.</b></td>
								<td colspan="2"><b>Screening of the bioresources
										species:</b></td>
								<td>${agendaInstance?.screeningBiores}</td>
							</tr>
							<tr>
								<td></td>
								<td><b>(a)</b></td>
								<td><b>Whether Rare/Endemic/Endangered/Threatened</b></td>
								<td>${agendaInstance?.rareEndemic}</td>
							</tr>
							<tr>
								<td></td>
								<td><b>(b)</b></td>
								<td><b>Whether listed under Wildlife Act/CITES/BDA, etc</b></td>
								<td>${agendaInstance?.wildlifeAct}</td>
							</tr>
							<tr>
								<td></td>
								<td><b>(c)</b></td>
								<td><b>Whether restricted/prohibited under EXIM
										policy/DGFT guidelines/rules</b></td>
								<td>${agendaInstance?.restricted}</td>
							</tr>
							<tr>
								<td><b>15.</b></td>
								<td colspan="2"><b>Whether the original file of the
										applicant was placed before the EC </b></td>
								<td>${agendaInstance?.originalFile}</td>
							</tr>
							<tr>
								<td><b>16.</b></td>
								<td colspan="2"><b>Whether the proposal is likely to
										have an adverse impact on environment/sustainability of use/
										livelihoods/ national interest</b></td>
								<td>${agendaInstance?.proposal}</td>
							</tr>
							<tr>
								<td><b>17.</b></td>
								<td colspan="2"><b>Any other item </b></td>
								<td>${agendaInstance?.anyOther}</td>
							</tr>
							<tr>
								<td colspan="6"><b>Recommendations of the Expert
										Committee on ABS (to be incorporated in the prescribed
										agreement format once approved by the Authority):</b><br/>
						
				             ${agendaInstance?.expertView}</td>
							</tr>
						</tbody>
					</table>


</body>

</html>


  
       
       
                    