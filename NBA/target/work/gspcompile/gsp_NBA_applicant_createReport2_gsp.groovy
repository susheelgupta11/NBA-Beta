import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_createReport2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_createReport2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (periodicReportInstance?.monetBeneftOnTrsf)) {
printHtmlPart(1)
}
printHtmlPart(2)
if(true && (periodicReportInstance?.detsOfbenefitSharing)) {
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(periodicReportInstance?.periodFrom)
printHtmlPart(5)
expressionOut.print(periodicReportInstance?.periodTo)
printHtmlPart(6)
invokeTag('textField','g',43,['name':("applicationNumber"),'value':(formDetails?.appNumber),'style':("width:100%"),'readonly':("true")],-1)
printHtmlPart(7)
expressionOut.print(fullName)
printHtmlPart(8)
expressionOut.print(periodicReportInstance?.agreementSignDt)
printHtmlPart(9)
invokeTag('textField','g',59,['name':("dtsTransferee"),'value':(periodicReportInstance?.dtsTransferee),'style':("width:100%"),'required':("required")],-1)
printHtmlPart(10)
if(true && (periodicReportInstance?.haveTrsCheck == '' || null == periodicReportInstance?.haveTrsCheck)) {
printHtmlPart(11)
invokeTag('radio','g',70,['name':("haveTrsCheck"),'id':("yesTra"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(12)
invokeTag('radio','g',72,['name':("haveTrsCheck"),'id':("noTra"),'value':("No"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(13)
}
else if(true && (periodicReportInstance?.haveTrsCheck == 'Yes')) {
printHtmlPart(11)
invokeTag('radio','g',77,['name':("haveTrsCheck"),'id':("yesTra"),'checked':("checked"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(12)
invokeTag('radio','g',79,['name':("haveTrsCheck"),'id':("noTra"),'value':("No"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(13)
}
else {
printHtmlPart(11)
invokeTag('radio','g',83,['name':("haveTrsCheck"),'id':("yesTra"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(12)
invokeTag('radio','g',85,['name':("haveTrsCheck"),'id':("noTra"),'value':("No"),'checked':("checked"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('textField','g',90,['name':("monetBeneftOnTrsf"),'placeholder':("Please provide the details"),'id':("transf"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.monetBeneftOnTrsf)],-1)
printHtmlPart(15)
if(true && (periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck)) {
printHtmlPart(11)
invokeTag('radio','g',100,['name':("trnsBioCheck"),'id':("yesBo"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(12)
invokeTag('radio','g',102,['name':("trnsBioCheck"),'id':("noBo"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(13)
}
else if(true && (periodicReportInstance?.trnsBioCheck == 'Yes')) {
printHtmlPart(11)
invokeTag('radio','g',107,['name':("trnsBioCheck"),'id':("yesBo"),'checked':("checked"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(12)
invokeTag('radio','g',109,['name':("trnsBioCheck"),'id':("noBo"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(13)
}
else {
printHtmlPart(11)
invokeTag('radio','g',113,['name':("trnsBioCheck"),'id':("yesBo"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(12)
invokeTag('radio','g',115,['name':("trnsBioCheck"),'id':("noBo"),'checked':("checked"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('textField','g',120,['name':("detsOfbenefitSharing"),'placeholder':("Please provide the details"),'id':("transBio"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.detsOfbenefitSharing)],-1)
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
if(true && (periodicReportInstance)) {
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('formatDate','g',160,['format':("dd/MM/yyyy hh:mm  aa"),'date':(new Date())],-1)
printHtmlPart(26)
invokeTag('textField','g',162,['name':("place"),'value':(periodicReportInstance?.place)],-1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1634120618536L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
