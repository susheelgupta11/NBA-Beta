		<%-- for saving ckeditor data --%>
    <g:hiddenField name="ckeditorData" id="ckData"/>

<style>
.add_mor{
    background: #367fa9;
    color: #fff;
    padding: 4px 12px;
    display: inline-block;
    border-radius: 4px;
    border: none;
    text-align: center;
    text-decoration: none;
    font-size: 12px;
    margin: 4px 2px;
    cursor: pointer;
    }
</style>



<div class="uplod">
	<div class="col-sm-7 form-group">
		<span class="col-sm-3"><b>Upload File/Files </b></span>
<table>
  <tr>
    <th><div class="input_fields_wrap"><input type="button"  class="add_mor" id="chgName" Value="Click here"/></div>
<%--				<div>--%>
<%--					<input type="file" name="files[]" id="subfile" class="input-xlarge" onchange="ValidateSingleInput(this);" />--%>
<%--				</div>--%>
			
			</th>
   
  </tr>
  <tr>
    <td><span style="color: red" id="errorMsg" ></span></td>
   
  </tr>
</table>   
</div>


	<div class="col-sm-7 form-group">
		<span class="col-sm-3"><b>Status Update </b></span>
		<div class="col-sm-6">
			<g:select class="form-control" name="statusUpdate"
				from="${dropDnValues?.statusList}"
				value="${addNoteInstance?.statusUpdate}"
				noSelection="['':'-Update Status-']" required="required" />

		</div>
	</div>
	<div class="col-sm-4 form-group">
		<span class="col-sm-4"><b>Priority </b></span>
		<div class="col-sm-8">
			<g:select class="form-control" name="priorities"
				from="${dropDnValues?.priorityList}"
				value="${addNoteInstance?.priorities}"
				noSelection="['':'-select Priority-']" />

		</div>
	</div>
	<div class="col-sm-7 form-group">
		<span class="col-sm-3"><b>Actions </b></span>
		<div class="col-sm-6">
			<g:select name="actions" class="form-control"
				from="${dropDnValues?.actionList}"
				value="${addNoteInstance?.actions}"
				noSelection="['':'-Choose Action-']" required="required" />

		</div>
	</div>
<%--	value="${addNoteInstance?.forwardMember}"	--%>
	<div class="col-sm-7 form-group">
		<span class="col-sm-3"><b>Forward to</b></span>
		<div class="col-sm-6">

			<g:select name="forwardMember" class="form-control"
				from="${dropDnValues?.forwordUsrList}" optionKey="id" optionValue="${{it.name +' '+ "[" +it?.nbaRole?.authority +"]"}}"
			value="${addNoteInstance?.forwardMember}"
				noSelection="['':'-Choose Action-']"  required="required" />
		</div>
	</div>

	<div class="col-sm-12 form-group">
		<g:link value="Cancel" class="btn btn-primary pull-right"
			style="margin-left: 10px;" action="cancelRequest"
			controller="checklist">cancel</g:link>

		<input type="submit" name="Send" value="Send" 
			class="btn btn-primary pull-right" />
	</div>
	<g:hiddenField name="applicationNumber" value="${applicationNum}" />
	<g:hiddenField name="applicationSubmitDate" value="${submittedDate}" />

</div>