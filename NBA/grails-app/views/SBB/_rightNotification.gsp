     <div id="mySidenav" class="sidenavs">
        <div class="col-sm-12 right-div-menu">
          <div class="main-tbs">
            <table class="table table-bordered" style="margin-bottom: 0px;">
              <tr>
                <button class="tablink" onclick="openPage('Home', this, 'red')" id="defaultOpen">Notification</button>
               
               
              </tr>
            </table>
            <div class="col-sm-12 leftdiv">
              <div id="Home" class="tabcontent">
                <table class="table table-bordered customtable">
                  <tr class="header">
                    <th>S.No</th>
                    <th>Applicat No</th>
                    <th>Subject</th>
                    <th>Read</th>
                   
                  </tr>
                  <g:if test="${dashNotification}" >
                  <g:each in="${dashNotification}" var="noti" status="i">
                  <tr style="background:#fff;">
                    <td>${i+1}</td>
                    <td>${noti?.appNumber}</td>
                    <td>Lorem ipsum</td>
                    <td><g:link controller="dashboard" action="movetoInbox" onclick="return confirmation('Are you sure')" params="${[instance:virtual?.id] }">Retrieve to Inbox</g:link></td>
                   
                  </tr>
                  </g:each>
                </g:if>
         
                </table>
              </div>
 

            </div>
          </div>
        </div>
      </div>
      <div id="main">
       <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> 
       <span class="openbtn" style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
     </div>
   <script>
$( document ).ready(function() {
    $(".closebtn").hide();
});
$( document ).ready(function() {
    $(".closebtn").hide();
});
function openNav() {
	  var scroll = $(window).width();	
	
	if (scroll >= 320 && scroll <= 480) {
  document.getElementById("mySidenav").style.width = "310px";
  }
  if (scroll >= 481 && scroll <= 500) {
  document.getElementById("mySidenav").style.width = "470px";
  }
  if (scroll >= 501 && scroll <= 1199) {
  document.getElementById("mySidenav").style.width = "400px";
  }
  if (scroll >= 1200 ) {
  document.getElementById("mySidenav").style.width = "540px";
  }
	document.getElementById("costum-lft").style.width = "600px";
	$(".closebtn").show();
	$(".openbtn").hide();
  if (scroll >= 992 && scroll <= 1199) {
  document.getElementById("costum-lft").style.width = "360px";
  }
  if (scroll >= 1200 && scroll <= 1380) {
  document.getElementById("costum-lft").style.width = "570px";
  }
  if (scroll >= 1201 && scroll <= 1400) {
  document.getElementById("costum-lft").style.width = "570px";
  }
  if (scroll >= 1401 && scroll <= 1600) {
  document.getElementById("costum-lft").style.width = "58%";
  }
  if (scroll >= 1601 && scroll <= 1900) {
  document.getElementById("costum-lft").style.width = "62%";
  }
  if (scroll >= 1901 ) {
  document.getElementById("costum-lft").style.width = "69%";
  }
}
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
	document.getElementById("costum-lft").style.width = "100%";
	$(".closebtn").hide();
	$(".openbtn").show();
}
</script> 