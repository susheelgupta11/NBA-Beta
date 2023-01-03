
import org.nba.application.AppStatus


import org.nba.application.FormCategory


import org.nba.user.NbaUser


import org.nba.user.NbaRole


import org.nba.application.ApplicationForm1


import org.nba.user.NbaUserNbaRole

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_dashboarddashboard_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/dashboard.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('set','g',10,['var':("userObject"),'value':(NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))],-1)
printHtmlPart(0)
invokeTag('set','g',11,['var':("getNbaRole"),'value':(userObject?.nbaRole)],-1)
printHtmlPart(0)
invokeTag('set','g',12,['var':("getRoleDetails"),'value':(NbaRole.get(getNbaRole?.id))],-1)
printHtmlPart(0)
invokeTag('set','g',13,['var':("getAuthority"),'value':(getRoleDetails?.authority)],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',21,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layouts"),'content':("dashboard")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',22,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',22,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
if(true && (message)) {
printHtmlPart(6)
expressionOut.print(message)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(applicationDetails?.size()?:0)
printHtmlPart(9)
if(true && (applicationDetails)) {
printHtmlPart(10)

def i = 1

printHtmlPart(11)
for( application in (applicationDetails) ) {
printHtmlPart(12)
out.print(i)
printHtmlPart(13)

i++

printHtmlPart(14)
expressionOut.print(application?.applicant_name)
printHtmlPart(15)
expressionOut.print(application?.app_number)
printHtmlPart(16)
if(true && (application?.category == 'Form_1')) {
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (application?.category == 'Form_2')) {
printHtmlPart(19)
}
printHtmlPart(18)
if(true && (application?.category == 'Form_3')) {
printHtmlPart(20)
}
printHtmlPart(18)
if(true && (application?.category == 'Form_4')) {
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (application?.category == 'Form_B')) {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (application?.link_officer_check == true)) {
printHtmlPart(24)
expressionOut.print(application?.received_from)
printHtmlPart(25)
}
else {
printHtmlPart(26)
expressionOut.print(application?.received_from)
printHtmlPart(25)
}
printHtmlPart(27)
invokeTag('formatDate','g',112,['format':("dd/MM/yyyy"),'date':(application?.changed_on)],-1)
printHtmlPart(28)
expressionOut.print(application?.action_for?:'Initial')
printHtmlPart(29)
expressionOut.print(application?.priority?:'No Priority')
printHtmlPart(29)
expressionOut.print(application?.status_update?:'Submitted')
printHtmlPart(28)
if(true && (application?.communication_status == true)) {
printHtmlPart(30)
}
else {
printHtmlPart(31)
}
printHtmlPart(32)
createClosureForHtmlPart(33, 4)
invokeTag('link','g',144,['controller':("dashboard"),'action':("noting"),'params':([instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',149,['controller':("dashboard"),'action':("addNote"),'params':([instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(36)
createClosureForHtmlPart(37, 4)
invokeTag('link','g',152,['controller':("dashboard"),'action':("cdacApi"),'params':([instance:application?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(38)
createClosureForHtmlPart(39, 4)
invokeTag('remoteLink','g',156,['action':("moveToRecordRoom"),'controller':("dashboard"),'title':("Record Room Details"),'params':([instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt]),'data-target':("#record-modal"),'data-toggle':("modal"),'update':("con")],4)
printHtmlPart(40)
}
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(inProcessApplications?.size()?:0)
printHtmlPart(43)
if(true && (inProcessApplications)) {
printHtmlPart(10)

def g = 1

printHtmlPart(10)
for( applicationDetail in (inProcessApplications) ) {
printHtmlPart(44)
out.print(g)
printHtmlPart(13)

g++

printHtmlPart(14)
if(true && (applicationDetail?.individualProfiles)) {
printHtmlPart(45)
for( individualProfile in (applicationDetail?.individualProfiles) ) {
printHtmlPart(46)
expressionOut.print(individualProfile?.title)
printHtmlPart(25)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(25)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(25)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(45)
}
printHtmlPart(47)
}
else if(true && (applicationDetail?.companyProfiles)) {
printHtmlPart(45)
loop:{
int k = 0
for( company in (applicationDetail?.companyProfiles) ) {
printHtmlPart(25)
expressionOut.print(company?.entityName)
printHtmlPart(45)
k++
}
}
printHtmlPart(47)
}
else if(true && (applicationDetail?.indianResearcher)) {
printHtmlPart(45)
for( researcher in (applicationDetail?.indianResearcher) ) {
printHtmlPart(46)
expressionOut.print(researcher?.title)
printHtmlPart(25)
expressionOut.print(researcher?.firstName)
printHtmlPart(25)
expressionOut.print(researcher?.middleName)
printHtmlPart(25)
expressionOut.print(researcher?.lastName)
printHtmlPart(48)
}
printHtmlPart(47)
}
else if(true && (applicationDetail?.depostionOfMicroOrganism)) {
printHtmlPart(45)
for( depost in (applicationDetail?.depostionOfMicroOrganism) ) {
printHtmlPart(25)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(45)
}
printHtmlPart(47)
}
else if(true && (applicationDetail?.indianGovtInst)) {
printHtmlPart(45)
for( govt in (applicationDetail?.indianGovtInst) ) {
printHtmlPart(25)
expressionOut.print(govt?.govtInstName)
printHtmlPart(45)
}
printHtmlPart(47)
}
printHtmlPart(49)
expressionOut.print(applicationDetail?.appNumber)
printHtmlPart(28)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(17)
}
printHtmlPart(50)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(19)
}
printHtmlPart(50)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(20)
}
printHtmlPart(50)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(21)
}
printHtmlPart(50)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(22)
}
printHtmlPart(51)
expressionOut.print(applicationDetail?.currentStatus?.changedBy?.name)
printHtmlPart(52)
invokeTag('formatDate','g',288,['format':("dd/MM/yyyy"),'date':(applicationDetail?.currentStatus?.forwardedDate)],-1)
printHtmlPart(53)
expressionOut.print(applicationDetail?.currentStatus?.actionFor)
printHtmlPart(29)
expressionOut.print(applicationDetail?.currentStatus?.priority?:'No Priority')
printHtmlPart(29)
expressionOut.print(applicationDetail?.currentStatus?.statusUpdate)
printHtmlPart(28)
if(true && (applicationDetail?.currentStatus?.communicationStatus == true)) {
printHtmlPart(54)
}
else {
printHtmlPart(55)
}
printHtmlPart(56)
createClosureForHtmlPart(33, 4)
invokeTag('link','g',321,['controller':("dashboard"),'action':("noting"),'params':([instance:applicationDetail?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(57)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',326,['controller':("dashboard"),'action':("addNote"),'params':([instance:applicationDetail?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(58)
createClosureForHtmlPart(39, 4)
invokeTag('remoteLink','g',330,['action':("moveToRecordRoom"),'controller':("dashboard"),'title':("Record Room Details"),'params':([instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt]),'data-target':("#record-modal"),'data-toggle':("modal"),'update':("con")],4)
printHtmlPart(59)
}
printHtmlPart(41)
}
printHtmlPart(60)
if(true && (getAuthority == 'CHAIRMAN' || getAuthority == 'SECRETARY')) {
printHtmlPart(0)
invokeTag('render','g',346,['template':("/dashboard/superAdmin")],-1)
printHtmlPart(0)
}
printHtmlPart(61)
invokeTag('render','g',350,['template':("dashRight")],-1)
printHtmlPart(62)
})
invokeTag('captureBody','sitemesh',383,[:],1)
printHtmlPart(63)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671618869026L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
