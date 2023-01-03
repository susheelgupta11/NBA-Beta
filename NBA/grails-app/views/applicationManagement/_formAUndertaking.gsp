<%! import org.nba.application.IndianResearcher %>


<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
	action="submitFormAUnderTaking">
	<input type="hidden" name="csrfPreventionSalt"
		value="${csrfPreventionSalt}" />
	

<div class="main-registeration col-sm-12">
	<div class="form-group col-sm-12 ">
<div class="text-center">
<h3>Undertaking</h3>
</div>
<ol style="list-style-type:none" class="text-justify">
	<g:if test= "${appFormId?.conditionOfAbs == true }">
<li> <input type="checkbox" name="conditionOfAbs" checked="true"  class="pull-left" /> &nbsp;<span> I have read and understood the terms and conditions of ABS guidelines and I undertake to abide by 
relevent legal previsions applicable to biological resources  </li>
</g:if>
<g:else>
<li> <input type="checkbox" name="conditionOfAbs" class="pull-left" /> &nbsp;<span> I have read and understood the terms and conditions of ABS guidelines and I undertake to abide by 
relevent legal previsions applicable to biological resources  </li>
</g:else><g:if test= "${appFormId?.approvalOfNba == true }">
<li> <input type="checkbox" name="approvalOfNba" checked="true"  class="pull-left" /> &nbsp;<span> I understood to obtain the approval of the NBA/SBB before making any change in the stated purpose</li>
</g:if>
<g:else>
<li> <input type="checkbox" name="approvalOfNba" class="pull-left" /> &nbsp;<span> I understood to obtain the approval of the NBA/SBB before making any change in the stated purpose</li>
</g:else><g:if test= "${appFormId?.recordsWithTheNba == true }">
<li> <input type="checkbox" name="recordsWithTheNba" checked="true"  class="pull-left" /> &nbsp;<span> I undertake to furnish/share the relevent records with the NBA / SBB, as and when required.</li>
</g:if>
<g:else><li> <input type="checkbox" name="recordsWithTheNba" class="pull-left" /> &nbsp;<span> I undertake to furnish/share the relevent records with the NBA / SBB, as and when required.</li>
</g:else><g:if test= "${appFormId?.infromationTrue == true }">
<li> <input type="checkbox" name="infromationTrue" checked="true"  class="pull-left" /> &nbsp;<span> I further declare that the information provided in the form is true and correct and I shall be liable for any incorrect / wrong 
information and wilfull suppression of the facts.</li>
</g:if><g:else>
<li> <input type="checkbox" name="infromationTrue" class="pull-left" /> &nbsp;<span> I further declare that the information provided in the form is true and correct and I shall be liable for any incorrect / wrong 
information and wilfull suppression of the facts.</li>
</g:else>

</ol>
</div>
		<div class="col-sm-12 text-right top_Pad">
			<g:hiddenField name="formType" value="${formType}" />
			<g:hiddenField name="appFormId" value="${appFormId?.id}" />
			<input type="Submit" class="btn btn-primary  btnctrl" value="Save"></input>
			
		</div>
		</div>
</g:uploadForm>