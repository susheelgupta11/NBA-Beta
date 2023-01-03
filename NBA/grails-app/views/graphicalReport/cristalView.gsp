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
									<h3>${total}</h3>
				<g:link controller="graphicalReport" action="formwiseDetails" params="[appType:'total']">Total Applications</g:link>					
									
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
									<h3>${inprocess}</h3>
									<g:link controller="graphicalReport" action="formwiseDetails" params="[appType:'inprocess']">In process Applications</g:link>	
									
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
									<h3>${approved}</h3>
									<g:link controller="graphicalReport" action="formwiseDetails" params="[appType:'approved']">Approved Applications</g:link>
									
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
									<h3>${reject}</h3>
									<g:link controller="graphicalReport" action="formwiseDetails" params="[appType:'reject']">Reject Applications</g:link>
									
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
			</div>
			
			<div class="agile-grids">
				<div class="col-md-4 charts-right">
					<!-- area-chart -->
					<div class="area-grids">
						<div class="area-grids-heading">
							<h3>Application Status</h3>
						</div>
						<div id="graph4"></div>
						<script>
							Morris.Donut({
							  element: 'graph4',
							  data: [
								{value: ${inprocess}, label: 'Applications', formatted: 'Inprocess '+${ip}+'%' },
								{value: ${approved}, label: 'Applications', formatted: 'Approved '+${ap}+'%' },
								{value: ${reject}, label: 'Applications', formatted: 'Reject '+${rp}+'%' }
								
							  ],
							  formatter: function (x, data) { return data.formatted; }
							});
						</script>

					</div>
				</div>
				
					<!-- updating-data -->
			<div class="col-md-8 agile-bottom-right">
					<div class="agile-bottom-grid">
						<div class="area-grids-heading">
							<h3>Year Wise Details</h3>
						</div>
						<div id="graph6"></div>
						<script>
						// Use Morris.Bar
						Morris.Bar({
						  element: 'graph6',
						  data: [
						
							{x: '2016', Total: ${first.get(0)}},
							{x: '2017', Total: ${second.get(0)}},
							{x: '2018', Total: ${third.get(0)}},
							{x: '2019', Total: ${four.get(0)}},
							{x: '2020', Total: ${five.get(0)}},
							{x: '2021', Total: ${six.get(0)}},
							{x: '2022', Total: ${seven.get(0)}}
						  ],
						  xkey: 'x',
						  ykeys: ['Total'],
						  labels: ['Total'],
						  barColors: function (row, series, type) {
							if (type === 'bar') {
							  var red = Math.ceil(255 * row.y / this.ymax);
							  return 'rgb(' + red + ',0,0)';
							}
							else {
							  return '#000';
							}
						  }
						});
						</script>
					</div>
				</div>
					<!-- //updating-data -->
			
				<div class="clearfix"> </div>
			</div>
			
			
				
				<div class="clearfix"> </div>
			</div>
			

			
			</div> <!-- row -->
		</div> <!-- container -->   

</body>
</html>