       <div class="col-md-3 abc1" id="sidebar" style="top:0;">
				  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Notification</a></li>
  </ul>

  <div class="tab-content">
        <div id="home" class="tab-pane fade in active table-responsive">
		  <table class="table">
                  <thead class="thead-dark">
                    <tr>
                      <th>S.No</th>
                      <th>Application No</th>
                      <th>Subject</th>
                      <th>Read</th>
                    </tr>
                  </thead>
                  <tbody>
          <g:if test="${notificationApp}">
          <g:each in="${notificationApp}" var="comm" status="i">
          <tr>
          <td>${i+1}</td>
          <td>${comm?.app_number }</td>
          <td>${comm?.subject }</td>
          <td></td>
          </tr>
          </g:each>
          
          </g:if>
		  </tbody>
		  </table>
        </div>
     </div>
     </div> 

<script>
	$(document).ready(function () {
		$(".toggle-sidebar").click(function () {
			$("#sidebar").toggleClass("collapsed");
			$("#content").toggleClass("col-md-9 col-md-12");
			$("#sidebar").toggleClass("abc1 abc2");
			
			//$(".fa .fa-bars").hide();
			$(".toggle-sidebar").toggleClass(" fa fa-bars fa fa-times");
			//$(".toggle-sidebar").addClass("");
			return false;
		});
	});
</script>   