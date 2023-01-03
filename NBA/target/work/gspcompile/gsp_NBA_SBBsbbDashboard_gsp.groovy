
import org.nba.application.AppStatus


import org.nba.application.FormCategory


import org.nba.user.NbaUser

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_SBBsbbDashboard_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/SBB/sbbDashboard.gsp" }
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
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("sbbDash")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(applicationDetails?.size()?:0)
printHtmlPart(5)
if(true && (applicationDetails)) {
printHtmlPart(6)

def i = 1

printHtmlPart(7)
for( applicationDetail in (applicationDetails) ) {
printHtmlPart(8)
out.print(i)
printHtmlPart(9)

i++

printHtmlPart(10)
if(true && (applicationDetail?.individualProfiles)) {
printHtmlPart(11)
for( individualProfile in (applicationDetail?.individualProfiles) ) {
printHtmlPart(12)
expressionOut.print(individualProfile?.title)
printHtmlPart(12)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(12)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(12)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(11)
}
printHtmlPart(13)
}
else if(true && (applicationDetail?.companyProfiles)) {
printHtmlPart(11)
loop:{
int k = 0
for( company in (applicationDetail?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(company?.entityName)
printHtmlPart(11)
k++
}
}
printHtmlPart(13)
}
else if(true && (applicationDetail?.indianResearcher)) {
printHtmlPart(11)
for( researcher in (applicationDetail?.indianResearcher) ) {
printHtmlPart(12)
expressionOut.print(researcher?.title)
printHtmlPart(12)
expressionOut.print(researcher?.firstName)
printHtmlPart(12)
expressionOut.print(researcher?.middleName)
printHtmlPart(12)
expressionOut.print(researcher?.lastName)
printHtmlPart(11)
}
printHtmlPart(13)
}
else if(true && (applicationDetail?.depostionOfMicroOrganism)) {
printHtmlPart(11)
for( depost in (applicationDetail?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(11)
}
printHtmlPart(13)
}
else if(true && (applicationDetail?.indianGovtInst)) {
printHtmlPart(11)
for( govt in (applicationDetail?.indianGovtInst) ) {
printHtmlPart(12)
expressionOut.print(govt?.govtInstName)
printHtmlPart(11)
}
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(applicationDetail.appNumber)
printHtmlPart(15)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(16)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(17)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(18)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(19)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(20)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(21)
}
printHtmlPart(22)
expressionOut.print(applicationDetail?.sbbCommunication?.sendUser)
printHtmlPart(23)
invokeTag('formatDate','g',130,['format':("dd/MM/yyyy"),'date':(applicationDetail?.sbbCommunication?.sendDate)],-1)
printHtmlPart(24)
expressionOut.print(applicationDetail?.sbbCommunication?.action)
printHtmlPart(25)
if(true && (applicationDetail?.currentStatus?.communicationStatus == true)) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
createClosureForHtmlPart(29, 4)
invokeTag('link','g',154,['controller':("SBB"),'action':("replyConsent"),'params':([instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(32)
expressionOut.print(inProcessApplications?.size()?:0)
printHtmlPart(33)
if(true && (inProcessApplications)) {
printHtmlPart(31)

def g = 1

printHtmlPart(31)
for( applicationDetail in (inProcessApplications) ) {
printHtmlPart(34)
out.print(g)
printHtmlPart(35)

g++

printHtmlPart(36)
if(true && (applicationDetail?.individualProfiles)) {
printHtmlPart(13)
for( individualProfile in (applicationDetail?.individualProfiles) ) {
printHtmlPart(37)
expressionOut.print(individualProfile?.title)
printHtmlPart(11)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(11)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(11)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(13)
}
printHtmlPart(38)
}
else if(true && (applicationDetail?.companyProfiles)) {
printHtmlPart(13)
loop:{
int k = 0
for( company in (applicationDetail?.companyProfiles) ) {
printHtmlPart(11)
expressionOut.print(company?.entityName)
printHtmlPart(13)
k++
}
}
printHtmlPart(38)
}
else if(true && (applicationDetail?.indianResearcher)) {
printHtmlPart(13)
for( researcher in (applicationDetail?.indianResearcher) ) {
printHtmlPart(37)
expressionOut.print(researcher?.title)
printHtmlPart(11)
expressionOut.print(researcher?.firstName)
printHtmlPart(11)
expressionOut.print(researcher?.middleName)
printHtmlPart(11)
expressionOut.print(researcher?.lastName)
printHtmlPart(39)
}
printHtmlPart(38)
}
else if(true && (applicationDetail?.depostionOfMicroOrganism)) {
printHtmlPart(13)
for( depost in (applicationDetail?.depostionOfMicroOrganism) ) {
printHtmlPart(11)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(13)
}
printHtmlPart(38)
}
else if(true && (applicationDetail?.indianGovtInst)) {
printHtmlPart(13)
for( govt in (applicationDetail?.indianGovtInst) ) {
printHtmlPart(11)
expressionOut.print(govt?.govtInstName)
printHtmlPart(13)
}
printHtmlPart(38)
}
printHtmlPart(40)
expressionOut.print(applicationDetail?.appNumber)
printHtmlPart(41)
expressionOut.print(applicationDetail?.category?.category)
printHtmlPart(42)
expressionOut.print(applicationDetail?.sbbCommunication?.sendUser)
printHtmlPart(23)
invokeTag('formatDate','g',264,['format':("dd/MM/yyyy"),'date':(applicationDetail?.sbbCommunication?.sendDate)],-1)
printHtmlPart(24)
expressionOut.print(applicationDetail?.sbbCommunication?.action)
printHtmlPart(25)
if(true && (applicationDetail?.currentStatus?.communicationStatus == true)) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(43)
createClosureForHtmlPart(29, 4)
invokeTag('link','g',290,['controller':("SBB"),'action':("replyConsent"),'params':([instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(44)
}
printHtmlPart(45)
}
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',300,[:],1)
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620359000500L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
