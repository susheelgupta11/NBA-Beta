SELECT DISTINCT ON (af.app_number) af.id,af.app_number, NU.name as received_from,app_status.changed_on,
app_status.priority,app_status.action_for,app_status.status_update,

CONCAT(

COALESCE(com.entity_name,COALESCE(igi.govt_inst_name,COALESCE(dmo.name_of_depositor, COALESCE(ip.title,ir.title)))),' ',

COALESCE(ip.first_name,ir.first_name),' ',

COALESCE(ip.middle_name ,ir.middle_name),' ',

COALESCE(ip.last_name,ir.last_name)) AS Applicant_Name


FROM application_form1 af

left JOIN individual_profile ip on af.id = ip.application_form1_id
left JOIN company_profile com on af.id = com.application_form_id
left JOIN indian_researcher ir on af.id = ir.application_form1_id
left JOIN indian_govt_inst igi on af.id = igi.application_form1_id
left JOIN deposition_of_micro_organism dmo on af.id = dmo.application_form1_id
inner JOIN app_status on af.id = app_status.application_id
INNER JOIN nba_user NU ON af.submitted_by_id = NU.Id
INNER JOIN Form_Category FC ON af.category_id = FC.Id


WHERE
FC.category = 'Form_1' 

--AND
--app_status.status = 'SUBMITTED' 
--OR
--app_status.user_counter = TRUE

ORDER BY af.app_number DESC;