import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_form3Periodic_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_form3Periodic.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(5)
expressionOut.print(periodicReportInstance?.periodFrom)
printHtmlPart(6)
expressionOut.print(periodicReportInstance?.periodTo)
printHtmlPart(7)
expressionOut.print(periodicReportInstance?.country)
printHtmlPart(8)
expressionOut.print(periodicReportInstance?.pan)
printHtmlPart(8)
expressionOut.print(periodicReportInstance?.status)
printHtmlPart(9)
if(true && (periodicReportInstance)) {
printHtmlPart(10)
loop:{
int i = 0
for( mode in (periodicReportInstance?.mods) ) {
printHtmlPart(11)
invokeTag('checkBox','g',55,['name':("mod"),'value':(mode),'readonly':("readonly")],-1)
expressionOut.print(mode)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(periodicReportInstance?.daac)
printHtmlPart(15)
if(true && (periodicReportInstance)) {
printHtmlPart(16)
for( file in (periodicReportInstance?.periodicFiles) ) {
printHtmlPart(17)
expressionOut.print(file?.fileName)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(periodicReportInstance?.feeReceived)
printHtmlPart(21)
if(true && (periodicReportInstance)) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('formatDate','g',89,['format':("dd/MM/yyyy hh:mm  aa"),'date':(new Date())],-1)
printHtmlPart(25)
expressionOut.print(periodicReportInstance?.place)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649395805598L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
