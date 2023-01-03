
import org.nba.user.NbaUser


import org.nba.user.NbaRole


import org.nba.application.ApplicationForm1


import org.nba.application.FormCategory


import org.nba.user.NbaUserNbaRole

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layouts_leftmenu_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_leftmenu.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('set','g',8,['var':("userObject"),'value':(NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))],-1)
printHtmlPart(0)
invokeTag('set','g',9,['var':("getNbaRole"),'value':(userObject?.nbaRole)],-1)
printHtmlPart(0)
invokeTag('set','g',10,['var':("getRoleDetails"),'value':(NbaRole.get(getNbaRole?.id))],-1)
printHtmlPart(0)
invokeTag('set','g',11,['var':("getAuthority"),'value':(getRoleDetails?.authority)],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('set','g',15,['var':("getTechRole"),'value':("TECHNICAL_OFFICER_BS")],-1)
printHtmlPart(0)
})
invokeTag('ifAnyGranted','sec',16,['roles':("TECHNICAL_OFFICER_BS")],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('set','g',20,['var':("getAccountRole"),'value':("ACCOUNT_OFFICER")],-1)
printHtmlPart(0)
})
invokeTag('ifAnyGranted','sec',21,['roles':("ACCOUNT_OFFICER")],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('set','g',24,['var':("getLegalHeadRole"),'value':("LEGAL_HEAD")],-1)
printHtmlPart(0)
})
invokeTag('ifAnyGranted','sec',25,['roles':("LEGAL_HEAD")],1)
printHtmlPart(2)
invokeTag('set','g',28,['var':("formID"),'value':(formDetails?.id)],-1)
printHtmlPart(0)
if(true && (messageNote)) {
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',39,['controller':("dashboard"),'action':("dashboard"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(8)
}
else {
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',57,['controller':("dashboard"),'action':("dashboard"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',68,['controller':("dashboard"),'action':("noting"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',71,['controller':("dashboard"),'action':("addNote"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(13)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'IPR_MEMBER'|| getAuthority == 'REVIEW_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER')) {
printHtmlPart(14)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER')) {
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',87,['controller':("checklist"),'action':("accountMembers"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER')) {
printHtmlPart(19)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',91,[:],4)
printHtmlPart(21)
createTagBody(4, {->
printHtmlPart(22)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(25)
}
printHtmlPart(24)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(26)
}
printHtmlPart(24)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_B)) {
printHtmlPart(29)
}
printHtmlPart(30)
})
invokeTag('link','g',116,['controller':("checklist"),'action':("technicalReview"),'params':([instanceId:formID,formType:formDetails?.category?.category,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (getAuthority =='REVIEW_LEGAL_MEMBER' || getAuthority =='IPR_MEMBER')) {
printHtmlPart(33)
createTagBody(4, {->
printHtmlPart(34)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(23)
}
printHtmlPart(35)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(25)
}
printHtmlPart(35)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(26)
}
printHtmlPart(35)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_B)) {
printHtmlPart(29)
}
printHtmlPart(36)
})
invokeTag('link','g',146,['controller':("checklist"),'action':("legalHead"),'params':([instanceId:formID,formType:formDetails?.category?.category,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (getAuthority =='IPR_MEMBER' || getAuthority == 'IPR_OFFICER_MEMBER')) {
printHtmlPart(15)
createClosureForHtmlPart(37, 4)
invokeTag('link','g',150,['controller':("checklist"),'action':("iprRemark"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			  getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||  getAuthority == 'LEGAL_HEAD'||
			 getAuthority =='IPR_MEMBER' || getAuthority == 'ACCOUNT_OFFICER'  || getAuthority =='DDO'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(40)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='LEGAL_HEAD'|| getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(41)
createClosureForHtmlPart(42, 4)
invokeTag('link','g',175,['controller':("letterCommunication"),'action':("createCommunication"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD'
			 ||  getAuthority == 'REVIEW_LEGAL_HEAD'|| getAuthority =='LEGAL_HEAD'|| getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'  || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(41)
createClosureForHtmlPart(45, 4)
invokeTag('link','g',185,['controller':("letterCommunication"),'action':("draftCommunication"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(43)
}
printHtmlPart(32)
if(true && (getAuthority == 'REVIEW_HEAD' || getAuthority =='IPR_MEMBER'|| getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'
							 || getAuthority == 'REVIEW_LEGAL_HEAD'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
							 getAuthority =='SECRETARY' ||getAuthority =='LEGAL_HEAD'|| getAuthority =='CHAIRMAN')) {
printHtmlPart(41)
createClosureForHtmlPart(46, 4)
invokeTag('link','g',193,['controller':("letterCommunication"),'action':("approveCommunication"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(47)
}
printHtmlPart(48)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO')) {
printHtmlPart(49)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER')) {
printHtmlPart(41)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',207,['controller':("letterCommunication"),'action':("tr5Create"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(51)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO')) {
printHtmlPart(52)
createClosureForHtmlPart(53, 4)
invokeTag('link','g',212,['controller':("letterCommunication"),'action':("tr5Draft"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(32)
if(true && (getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO')) {
printHtmlPart(41)
createClosureForHtmlPart(54, 4)
invokeTag('link','g',216,['controller':("letterCommunication"),'action':("tr5Approve"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(47)
}
printHtmlPart(55)
if(true && (getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' || 
			 getAuthority =='LEGAL_HEAD' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(56)
if(true && (getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' || 
			 getAuthority =='LEGAL_HEAD' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(41)
createClosureForHtmlPart(57, 4)
invokeTag('link','g',235,['controller':("letterCommunication"),'action':("sbbCreate"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(43)
}
printHtmlPart(32)
if(true && (getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' || 
			 getAuthority =='LEGAL_HEAD' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(41)
createClosureForHtmlPart(58, 4)
invokeTag('link','g',242,['controller':("letterCommunication"),'action':("sbbDraft"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(32)
if(true && (getAuthority =='IPR_MEMBER'||getAuthority == 'TECHNICAL_OFFICER_BS' || getAuthority == 'TECHNICAL_OFFICER_IPR'|| getAuthority == 'REVIEW_HEAD'
			|| getAuthority == 'REVIEW_LEGAL_HEAD' || getAuthority == 'LEGAL_HEAD'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(41)
createClosureForHtmlPart(59, 4)
invokeTag('link','g',246,['controller':("letterCommunication"),'action':("sbbApprove"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(60)
}
printHtmlPart(61)
createClosureForHtmlPart(62, 2)
invokeTag('link','g',254,['controller':("letterCommunication"),'action':("allSentLetters"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(63)
createClosureForHtmlPart(64, 2)
invokeTag('link','g',257,['controller':("letterCommunication"),'action':("receivedCommunication"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(65)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'||
			 getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER'|| getAuthority == 'REVIEW_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(66)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'||
			 getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER'|| getAuthority == 'REVIEW_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(67)
createClosureForHtmlPart(68, 4)
invokeTag('link','g',275,['controller':("benefitSharing"),'action':("receivedBenefit"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(69)
if(true && (getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'||
			 getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER'|| getAuthority == 'REVIEW_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(70)
createClosureForHtmlPart(71, 4)
invokeTag('link','g',280,['controller':("benefitSharing"),'action':("distribution"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(47)
}
printHtmlPart(72)
if(true && (""" ${getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||
				getAuthority == 'TECHNICAL_OFFICER_IPR'|| getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			    getAuthority =='IPR_MEMBER'||  getAuthority == 'LEGAL_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}""")) {
printHtmlPart(73)
if(true && (getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER'|| 
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			  getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='IPR_MEMBER'||  getAuthority == 'LEGAL_HEAD')) {
printHtmlPart(41)
createClosureForHtmlPart(57, 4)
invokeTag('link','g',300,['controller':("agenda"),'action':("createAgenda"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(51)
if(true && (getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			  getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='IPR_MEMBER'||  getAuthority == 'LEGAL_HEAD'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(41)
createClosureForHtmlPart(58, 4)
invokeTag('link','g',307,['controller':("agenda"),'action':("agendaDraft"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(32)
if(true && (getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN' || getAuthority == 'LEGAL_HEAD'||
			                  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR')) {
printHtmlPart(41)
createClosureForHtmlPart(59, 4)
invokeTag('link','g',311,['controller':("agenda"),'action':("agendaApprove"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(17)
}
printHtmlPart(47)
}
printHtmlPart(74)
createClosureForHtmlPart(75, 2)
invokeTag('link','g',316,['controller':("fileMovments"),'action':("fileMovment"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(76)
createClosureForHtmlPart(77, 2)
invokeTag('link','g',327,['controller':("manualUpload"),'action':("addDocument"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(11)
createClosureForHtmlPart(78, 2)
invokeTag('link','g',331,['controller':("manualUpload"),'action':("addClearanceLtr"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(79)
if(true && (getAuthority == 'LEGAL_HEAD'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN')) {
printHtmlPart(80)
createClosureForHtmlPart(81, 3)
invokeTag('link','g',340,['controller':("versionManager"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm( 'Are you sure?');")],3)
printHtmlPart(82)
}
printHtmlPart(83)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649049273344L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
