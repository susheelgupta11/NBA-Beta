<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.LinkOfficer %>
<%! import org.nba.user.RoleEnum %>
<%! import org.nba.application.ApplicationForm1 %>

<g:set var="headerDetails" value="${formDetails}" />

<g:if test="${headerDetails}"> 
<g:javascript>

$( document ).ready(function() {
	document.getElementById('headerShow').style.display = 'block';
    console.log( "ready!" );
});
 
</g:javascript>
</g:if>

<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
			<li class="dropdown messages-menu"><g:link
						controller="dashboard" action="dashboard" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-home" style="font-size:16px">Home</i></g:link></li>
				<li class="dropdown messages-menu"><g:link controller="logout"
						params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-sign-out" style="font-size:16px;">Logout</i></g:link></li>
			</ul>
		</div>
	</nav>
	
	<div class="container-fluid">
                             <%-- Current User login details	--%>
		  <g:set var="userObject" value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}"/>
          <g:set var="getAuthority" value="${userObject?.nbaRole?.authority}" />
          
                             <%-- Link Officer access detail --%>
		  <g:set var="linkDetails" value="${LinkOfficer.findByNbaUserTo(userObject)}"/>
		  <g:set var="chkStatus" value="${linkDetails?.status}"/>
		  <g:set var="tillTime" value=" ${linkDetails?.toDate}"/>
		  		
		  		   <%-- Link Officer login details	--%>
	 <g:set var="linkOfficerName" value=" ${linkDetails?.nbaUserFrom?.answer}"/>	
	   <g:set  var="linkRole" value="${linkDetails?.nbaUserFrom?.nbaRole}"/>
	    <g:set var="linkAuth" value="${linkRole?.authority}" />
	    
	    
	    
		<div class="col-sm-9">
			<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo"
				class="img-responsive pull-left" />
		</div>
		<div class="col-sm-3 text-right" style="padding: 10px;">
			<div class="col-sm-12">
			    <g:if test="${linkOfficer == 'Yes'}">	
			    <b>Signed in as : </b>${linkOfficerName}<br/>
			    	<b>Role:</b>${linkAuth}<br/>
			     </g:if>
			     <g:else>
			             <sec:ifLoggedIn>
							<b>Signed in as : </b>${userObject?.name}<br/>
							<b>Role:</b>${getAuthority}<br/>
				         </sec:ifLoggedIn>
		</g:else>
<g:if test="${linkOfficer != 'Yes' }">				
<g:if test="${chkStatus != null}">
<span><b id="demo" style="color: orange"></b></span>	
<span id="toggl" style="display: block">


<g:if test="${chkStatus == true}">
<label class="switch">
  <b>Link Officer:</b><input type="checkbox" checked="checked">
  <span class="btn btn facebook"  id="dash"><g:link controller="dashboard" action="linkOfficerDashboard" params="${[linkOfficer:'Yes']}">L.O Dashboard</g:link></span>
  <span class="slider round"></span>
  
</label>
</g:if>
<g:elseif test="${chkStatus == false}">
<label class="switch">
 <b>Link Officer:</b> <input type="checkbox">
  <span class="slider round"></span>
</label>
</g:elseif>
</span>
</g:if>
</g:if>
</div>

<%--<g:if test="${chkStatus == true}">--%>
<%--<div class="col-sm-3 text-right" style="padding:3px;" id="dash">         --%>
<%--<span class="btn btn"><g:link controller="dashboard" action="linkOfficerDashboard">L.O Dashboard</g:link></span>		--%>
<%--</div>--%>
<%--</g:if>--%>
</div>
</div>	
  
   <nav class="navbar navbar-default"> 
    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> 
    <span class="sr-only">Toggle navigation</span> </a>
    <div style="float:right; padding:1em; cursor:pointer;">
    <div class="btn-group" role="group" aria-label="Controls">
         <i class="fa fa-bars toggle-sidebar" aria-hidden="true" style="color:#FFF; font-size:18px;"></i>
        </div>
	</div>
        
        
     <div class="container-fluid">
        <div class="collapse navbar-collapse" id="defaultNavbar1">
          <ul class="nav navbar-nav">
            <li><a href="#"><span class="sr-only">(current)</span></a></li>
            <li><a href="#"></a></li>
          </ul>
        </div>
      </div>
    </nav>
  
  <script type="text/javascript">

  document.addEventListener('DOMContentLoaded', function () {
		  var checkbox = document.querySelector('input[type="checkbox"]');

		  checkbox.addEventListener('change', function () {
		    if (checkbox.checked) {
		    	$.ajax({
					type : 'Post',
					dataType : 'JSON',
					url : '/NBA/dashboard/setLinkOfficerStatus',

					data : {condition : 'enable'},
					success : function(res) {
						console.log(res);
						alert(res.status);

					}
				});
		      document.getElementById('dash').style.display = 'block';
		      console.log('Checked');
		    } else {
		    	$.ajax({
					type : 'Post',
					dataType : 'JSON',
					url : '/NBA/dashboard/setLinkOfficerStatus',

					data : {condition : 'disable'},
					
					success : function(res) {
						console.log(res);
						alert(res.status);

					}
				});
		      document.getElementById('dash').style.display = 'none';
		      console.log('Not checked');
		    }
		  });
		});

</script>



<script>


var countDownDate = new Date("${tillTime}").getTime();

var x = setInterval(function() {

  var now = new Date().getTime();
    
  var distance = countDownDate - now;
    
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  document.getElementById("demo").innerHTML = days + "d " + hours + "h "
  + minutes + "m " + seconds + "s ";
    
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "Linked Officer Timeout";
   document.getElementById("toggl").style.display = 'none';
   document.getElementById('dash').style.display = 'none';
    
  }
}, 1000);
</script>



</header>


