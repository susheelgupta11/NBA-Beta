<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='main' />

<title>NBA</title>
<g:javascript>
 		 var data = "${faqS}"
 </g:javascript>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();

		var html = $(data);
		
		//alert(html)
		$('#faqTable').html(html);
	});
</script>
</head>
<body>
	<div class="col-sm-10 col-sm-offset-1">
		<div class="col-sm-12 ">
		<div class="col-sm-12  text-center form_heading">
			<h3>FAQ</h3>
			</div>
		</div>



		<div class="col-sm-12">
			
				<div class="col-sm-12 main-registeration-form textalign">
				<span class="col-sm-12"><i>
				National Biodiversity Authority provides you with answers to your commonly asked questions about ABS e-Filing and

the process involved in the online submission of ABS Applications. You can either browse through specific sections

below or just type in a keyword related to your question to find an answer.</i>
				</span>
				<div class="col-sm-12" id="faqTable">
				
				
				</div>
				
				
				
				
				
					
					
				</div>
				<div class="col-sm-12 text-center">
				<g:link controller="login" action="auth" class="btn btn-primary" params='[]'>Back</g:link>
				</div>
			
		</div>
	</div>
</body>
</html>