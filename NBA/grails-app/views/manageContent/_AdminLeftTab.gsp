
<div class="list-group">
 <% session.setAttribute("csrfPreventionSalt",csrfPreventionSalt) %>
	
		<div class="formheading">
			<a href="#">Manage Content</a>
		</div>
		
<%--<g:link controller="manageContent" action="adminEdits" params='[csrfPreventionSalt:""]' class="list-group-item  menu1 addinactive  active" ><span id="textColor1">About NBA</span></g:link>--%>


<g:form controller="manageContent" action="adminEdits">	
<g:hiddenField value="${csrfPreventionSalt }" name="csrfPreventionSalt" />		
<span id="textColor1" class="list-group-item  menu1 addinactive active" onclick="$(this).closest('form').submit()">About NBA</span>
</g:form>	

<%--<g:link controller="manageContent" action="latestUpdates" params='[csrfPreventionSalt:""]' class="list-group-item  menu2 addinactive  " ><span id="textColor2">Latest Update</span></g:link>--%>

<g:form controller="manageContent" action="latestUpdates">	
<g:hiddenField value="${csrfPreventionSalt }" name="csrfPreventionSalt" />		
<span id="textColor2" class="list-group-item  menu2 addinactive" onclick="$(this).closest('form').submit()">Latest Update</span>
</g:form>	

<%--<g:link controller="manageContent" action="instructionToApplicant" params='[csrfPreventionSalt:""]' class="list-group-item  menu3 addinactive  " ><span id="textColor3">Instructions</span></g:link>--%>

<g:form controller="manageContent" action="instructionToApplicant">	
<g:hiddenField value="${csrfPreventionSalt }" name="csrfPreventionSalt" />		
<span id="textColor3" class="list-group-item  menu3 addinactive" onclick="$(this).closest('form').submit()">Instructions</span>
</g:form>

<%--<g:link controller="manageContent" action="faqs" params='[csrfPreventionSalt:""]' class="list-group-item  menu4 addinactive  " ><span id="textColor4">FAQs</span></g:link>--%>

<g:form controller="manageContent" action="faqs">	
<g:hiddenField value="${csrfPreventionSalt }" name="csrfPreventionSalt" />		
<span id="textColor4" class="list-group-item  menu4 addinactive" onclick="$(this).closest('form').submit()">FAQs</span>
</g:form>

<%--<g:link controller="masterData" action="uploadDocs" params='[csrfPreventionSalt:""]' class="list-group-item  menu5 addinactive  "><span id="textColor5">Manage/ Upload Docs</span></g:link>--%>
		
<g:form controller="masterData" action="uploadDocs">	
<g:hiddenField value="${csrfPreventionSalt }" name="csrfPreventionSalt" />		
<span id="textColor4" class="list-group-item  menu5 addinactive" onclick="$(this).closest('form').submit()">Manage/ Upload Docs</span>
</g:form>		
		

	
</div>