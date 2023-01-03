import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_form4Periodic_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_form4Periodic.gsp" }
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
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(5)
expressionOut.print(periodicReportInstance?.applicantName)
printHtmlPart(6)
expressionOut.print(periodicReportInstance?.dtsTransferee)
printHtmlPart(7)
if(true && (periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck)) {
printHtmlPart(8)
}
else if(true && (periodicReportInstance?.trnsBioCheck == 'Yes')) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(periodicReportInstance?.haveTransferredBiological)
printHtmlPart(12)
expressionOut.print(periodicReportInstance?.dtsQuantityTfr)
printHtmlPart(13)
if(true && (periodicReportInstance?.haveTrsfCheck == '' || periodicReportInstance?.haveTrsfCheck == null)) {
printHtmlPart(8)
}
else if(true && (periodicReportInstance?.haveTrsfCheck == 'Yes')) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(periodicReportInstance?.haveTransfer)
printHtmlPart(14)
if(true && (periodicReportInstance?.dbsapCheck == '' || periodicReportInstance?.dbsapCheck == null)) {
printHtmlPart(15)
}
else if(true && (periodicReportInstance?.dbsapCheck == 'Yes')) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(periodicReportInstance?.dbsapAgree)
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
printHtmlPart(21)
if(true && (periodicReportInstance)) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('formatDate','g',135,['format':("dd/MM/yyyy hh:mm  aa"),'date':(new Date())],-1)
printHtmlPart(25)
invokeTag('textField','g',136,['name':("place"),'value':(periodicReportInstance?.place)],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',140,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649521524600L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
