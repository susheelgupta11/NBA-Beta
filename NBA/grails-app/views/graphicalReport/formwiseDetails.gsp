<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
<asset:stylesheet src="cristal/bootstrap.css"/>
<asset:stylesheet src="cristal/style.css"/>
<asset:stylesheet src="cristal/morris.css"/>

<asset:javascript src="cristal/jquery2.0.3.min.js"/>
<asset:javascript src="cristal/modernizr.js"/>
<asset:javascript src="cristal/jquery.cookie.js"/>

<asset:javascript src="cristal/screenfull.js"/>
<asset:javascript src="cristal/skycons.js"/>
<asset:javascript src="cristal/raphael-min.js"/>
<asset:javascript src="cristal/morris.js"/>

</head>
<body>
<script>

		$(function () {
			$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

			if (!screenfull.enabled) {
				return false;
			}

			

			$('#toggle').click(function () {
				screenfull.toggle($('#container')[0]);
			});	
		});
		</script>
 <div class="content-wrapper">
      <div class="col-lg-12">
<div class="">
	<div class="social grid">
					<div class="grid-info">
						<div class="col-md-3 top-comment-grid">
							<div class="comments likes">
								<div class="comments-icon">
									<i class="fa fa-file-o"></i>
								</div>
								<div class="comments-info likes-info">
									<h3>${searchresults?.form1}</h3>
				 <g:remoteLink update="searchresults" value="Form I" params="${[appType:appType] }" url="[controller:'graphicalReport', action:'form1Details']">
             Form I </g:remoteLink>
				              				
									
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="col-md-3 top-comment-grid">
							<div class="comments">
								<div class="comments-icon">
									<i class="fa fa-file-o"></i>
								</div>
								<div class="comments-info">
									<h3>${searchresults?.form2}</h3>
								 <g:remoteLink update="searchresults" value="Form II" params="${[appType:appType] }" url="[controller:'graphicalReport', action:'form2Details']">
                                 Form II</g:remoteLink>
									
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="col-md-3 top-comment-grid">
							<div class="comments tweets">
								<div class="comments-icon">
									<i class="fa fa-file-o"></i>
								</div>
								<div class="comments-info tweets-info">
									<h3>${searchresults?.form3}</h3>
									 <g:remoteLink update="searchresults" value="Form III" params="${[appType:appType] }" url="[controller:'graphicalReport', action:'form3Details']">
                                       Form III  </g:remoteLink>
									
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="col-md-3 top-comment-grid">
							<div class="comments views">
								<div class="comments-icon">
									<i class="fa fa-file-o"></i>
								</div>
								<div class="comments-info views-info">
									<h3>${searchresults?.form4}</h3>
									 <g:remoteLink update="searchresults" value="Form IV" params="${[appType:appType]}" name="abc" url="[controller:'graphicalReport', action:'form4Details']">
                                       Form IV</g:remoteLink>
									
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
			</div>
			
			
					
				
			 <g:render template="searchResults"/>
	</div>
	</div>
	</div>		
	
</body>
</html>