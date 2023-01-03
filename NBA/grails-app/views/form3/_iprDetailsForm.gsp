<%! import org.nba.common.Country %>

<script>
$(document).ready(function() {
	form3Part2();
		
});
</script>
<g:formRemote name="iprDetails" id="iprDetails" class="form-horizontal" autocomplete="off"
	role="form" url="[controller:'form3',action:'saveIprDetails']"
	update="updateIprDetails" onSuccess="loadPage()">
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">
				(d)</span> <span class="col-sm-10"> Whether IP application filed for
				the present invention</span> </label>
		<div class="col-sm-8">
			<g:if test="${!appForm }">
			<div class="col-sm-2">
				<input type="radio" name="isIPRfiledOutsideIndia" value="Yes" style="float:left"
					onclick="AddValidation_Yes('ipr')"> <span class="leftflot"> Yes</span>
					</div>
									<input type="radio" name="isIPRfiledOutsideIndia" value="No" style="float:left"
					onclick="removeValidation_No('ipr')"><span class="leftflot"> No</span>
								</g:if>
			<g:else>
			
				<g:if test="${appForm?.isIPApplicationFiled == 'true' }">
				<div class="col-sm-2">
					<input type="radio" name="isIPRfiledOutsideIndia" checked="checked" style="float:left"
						value="Yes" onclick="AddValidation_Yes('ipr')"><span class="leftflot"> Yes </span>&nbsp;
						</div>
									</g:if>
									
				<g:else>
				<div class="col-sm-2">
					<input type="radio" name="isIPRfiledOutsideIndia" value="Yes" style="float:left"
						onclick="AddValidation_Yes('ipr')"><span class="leftflot"> Yes </span>
						</div>
									</g:else>

				<g:if test="${appForm?.isIPApplicationFiled == 'false' }">
					<input type="radio" name="isIPRfiledOutsideIndia" checked="checked" style="float:left"
						value="No" onclick="removeValidation_No('ipr')"> <span class="leftflot">No</span> 
									</g:if>
				<g:else>
					<input type="radio" name="isIPRfiledOutsideIndia" value="No" style="float:left"
						onclick="removeValidation_No('ipr')"> <span class="leftflot">No</span>
									</g:else>
			</g:else>

		</div>
	</div>






	<div class="ipr">
		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"> <span class="col-sm-1">
					(i)</span> <span class="col-sm-10"> Name of the country/territory </span>
			</label>
			<div class="col-sm-8">
				<g:select name="country" from="${listOfcountries}" optionKey="id"
					optionValue="country" value="${ipr?.country}"
					class="width  country req ctrl1" noSelection="['':'-Select-']" />
			</div>

		</div>
		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">
					(ii)</span> <span class="col-sm-10"> Patent application number</span> </label>
			<div class="col-sm-3">
				<input type="text" name="patentAppNo" id="patentAppNo"
					value="${ipr?.patentApplicationNo }" class="width req ctrl1">
			</div>
			<label class="control-label col-sm-2"> (iii) Date </label>
			<div class="col-sm-2">
				<input type="text" name="patentAppDate" id="patentAppDate"
					value="${ipr?.patentApplicationDate?.format('dd/MM/yyyy') }"
					class="datePicker width req ctrl1">

			</div>

		</div>

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">
					(iv)</span> <span class="col-sm-10"> Status </span></label>
			<div class="col-sm-8">
				<g:if test="${ipr?.status?.contains('-') }">
					<g:select name="status" from="${listOfStatuses}" onChange="showStatusForForm3Part2(this,null)"
						value="${ipr?.status?.split('-')[0] }"
						class="width  country req ctrl1" noSelection="['':'-Select-']"
						id="statusChange" />
				</g:if>
				<g:else>
					<g:select name="status" from="${listOfStatuses}" onChange="showStatusForForm3Part2(this,null)"
						value="${ipr?.status }" class="width country req ctrl1"
						noSelection="['':'-Select-']" id="statusChange" />
				</g:else>
			</div>
		</div>

		<%--		<div class="col-sm-12 form-group less-padding" id="otherStatus">--%>
		<%----%>
		<%--			<label class="control-label col-sm-4"> <span class="col-sm-1">(v)</span>--%>
		<%--				<span class="col-sm-10"> Please specify </span></label>--%>
		<%--			<div class="col-sm-8">--%>
		<%--				<g:textArea name="reasons" class="width" value="${ipr?.reasons}"--%>
		<%--					rows="3">--%>
		<%--				</g:textArea>--%>
		<%--			</div>--%>
		<%----%>
		<%--		</div>--%>

		<div class="col-sm-12 form-group less-padding" id="patentInfo">

			<label class="control-label col-sm-4"> <span class="col-sm-1">(v)</span>
				<span class="col-sm-10"> Patent number </span></label>
			<div class="col-sm-3">
				<input type="text" name="patentNo" class="width"
					value="${ipr?.patentNo}">
			</div>
			<label class="control-label col-sm-2"> (iv) Date </label>
			<div class="col-sm-2">
				<input type="text" name="patentDate"
					value="${ipr?.patentDate?.format('dd/MM/yyyy')}"
					class="datePicker width ">
			</div>

		</div>
		<div class="col-sm-12 form-group less-padding" id="otherStatus">
			<g:if test="${ipr?.status?.contains('-') }">
				<label class="control-label col-sm-4"> <span
					class="col-sm-1">(v)</span> <span class="col-sm-10"> Please
						specify status</span></label>
				<div class="col-sm-8">
					<g:textArea name="otherStatus" class="width"
						value="${ipr?.status?.split('-')[1]}" rows="3">
					</g:textArea>
				</div>
			</g:if>
			<g:else>
				<label class="control-label col-sm-4"> <span
					class="col-sm-1">(v)</span> <span class="col-sm-10"> Please
						specify status</span></label>
				<div class="col-sm-8">
					<g:textArea name="otherStatus" class="width" value="" rows="3"></g:textArea>
				</div>
			</g:else>
		</div>
		<div class="col-sm-12 form-group less-padding" id="reasons">

			<label class="control-label col-sm-4"> <span class="col-sm-1">(l)</span>
				<span class="col-sm-10"> Please specify reasons </span></label>
			<div class="col-sm-8">
				<g:textArea name="reasons" class="width" value="${ipr?.reasons}"></g:textArea>
			</div>

		</div>

	</div>




	<div class="col-sm-12 form-group less-padding text-right">

		<g:hiddenField name="appFormId" value="${appForm?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<g:hiddenField name="iprId" value="${ipr?.id}" />

		<input type="submit" class="btn btn-primary  btnctrl1" value="Save">
		<input type="button" class="btn btn-primary focusbtn1" id="addMoreIpr" onclick= "addMore()"
			value="Add More">
	</div>


</g:formRemote>