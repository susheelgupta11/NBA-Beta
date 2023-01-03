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
				<a href="#">Total Applications</a>				
									
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
									<h3>${ondesk}</h3>
									<a href="#">On desk Applications</a>	
									
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
									<h3>${processed}</h3>
									<a href="#">Processed Applications</a>
									
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
									<h3>${recordRoom}</h3>
									<a href="#">Record room Applications</a>
									
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
					<g:render template="individualTable"></g:render>
			</div>
			
<%--			<div class="agile-grids">--%>
<%--				<div class="col-md-4 charts-right">--%>
<%--					<!-- area-chart -->--%>
<%--					<div class="area-grids">--%>
<%--						<div class="area-grids-heading">--%>
<%--							<h3>Application Status</h3>--%>
<%--						</div>--%>
<%--						<div id="graph4"></div>--%>
<%--						<script>--%>
<%--							Morris.Donut({--%>
<%--							  element: 'graph4',--%>
<%--							  data: [--%>
<%--								{value: ${ondesk}, label: 'Applications', formatted: 'On Desk '+${od}+'%' },--%>
<%--								{value: ${processed}, label: 'Applications', formatted: 'Processed '+${pd}+'%' },--%>
<%--								{value: ${recordRoom}, label: 'Applications', formatted: 'Record Room '+${rm}+'%' }--%>
<%--								--%>
<%--							  ],--%>
<%--							  formatter: function (x, data) { return data.formatted; }--%>
<%--							});--%>
<%--						</script>--%>
<%----%>
<%--					</div>--%>
<%--				</div>--%>
<%--				<div class="col-md-8 chart-left">--%>
<%--					<!-- updating-data -->--%>
<%--					<div class="agile-Updating-grids">--%>
<%--						<div class="area-grids-heading">--%>
<%--							<h3>Updating data</h3>--%>
<%--						</div>--%>
<%--						<div id="graph1"></div>--%>
<%--						<script>--%>
<%--						var nReloads = 0;--%>
<%--						function data(offset) {--%>
<%--						  var ret = [];--%>
<%--						  for (var x = 0; x <= 360; x += 10) {--%>
<%--							var v = (offset + x) % 360;--%>
<%--							ret.push({--%>
<%--							  x: x,--%>
<%--							  y: Math.sin(Math.PI * v / 180).toFixed(4),--%>
<%--							  z: Math.cos(Math.PI * v / 180).toFixed(4)--%>
<%--							});--%>
<%--						  }--%>
<%--						  return ret;--%>
<%--						}--%>
<%--						var graph = Morris.Line({--%>
<%--							element: 'graph1',--%>
<%--							data: data(0),--%>
<%--							xkey: 'x',--%>
<%--							ykeys: ['y', 'z'],--%>
<%--							labels: ['Processed','On-desk'],--%>
<%--							parseTime: false,--%>
<%--							ymin: -1.0,--%>
<%--							ymax: 1.0,--%>
<%--							hideHover: true--%>
<%--						});--%>
<%--						function update() {--%>
<%--						  nReloads++;--%>
<%--						  graph.setData(data(5 * nReloads));--%>
<%--						  $('#reloadStatus').text(nReloads + ' reloads');--%>
<%--						}--%>
<%--						setInterval(update, 100);--%>
<%--						</script>--%>
<%----%>
<%--					</div>--%>
<%--					<!-- //updating-data -->--%>
<%--				</div>--%>
<%--				<div class="clearfix"> </div>--%>
<%--			</div>--%>
			
			
				<div class="clearfix"> </div>
			</div>
			

			
			</div> <!-- row -->
		</div> <!-- container -->   

</body>
</html>

