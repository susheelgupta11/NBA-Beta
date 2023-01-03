import org.nba.application.FormCategory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicantshowPeriodicReport_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/showPeriodicReport.gsp" }
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
invokeTag('captureHead','sitemesh',28,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (message)) {
printHtmlPart(6)
expressionOut.print(message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (act == '1')) {
printHtmlPart(9)
invokeTag('render','g',45,['template':("createReport1")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (act == '1C')) {
printHtmlPart(9)
invokeTag('render','g',49,['template':("createReport1C")],-1)
printHtmlPart(9)
}
printHtmlPart(11)
if(true && (act == '2')) {
printHtmlPart(9)
invokeTag('render','g',52,['template':("createReport2")],-1)
printHtmlPart(9)
}
printHtmlPart(11)
if(true && (act == '3')) {
printHtmlPart(9)
invokeTag('render','g',55,['template':("createReport3")],-1)
printHtmlPart(9)
}
printHtmlPart(11)
if(true && (act == '4')) {
printHtmlPart(9)
invokeTag('render','g',58,['template':("createReport4")],-1)
printHtmlPart(9)
}
printHtmlPart(12)
invokeTag('hiddenField','g',62,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',63,['name':("applicantName"),'value':(fullName)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',65,['name':("periodicInstance"),'value':(periodicReportInstance?.id)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',67,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',68,['name':("formType"),'value':("createReport1")],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',69,['name':("formType"),'value':(act)],-1)
printHtmlPart(14)
})
invokeTag('form','g',70,['controller':("applicant"),'action':("updatePeriodicReport"),'enctype':("multipart/form-data"),'method':("Post")],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1634144810609L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
