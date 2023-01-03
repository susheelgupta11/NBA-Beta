
<div class="col-sm-12 form-group">
	<table class="not-com" style="margin-left: 10px;">
		<tbody>
			<tr>
				<td style="width: 100%;"><input name="comments" type="text"
					placeholder="	Note/Comments" readonly="readonly"></td>
			</tr>
			<tr>
				<td><div class="adjoined-bottom">
						<div class="grid-container">
							<div class="grid-width-100">
								<div id="editor"></div>
							</div>
						</div>
					</div></td>
				<td style="display: inline-block;"><table class="template">
						<tbody>
							<tr>
								<td><input name="comments" type="text"
									placeholder="Templates" readonly="readonly"></td>
							</tr>
						</tbody>
					</table>
					<div class="main-tbs">
						<button class="tablink1" onclick="openPage1('Home1', this, 'red')"
							id="defaultOpen1">Quries</button>
						<button class="tablink1"
							onclick="openPage1('News1', this, 'green')">Note</button>
						<div class="note-tbs-cont">
							<div id="Home1" class="tabcontent1">
								<table class="table table-bordered customtable not-custom">
									<tr>
										<td><g:each in="${dropDnValues?.quriesTabList}" var="noteTb"
																	status="i">
																	<span> <g:checkBox name="noteTab${i+1}"
																			value="${noteTb}" id="note${i+1}"
																			class="territories ctrl1" onclick="getAllValue(this)"
																			checked="false" /> ${noteTb}

																		</span>
																	</g:each> </td>
                              <td><a style="margin-left: 150px;"onclick="syncValue(this)">Copy</a></td>
																	
								</table>
							</div>
							<div id="News1" class="tabcontent1">
								<table class="table table-bordered customtable not-custom">
									<tr>
										<td><g:each in="${dropDnValues?.noteTabList}" var="noteTb"
																	status="i">
																	<span> <g:checkBox name="noteTab${i+1}"
																			value="${noteTb}" id="note${i+1}"
																			class="territories ctrl1" onclick="getAllValue(this)"
																			checked="false" /> ${noteTb}

																		</span>
																	</g:each> </td>
                              <td><a style="margin-left: 150px;"onclick="syncValue(this)">Copy</a></td>
																	
									</tr>
								</table>
							</div>
						</div>
					</div></td>
			</tr>
		</tbody>
	</table>
</div>