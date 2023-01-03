import org.nba.application.FormCategory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicantcreatePeriodicReport_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/createPeriodicReport.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("applicant")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',27,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(5)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(4)
invokeTag('set','g',33,['value':("${individualProfile?.title} ${individualProfile?.firstName} ${individualProfile?.middleName} ${individualProfile?.lastName}"),'var':("fullName")],-1)
printHtmlPart(5)
}
printHtmlPart(4)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(5)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(6)
invokeTag('set','g',38,['value':(company?.entityName),'var':("fullName")],-1)
printHtmlPart(7)
k++
}
}
printHtmlPart(4)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(5)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(6)
invokeTag('set','g',46,['value':("${researcher?.title} ${researcher?.firstName} ${researcher?.middleName} ${researcher?.lastName}"),'var':("fullName")],-1)
printHtmlPart(5)
}
printHtmlPart(4)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(5)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(8)
invokeTag('set','g',52,['value':(depost?.nameOfDepositor),'var':("fullName")],-1)
printHtmlPart(5)
}
printHtmlPart(4)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(5)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(8)
invokeTag('set','g',58,['value':(govt?.govtInstName),'var':("fullName")],-1)
printHtmlPart(5)
}
printHtmlPart(4)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
if(true && (message)) {
printHtmlPart(11)
expressionOut.print(message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (act == '1')) {
printHtmlPart(14)
invokeTag('render','g',79,['template':("createReport1")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (act == '1C')) {
printHtmlPart(14)
invokeTag('render','g',83,['template':("createReport1C")],-1)
printHtmlPart(14)
}
printHtmlPart(16)
if(true && (act == '2')) {
printHtmlPart(14)
invokeTag('render','g',86,['template':("createReport2")],-1)
printHtmlPart(14)
}
printHtmlPart(16)
if(true && (act == '3')) {
printHtmlPart(14)
invokeTag('render','g',89,['template':("createReport3")],-1)
printHtmlPart(14)
}
printHtmlPart(16)
if(true && (act == '4')) {
printHtmlPart(14)
invokeTag('render','g',92,['template':("createReport4")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
invokeTag('hiddenField','g',97,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',98,['name':("applicantName"),'value':(fullName)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',100,['name':("periodicInstance"),'value':(periodicReportInstance?.id)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',102,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',103,['name':("formType"),'value':(act)],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',106,['action':("applicantDash"),'controller':("applicant"),'params':([csrfPreventionSalt:csrfPreventionSalt]),'class':("btn btn-primary pull-right"),'style':("margin-bottom: 5px;")],3)
printHtmlPart(21)
invokeTag('actionSubmit','g',110,['name':("Send"),'value':("Send"),'action':("savePeriodicReport"),'style':("margin-bottom: 5px; margin-right:5px; display:none"),'id':("submi"),'class':("btn btn-primary pull-right")],-1)
printHtmlPart(22)
})
invokeTag('form','g',112,['controller':("applicant"),'action':("savePeriodicReport"),'enctype':("multipart/form-data"),'method':("Post")],2)
printHtmlPart(23)
invokeTag('render','g',116,['template':("/applicant/rightPane")],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',196,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649389548671L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
