
import org.nba.application.AppStatus


import org.nba.application.FormCategory


import org.nba.user.NbaUser

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_superAdmindashboard_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/superAdmin/dashboard.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("nbaDashboardLayout")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('set','g',14,['var':("userObject"),'value':(NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',21,['controller':("loggedInAs"),'action':("index"),'class':("dropdown-toggle"),'data-toggle':("dropdown")],2)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',24,['controller':("loggedInAs"),'action':("index"),'class':("dropdown-toggle"),'data-toggle':("dropdown")],2)
printHtmlPart(7)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',27,['controller':("loggedInAs"),'action':("index"),'class':("dropdown-toggle"),'data-toggle':("dropdown")],2)
printHtmlPart(10)
if(true && (flash?.message)) {
printHtmlPart(11)
expressionOut.print(flash?.message)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(applicationDetails.size()?:0)
printHtmlPart(14)
loop:{
int i = 0
for( applicationDetail in (applicationDetails) ) {
printHtmlPart(15)
expressionOut.print(i+1)
printHtmlPart(16)
if(true && (applicationDetail?.individualProfiles)) {
printHtmlPart(17)
for( individualProfile in (applicationDetail?.individualProfiles) ) {
printHtmlPart(18)
expressionOut.print(individualProfile?.title)
printHtmlPart(19)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(19)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(19)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(17)
}
printHtmlPart(20)
}
else if(true && (applicationDetail?.companyProfiles)) {
printHtmlPart(17)
loop:{
int k = 0
for( company in (applicationDetail?.companyProfiles) ) {
printHtmlPart(19)
expressionOut.print(company?.entityName)
printHtmlPart(17)
k++
}
}
printHtmlPart(20)
}
else if(true && (applicationDetail?.indianResearcher)) {
printHtmlPart(17)
for( researcher in (applicationDetail?.indianResearcher) ) {
printHtmlPart(18)
expressionOut.print(researcher?.title)
printHtmlPart(19)
expressionOut.print(researcher?.firstName)
printHtmlPart(19)
expressionOut.print(researcher?.middleName)
printHtmlPart(19)
expressionOut.print(researcher?.lastName)
printHtmlPart(21)
}
printHtmlPart(20)
}
else if(true && (applicationDetail?.depostionOfMicroOrganism)) {
printHtmlPart(17)
for( depost in (applicationDetail?.depostionOfMicroOrganism) ) {
printHtmlPart(19)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(17)
}
printHtmlPart(20)
}
else if(true && (applicationDetail?.indianGovtInst)) {
printHtmlPart(17)
for( govt in (applicationDetail?.indianGovtInst) ) {
printHtmlPart(19)
expressionOut.print(govt?.govtInstName)
printHtmlPart(17)
}
printHtmlPart(20)
}
printHtmlPart(22)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(23)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(24)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(25)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(26)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(27)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(applicationDetail.appNumber)
printHtmlPart(30)
if(true && (getReviewHeadRole == 'REVIEW_HEAD' || getReviewMemberRole == 'REVIEW_MEMBER')) {
printHtmlPart(31)
if(true && (applicationDetail.currentStatus?.status)) {
printHtmlPart(17)
expressionOut.print(applicationDetail.currentStatus?.status)
printHtmlPart(20)
}
printHtmlPart(32)
}
else {
printHtmlPart(33)
expressionOut.print(applicationDetail.currentStatus?.statusUpdate)
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (applicationDetail.currentStatus?.priority)) {
printHtmlPart(17)
expressionOut.print(applicationDetail.currentStatus?.priority)
printHtmlPart(20)
}
else {
printHtmlPart(35)
}
printHtmlPart(29)
expressionOut.print(applicationDetail.submittedOn)
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',164,['controller':("superAdmin"),'action':("addNote"),'params':([instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(38)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',167,['controller':("superAdmin"),'action':("noting"),'params':([instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(40)
i++
}
}
printHtmlPart(41)
expressionOut.print(recordRoomApplication?.size()?:0)
printHtmlPart(42)
loop:{
int i = 0
for( applicationDetail in (recordRoomApplication) ) {
printHtmlPart(33)
if(true && (applicationDetail?.currentStatus?.statusUpdate)) {
printHtmlPart(43)
expressionOut.print(i+1)
printHtmlPart(44)
expressionOut.print(applicationDetail?.category?.category)
printHtmlPart(45)
if(true && (applicationDetail?.currentStatus?.statusUpdate)) {
printHtmlPart(19)
expressionOut.print(applicationDetail?.currentStatus?.statusUpdate)
printHtmlPart(17)
}
else {
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(applicationDetail?.submittedOn)
printHtmlPart(48)
}
printHtmlPart(49)
i++
}
}
printHtmlPart(50)
expressionOut.print(approvedApplications?.size()?:0)
printHtmlPart(51)
if(true && (approvedApplications?.size())) {
printHtmlPart(33)
loop:{
int i = 0
for( applicationDetail in (approvedApplications) ) {
printHtmlPart(43)
expressionOut.print(i+1)
printHtmlPart(44)
expressionOut.print(applicationDetail?.category?.category)
printHtmlPart(44)
expressionOut.print(applicationDetail?.submittedOn)
printHtmlPart(44)
expressionOut.print(currentUser)
printHtmlPart(52)
i++
}
}
printHtmlPart(49)
}
printHtmlPart(53)
expressionOut.print(rejectedApplications?.size()?:0)
printHtmlPart(54)
if(true && (rejectedApplications?.size())) {
printHtmlPart(33)
loop:{
int l = 0
for( applicationDetail in (rejectedApplications) ) {
printHtmlPart(55)
expressionOut.print(l+1)
printHtmlPart(56)
invokeTag('formatDate','g',302,['format':("yyyy/MM/dd"),'date':(applicationDetail?.currentStatus?.changedOn)],-1)
printHtmlPart(45)
expressionOut.print(applicationDetail?.currentStatus?.statusUpdate)
printHtmlPart(57)
l++
}
}
printHtmlPart(49)
}
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',309,[:],1)
printHtmlPart(59)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1579793718000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
