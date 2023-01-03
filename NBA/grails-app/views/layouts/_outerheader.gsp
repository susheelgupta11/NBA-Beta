<style type="text/css">
.image_bg {
	background-image: url('../images/Abstract-Header.jpg');
	background-size: 100%;
}
</style>

	<div class="">
		<div class=" col-sm-12 img-responsive TopLogoBorder">
			<div class="container img_top">
				<div class="col-sm-10">
					<div class="logo">
						<img src="${resource(dir: 'images', file: 'Logo1.jpg')}"
							alt="logo" class="img-responsive pull-left" />
					</div>
				</div>
				<div class="col-sm-2 btnTop"> 
					<%--				<input type="button" class="btn btn-success" value="Sign in"/>--%>
					<g:link class="btn btn-primary" controller="login" action="auth"
					 params='${[csrfPreventionSalt:csrfPreventionSalt]}'>New Registration</g:link>
<%--					<input type="button" class="btn btn-primary"--%>
<%--						value="New Registration" />--%>
                       
				</div>


			</div>
		</div>



	</div>
