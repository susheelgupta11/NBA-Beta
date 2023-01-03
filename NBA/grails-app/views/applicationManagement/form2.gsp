
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
    <title>NBA</title>

</head>

<body>

<nav class="navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               
            </div>
           
        </div>
        <!-- /.container -->
    </nav>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               
            </div>
       
        </div>
        <!-- /.container -->
    </nav>

    
    <!-- Page Content -->
   <div class="container container1">
	<div class="row">
		
		<div class="col-sm-3">
				<div class="list-group">
				  <a href="form.html" class="list-group-item active"> Part1</a>
				  <a href="form-part1.html" class="list-group-item"> Part2</a>
				  <a href="form-part2.html" class="list-group-item"> Part3</a>
				 <a href="form-part3.html" class="list-group-item"> Part4</a>
				 <a href="form-part3.html" class="list-group-item"> Part5</a>
				</div>
			</div>
		<div class="col-sm-9">
			<div class="col-sm-12">
				<div class="checkout-wrap">
					  <ul class="checkout-bar">

						<li class="active">
						 <a href="#">Step 1</a>
						</li>
						
						<li class="">Step 2</li>
							
						<li class="next">Step 3</li>
							
						<li class="">Step 4</li>
					
						   
					  </ul>
					</div>
			</div>
			<div class="clearfix"></div>
			
			<div class="clearfix"></div>
			<div class="main-registeration col-sm-12">
					<!--login form -->
				<div class="col-sm-12 nopadding">
				
				<div class="form-title">
					<label class="register-heading">
						Details and specific information about nature of access sought and biological material and associated knowledge to be accessed
					</label>
				</div>
				</div>
			
				<form class="form-horizontal" role="form" autocomplete="off">
				<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<div class="form-title">
					<label class="register-heading">
						(i) Identification (scientific name) of biological resources and its traditional use
					</label>
				</div>
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(a) Common Name</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							
							
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(b) Scientific Name</label>
									  <div class="col-sm-8">
										
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
						
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(c)  Nature of biological resources (eg. stem / seed / fruit / root / leaves / in case of animals, parts used)/ Product derived from plant / animal / microorganism / genetic resource material.</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(d) Quantity of the biological resource (in terms of number/ weight/ volume in metric unit kg/ ml / vials / slants)</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(e) Source of access: 
Wild / Cultivated / Market / Trader / Repositories / Institution/ Others.
If others, please specify
</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(f) Time span in which the biological resource is prposed to be collected</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4" for="email">(g) Traditional use, if any</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							
							<div class="form-group"> 
							 		
							  <div class="col-sm-12">
								<button type="submit" class="btn  login-btin pull-right">Submit</button>
							  </div>
							</div>
							
						  </form>
					<!--login form ends -->
			</div>
			
			
			<div class="clearfix"></div>
			<div class="col-sm-12 nopadding">
				<table class="table table-bordered datatable">
				  <thead>
					<tr>
					  <th>S.No.</th>
					  <th>Common Name</th>
					  <th>Scientific Name</th>
					  <th>Nature of Biological </th>
					  <th>Source of access</th>
					  <th>Time span</th>
					  <th>Traditional use</th>
					</tr>
				  </thead>
				  <tbody>
					<tr>
					  <td scope="row">1</th>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					</tr>
					<tr>
					  <td scope="row">2</th>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					</tr>
					
				  </tbody>
				</table>
			</div>
			
			<div class="clearfix"></div>
			<div class="main-registeration col-sm-12">
					<!--login form -->
						<form class="form-horizontal" role="form" autocomplete="off">
						<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<div class="form-title">
					<label class="register-heading">
						(ii) Geographical location of proposed collection
					</label>
				</div>
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(a) Name of biological resource</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							
							
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(b) Village/ Panchayat</label>
									  <div class="col-sm-8">
										
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
						
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(c) Town/ Taluk</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(d) District</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							
							<div class="col-sm-12">
								<div class="form-group">
									  <label class="control-label col-sm-4">(e) State</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-4">(f) Trader (Name & contact details)</label>
									  <div class="col-sm-8">
										<input type="text" class="form-control">
									  </div>
								</div>
							</div>
							
							<div class="form-group"> 
							  <div class="col-sm-12">
								<button type="submit" class="btn  login-btin pull-right">Submit</button>
							  </div>
							</div>
							
						  </form>
					<!--login form ends -->
			</div>
			
			<div class="clearfix"></div>
			<div class="col-sm-12 nopadding">
				<table class="table table-bordered datatable">
				  <thead>
					<tr>
					  <th>S.No.</th>
					  <th>Name of biological resource</th>
					  <th>Village/ Panchayat</th>
					  <th>Town/ Taluk</th>
					  <th>District</th>
					  <th>State</th>
					  <th>Trader (Name & contact details)</th>
					</tr>
				  </thead>
				  <tbody>
					<tr>
					  <td scope="row">1</th>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					</tr>
					<tr>
					  <td scope="row">2</th>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					  <td scope="row"></td>
					</tr>
					
				  </tbody>
				</table>
			</div>
			
			<div class="clearfix"></div>
			<div class="main-registeration col-sm-12">
					<!--login form -->
						<form class="form-horizontal" role="form" autocomplete="off">
						<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
							<div class="col-sm-12">
							
							<div class="form-title">
								<label class="register-heading">
									(iV) Description/ nature of traditional knowledge (oral/ documented)
								</label>
							</div>
								<div class="form-group">
						
									  <div class="col-sm-12">
										<textarea rows="4" class="form-control"></textarea>
									  </div>
								</div>
							</div>
							<div class="form-group"> 
							  <div class="col-sm-12">
							   <a href="form-part1.html" class="btn  login-btin pull-right">Next Page</a>
								<a href="form-part1.html" class="btn  login-btin pull-right">Save and Continue</a>
								
							  </div>
							</div>
							
						  </form>
					<!--login form ends -->
			</div>
			
			
			
		</div>
	</div>
   </div>
    <!-- /.container -->
<div class="clearfix"></div>

</body>

</html>
