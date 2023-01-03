<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='nbaDashboardLayout' />
<title>NBA</title>
</head>
<body>

	<div class="content-wrapper" style="margin-left: 210px;">
		<div class="col-sm-12 paddingleft">
			<g:link action="addNote" class="add_button add-note"
				title="Add field"
				params="${[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}">Add Notes</g:link>
		<div>
				<span><g:if test="${flash.message}">
						<div class="message"  style="display: block;margin-left: 55px;">
							${flash.message}
						</div>
					</g:if> </span>
			</div>
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv"
					style="padding-top: 0px; background-color: #daefda; left: 22px;">
					<div>
						<h4 class="text-center" style="margin-bottom: 0px;">
							<b>Noting</b>
						</h4>
					</div>
					<hr style="margin-top: 10px; border-top: 1px solid;" />

					<ul id="comments-list" class="">
						<li>
							<div class="comment-main-level">
								<g:each in="${viewNoteDetails}" var="noteDetail" status="i">
									<div class="comment-box">
										<div class="comment-head">
											<span>
													<h6><b>${noteDetail?.notedUser}</b></h6>
											</span> 
											<span class="pull-right" style=""> <span> 
											<g:formatDate format="dd-MM-yyyy" date="${noteDetail?.noteDate}"/>
											</span>

											</span> <span class="comment-content" style="width: 100%;"> ${noteDetail?.comments?.toString().replaceAll("\\<.*?>","")}
											</span>
										</div>
									</div>
								</g:each>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="pagination" style="margin-left: 38px;">
				<g:paginate total="${commentCount ?:0}" params="${[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"/>
			   </div>
	</div>
</body>
</html>