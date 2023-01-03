import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_createReport3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_createReport3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(1)
expressionOut.print(periodicReportInstance?.periodFrom)
printHtmlPart(2)
expressionOut.print(periodicReportInstance?.periodTo)
printHtmlPart(3)
invokeTag('textField','g',31,['name':("country"),'class':("tbl-inputs"),'value':(periodicReportInstance?.country),'required':("required")],-1)
printHtmlPart(4)
invokeTag('textField','g',32,['name':("pan"),'class':("tbl-inputs"),'value':(periodicReportInstance?.pan),'required':("required")],-1)
printHtmlPart(4)
invokeTag('textField','g',33,['name':("status"),'class':("tbl-inputs"),'value':(periodicReportInstance?.status),'required':("required")],-1)
printHtmlPart(5)
if(true && (periodicReportInstance)) {
printHtmlPart(6)
loop:{
int i = 0
for( mode in (periodicReportInstance?.mods) ) {
printHtmlPart(7)
invokeTag('checkBox','g',39,['name':("mod"),'value':(mode)],-1)
expressionOut.print(mode)
printHtmlPart(8)
i++
}
}
printHtmlPart(9)
}
else {
printHtmlPart(10)
invokeTag('checkBox','g',44,['name':("mod"),'value':("Applicant is Commercialized")],-1)
printHtmlPart(11)
invokeTag('checkBox','g',45,['name':("mod"),'value':("Patent Rights Licensed")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',46,['name':("mod"),'value':("Patent Rights Assigned")],-1)
printHtmlPart(13)
invokeTag('checkBox','g',47,['name':("mod"),'value':("Not Commercialized")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('textField','g',53,['name':("daac"),'class':("tbl-inputs"),'value':(periodicReportInstance?.daac),'required':("required")],-1)
printHtmlPart(16)
if(true && (periodicReportInstance)) {
printHtmlPart(17)
for( file in (periodicReportInstance?.periodicFiles) ) {
printHtmlPart(18)
expressionOut.print(file?.fileName)
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('textField','g',79,['name':("feeReceived"),'class':("tbl-inputs"),'value':(periodicReportInstance?.feeReceived),'required':("required")],-1)
printHtmlPart(23)
if(true && (periodicReportInstance)) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('formatDate','g',94,['format':("dd/MM/yyyy hh:mm  aa"),'date':(new Date())],-1)
printHtmlPart(27)
invokeTag('textField','g',97,['name':("place"),'value':(periodicReportInstance?.place)],-1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1634144596754L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
