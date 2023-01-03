package com.nba.constant


class Constants {
	
	def springSecurityService

	public static final String FILE_FORWARD_MSG = "Application Forward Successfully";
	public static final String LETTER_DRAFTED = "Draft Saved Successfully";
	public static final String LETTER_UPDATED = "Draft Update Successfully";
	public static final String LETTER_APPROVED = "Draft Approved Successfully";
	public static final String LETTER_SEND = "Draft Send Successfully";
	
	public static final String Record_Room = "Successfully move to record room"
	public static final String SBB_CONSENT = "Letter send Successfully"
	public static final String SBB_CONSENT_CONF = "This application is already send to this SBB";
	public static final String SBB_CONSENT_NEW = "This application is new for this SBB";
	public static final String VIRTUAL_USER = "virtual";
	
	public static final List MEETING = ['Expert Committee on ABS','Authority','Internal committee','NBA Secretariat']
	
	public static final String MEET_1 = 'Expert Committee on ABS';

	
	public static final String MEET_2 = 'Authority';

	public static final String MEET_3 = 'Internal committee';

	public static final String MEET_4 = 'NBA Secretariat';

	
 
public static final String ADMIN_QUERY = """

SELECT DISTINCT ON (af.app_number) af.id,af.app_number,to_char(TO_DATE(submitted_on, 'YYYY-MM-DD'),'YYYY/MM/DD'), FC.Category,app_status.status,


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

INNER JOIN Form_Category FC ON af.category_id = FC.Id


WHERE
app_status.status <> 'PENDING'
ORDER BY af.app_number DESC;
"""


public static String NBA_QUERY = '''

SELECT DISTINCT ON (af.app_number) af.id,af.app_number, FC.Category,app_status.forwarded_date as changed_on,app_status.status,app_status.priority,app_status.action_for,
app_status.status_update,app_status.forwarded_user,app_status.send_by_user as received_from,app_status.link_officer_check,
app_status.communication_status,
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
INNER JOIN Form_Category FC ON af.category_id = FC.Id

WHERE
FC.category <> 'Form_C' AND
app_status.user_counter = TRUE
ORDER BY af.app_number DESC;
'''	



public static String FORM_WISE = '''

SELECT DISTINCT ON (af.app_number) af.id,af.app_number, NU.name as received_from,app_status.changed_on,
FC.Category,app_status.action_for,app_status.status_update,app_status.forwarded_date ,app_status.current_desk,

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
FC.category = 'APPU'  AND
app_status.status = 'APPTYPE' 

ORDER BY af.app_number DESC;
'''


public static String STATUS_WISE = '''

SELECT DISTINCT ON (af.app_number) af.id,af.app_number, NU.name as received_from,app_status.changed_on,
FC.Category,app_status.action_for,app_status.status_update,app_status.forwarded_date ,app_status.current_desk,

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

app_status.status = 'APPTYPE' 

ORDER BY af.app_number DESC;
'''


public static String NTC = "SELECT bio_resource,status,part FROM ntc_check;"
public static String NTC_QUERY = "SELECT * FROM ntc_check"


public static String COMM_QUERY_REVIEW = '''

SELECT DISTINCT ON (af.app_number) af.id, cl.id AS  client_id, sbbc.id AS sbb_consent_id, af.app_number, cl.subject

FROM application_form1 af

left JOIN client_letter cl on af.id = cl.application_form_id
left JOIN sbbconsent sbbc on af.id = sbbc.application_form1_id

inner JOIN app_status on af.id = app_status.application_id

WHERE

app_status.communication_status = TRUE AND
app_status.status = 'SUBMITTED'

ORDER BY af.app_number DESC;
'''	


public static String COMM_QUERY_NBA = '''

SELECT DISTINCT ON (af.app_number) af.id,af.app_number, cl.subject, cl.id AS  client_id, sbbc.id AS sbb_consent_id, app_status.forwarded_user

FROM application_form1 af

left JOIN client_letter cl on af.id = cl.application_form_id
left JOIN sbbconsent sbbc on af.id = sbbc.application_form1_id
inner JOIN app_status on af.id = app_status.application_id

WHERE

app_status.communication_status = TRUE

ORDER BY af.app_number DESC;
'''	

public static String COMM_APPLICANT = '''

SELECT DISTINCT ON (af.app_number) af.id,af.app_number, lc.subject, lc.id AS  letter_id,NU.username as received_from

FROM application_form1 af

left JOIN letter_communication lc on af.id = lc.application_form1_id
inner JOIN app_status on af.id = app_status.application_id
INNER JOIN nba_user NU ON af.submitted_by_id = NU.Id

WHERE

app_status.comm_status_applicant = TRUE

ORDER BY af.app_number DESC;
'''	





}