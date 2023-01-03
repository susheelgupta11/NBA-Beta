<%--<g:hiddenField name="ckeditorData" id="ckData" value="" />--%>
<style>
 .tabcontent1, .table{height: 250px; overflow-y: scroll;}
</style>

<button class="tablink1" onclick="openPage1('Home1', this, 'red')"
	id="defaultOpen1">Note</button>
<button class="tablink1" onclick="openPage1('News1', this, 'green')">Draft</button>
<button class="tablink1" onclick="openPage1('Sumb1', this, 'green')">Submission</button>
<button class="tablink1" onclick="openPage1('Queries', this, 'green')">Queries</button>
<div class="note-tbs-cont" >
	<div id="Home1" class="tabcontent1">
		<table class="table table-bordered customtable not-custom" id="example">
			<tr>
				<td><g:each in="${dropDnValues?.noteTabList}" var="noteTb"
						status="i">
						<span> <g:checkBox name="noteTab${i+1}" value="${noteTb}"
								id="note${i+1}" class="territories ctrl1"
								onclick="getAllValue(this)" checked="false" /> ${noteTb}

						</span>
					</g:each>
					</td>
					
<%--				<td><a style="margin-left: 150px;" onclick="syncValue(this)">Copy</a></td>--%>
			</tr>
		</table>
<%--		<div class="pagination">--%>
<%--    <util:remotePaginate total="${dropDnValues?.noteTabList?.size()}" update="filteredList" controller="dashboard"  action="filter" max="7" />--%>
<%--         </div>--%>
	</div>
	<div id="News1" class="tabcontent1">
		<table class="table table-bordered customtable not-custom" >
			<tr>
				<td><g:each in="${dropDnValues?.draftTabList}" var="drftTb"
						status="i">
						<span> <g:checkBox name="draftNote${i+1}" value="${drftTb}"
								id="draft${i+1}" class="territories ctrl1"
								onclick="getAllValue(this)" checked="false" />
							${drftTb}</span>
					</g:each></td>
<%--				<td><a style="margin-left: 150px;" onclick="syncValue(this)">Copy</a></td>--%>
			</tr>
		</table>
	</div>

	<div id="Sumb1" class="tabcontent1">
		<table class="table table-bordered customtable not-custom">
			<tr>
				<td><g:each in="${dropDnValues?.submissionTabList}"
						var="submissTb" status="i">
						<span> <g:checkBox name="submissionTab${i+1}"
								value="${submissTb}" id="submission${i+1}"
								class="territories ctrl1" onclick="getAllValue(this)"
								checked="false" />
							${submissTb}</span>
					</g:each></td>
<%--				<td><a style="margin-left: 150px;" onclick="syncValue(this)">Copy</a></td>--%>
			</tr>
		</table>
	</div>
	
	<div id="Home1" class="tabcontent1">
		<table class="table table-bordered customtable not-custom">
			<tr>
				<td><g:each in="${dropDnValues?.quriesTabList}" var="quriesTb"
						status="i">
						<span> <g:checkBox name="quriesTb${i+1}"
								value="${quriesTb}" id="qurie${i+1}" class="territories ctrl1"
								onclick="getAllValue(this)" checked="false" /> ${quriesTb}

						</span>
					</g:each></td>
<%--				<td><a style="margin-left: 150px;" onclick="syncValue(this)">Copy</a></td>--%>

			</tr>
		</table>
	</div>
		
	<button type="button" class="btn btn-outline-dark"  onclick="syncValue(this)" style="width: 100%">Copy</button>
</div>
