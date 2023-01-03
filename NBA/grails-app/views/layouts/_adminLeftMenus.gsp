<aside class="main-sidebar" style="background-color: #fff !important;"> 
    <section class="sidebar" style="margin-top: 10px;"> 
      <ul class="sidebar-menu" data-widget="tree">
      			<li class="formheading"
				style="border: 1px solid #f5dea0; padding: 10px; background: #748aa3; margin-bottom: 5px; text-align: center; color: #fff;">MENU</li>
        <li class="userss"><g:link controller="loggedInAs" action="inbox" params="${[csrfPreventionSalt:csrfPreventionSalt]}">View Application</g:link></li>
        
        <li class="treeview userss"><a href="#"><span>Manage User</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i> </span> </a>
        <ul class="treeview-menu">
       
            <li><g:link controller="nbaUser" action="index" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> User List</g:link></li>
            <li><g:link controller="nbaUser" action="create" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Add User</g:link></li>
             
         </ul>
         </li>
        <li class="treeview userss"><a href="#"><span>Template</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i> </span> </a>
          <ul class="treeview-menu">
            <li><g:link controller="setMstrData" action="index" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Draft</g:link></li>
            <li><g:link controller="setMstrData" action="note" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Note</g:link></li>
            <li><g:link controller="setMstrData" action="submission" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Submission</g:link></li>
            <li><g:link controller="setMstrData" action="queries" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Queries</g:link></li>
            <li><g:link controller="setMstrData" action="actions" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Action</g:link></li>
            <li><g:link controller="setMstrData" action="status" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Status</g:link></li>
            <li><g:link controller="setMstrData" action="priority" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Priority</g:link></li>
            
         </ul>
        </li>
        
    <li class="treeview userss"><a href="#"><span>Letter Template</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i> </span> </a>
          <ul class="treeview-menu">
            <li><g:link controller="setMstrData" action="letterList" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Letter List</g:link></li>
            <li><g:link controller="setMstrData" action="addLetter" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Add Letter</g:link></li>
         </ul>
        </li>
        
        <li class="userss"><g:link controller="loggedInAs" action="tr5Issued" params="${[csrfPreventionSalt:csrfPreventionSalt]}" >TR5 Issued list</g:link></li>
        <li class="userss"><g:link controller="loggedInAs" action="benefitSharingReceived" params="${[csrfPreventionSalt:csrfPreventionSalt]}">Benefit sharing received</g:link></li>
        <li class="userss"><g:link controller="loggedInAs" action="agendaReport" params="${[csrfPreventionSalt:csrfPreventionSalt]}">Agenda (Approved One)</g:link></li>
        
          <li class="treeview userss"><a href="#"><span>Link Officer Manager </span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i> </span> </a>
          <ul class="treeview-menu">
       
            <li><g:link controller="loggedInAs" action="linkOfficerList" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Link Officer List</g:link></li>
            <li><g:link controller="loggedInAs" action="linkOfficer" params="${[csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i> Link Officer</g:link></li>
             
         </ul>
         </li> 
           
          <li class="userss"><g:link controller="setMstrData" action="kms" params="${[csrfPreventionSalt:csrfPreventionSalt]}">KMS</g:link></li> 
          
          <li class="userss"><g:link controller="loggedInAs" action="recordRoomList" params="${[csrfPreventionSalt:csrfPreventionSalt]}" >Record Room</g:link></li> 
          
          <li class="userss"><g:link controller="loggedInAs" action="auditLog" params="${[csrfPreventionSalt:csrfPreventionSalt]}" >User Log</g:link></li> 
          
      </ul>
    </section>
  </aside>


  
  
  