<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(function() {
		$(".next").click(function() {
			var value;
			$(".radio").each(function() {
				value = $("input[type='radio']:checked").val();
			});
			if (value == "Indian") {
				window.location.href = "knowYourFormPart2.gsp";
			} else if (value == "Non-Indian") {
				window.location.href = "knowYourFormPart3.gsp";
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-sm-3">
			<img id="helpdeskimage" src="${resource(dir: 'images', file: 'helpdeskbig.png')}" alt="logo" class="img-responsive pull-left" style="zoom:0.4"/></a>
			</div>
			<div class="col-sm-9 helpdeskTop">
			<div class="col-sm-11  middle_box">
			<div class="text-danger col-sm-12">
			<span>Live help is available during office hours (10.00 AM to 5:00 PM), on all working days. A staff member will answer

your questions live and guide you further for filling up of application forms only.</span>
			</div><br/>
			<br/><br/><br/>
			
			<div class="col-sm-12 text-danger">
			<b>Call : +91 44 2254 2777</b>
			</div>
			
			
					
						
						
					
				</div>
				
			
		</div>
			
		</div>

		
		
		
	</div>
</body>
</html>