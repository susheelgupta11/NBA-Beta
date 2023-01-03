<button class="tablink1" onclick="openPage1('Home1', this, 'red')"
	id="defaultOpen1">Queries</button>
<button class="tablink1" onclick="openPage1('News1', this, 'green')">Note</button>

<div class="note-tbs-cont">
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
				<td><a style="margin-left: 150px;" onclick="syncValue(this)">Copy</a></td>

			</tr>
		</table>
	</div>
	<div id="News1" class="tabcontent1">
		<table class="table table-bordered customtable not-custom">
			<tr>
				<td><g:each in="${dropDnValues?.noteTabList}" var="noteTb"
						status="j">
						<span> <g:checkBox name="noteTab${j+1}" value="${noteTb}"
								id="note${j+1}" class="territories ctrl1"
								onclick="getAllValue(this)" checked="false" /> ${noteTb}

						</span>
					</g:each></td>
				<td><a style="margin-left: 150px;" onclick="syncValue(this)">Copy</a></td>
			</tr>
		</table>
	</div>
</div>
