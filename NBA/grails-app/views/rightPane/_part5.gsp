<table class="table table-bordered datatable">
<tr class="previewheading">
				<td class="text-center one"><b></b></td>
				<td colspan="4"><b>Declaration:</b></td>
			</tr>
			
		<g:if test="${appForm?.isDeclarationDigitallySigned == 'true' }">
			<tr>
			<td></td>
			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration with digital signature</td>
			</tr>
		</g:if>
		<g:else>	
			<tr>
			<td></td>
			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration without digital signature</td>
			</tr>
		</g:else>	
			
			<tr>
			<td></td>
			
			<td colspan="4"><h4>I / we declare that :- </h4></td>
			
		
			
			</tr>
			
			<tr>
			<td>
			</td>
			<td colspan="4">
				<ul>
									<li><b>Collection of proposed biological resources shall not
										adversely affect the sustainability of the resources.</b></li>
									<li><b>Collection of proposed biological resources shall not
										entail any environmental impact.</b></li>
									<li><b>Collection of proposed biological resources shall not
										pose any risk to ecosystems.</b></li>
									<li><b>Collection of proposed biological resources shall not
										adversely affect the local communities.</b>
								</li></ul>
			</td>
			</tr>
			
		<g:if test= "${appForm?.submitCheck == true }">
			<tr>
			<td></td>
			<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:if>
		<g:else>
			<tr>
			<td></td>
			<td class="one text-center"><input type="checkbox"  disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:else>	
	</table>
				  <table class="table table-bordered datatable">
					<tr class="previewheading">

						<td colspan="5"><b>Payment Details:</b></td>
					</tr>
					<tr>
						<td class= "text-center one">(a)</td>
						<td colspan="2">Transaction Id</td>
						<td class="one"><b>:</b></td>
						<td>
							${formDetails?.transaction?.transactionId}
						</td>
					</tr>
					<tr>
						<td class= "text-center one">(b)</td>
						<td colspan="2">Payment Reference Number</td>
						<td class="one"><b>:</b></td>
						<td>
							${formDetails?.transaction?.paymentRefNo}
						</td>
					</tr>
					<tr>
						<td class= "text-center one">(c)</td>
						<td colspan="2">Payment Amount</td>
						<td class="one"><b>:</b></td>
						<td>
						<g:if test="${formDetails?.transaction?.fee >9000 }">Rs. 10,000/-</g:if>
						<g:else>Rs. 5,000/-</g:else>
							
						</td>
					</tr>
					
					<tr>
						<td class= "text-center one">(d)</td>
						<td colspan="2">Payment Receipt</td>
						<td class="one"><b>:</b></td>
						<td><g:link controller="applicationManagement" action="showIndividualDc"
										id="${formDetails?.transaction?.id}" target="_blank"
										params='[filename: "paymentReceipt", dataName: "paymentReceipt", formDetailsId: formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										Click to preview Payment Receipt
									</g:link></td>
					</tr>
					</table>
			