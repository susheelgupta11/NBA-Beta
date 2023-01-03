
  <g:hiddenField name="ckeditorData" id="ckData"/>
  
	<div class="uplod">
		<div class="col-sm-7 form-group">
			<span class="col-sm-3"><b>Status Update </b></span>
			<div class="col-sm-6">
				<g:select class="form-control" name="statusUpdate"
					from="${dropDnValues?.statusList}"
					value="${addNoteInstance?.statusUpdate}"
					noSelection="['':'-Update Status-']" required="required"/>
			</div>
		</div>
		<div class="col-sm-4 form-group">
			<span class="col-sm-4"><b>Priority </b></span>
			<div class="col-sm-8">
				<g:select class="form-control" name="priorities"
					from="${dropDnValues?.priorityList}"
					value="${addNoteInstance?.priorities}"
					noSelection="['':'-select Priority-']"/>
			</div>
		</div>
		<div class="col-sm-7 form-group">
			<span class="col-sm-3"><b>Actions </b></span>
			<div class="col-sm-6">
				<g:select name="actions" class="form-control"
					from="${dropDnValues?.actionList}"
					value="${addNoteInstance?.actions}"
					noSelection="['':'-Choose Action-']" required="required"/>
			</div>
		</div>
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
			
		<g:submitButton  name="Send" value="Send" onclick="return getData()"
										class="btn btn-primary pull-right" />
		</div>
	</div>




