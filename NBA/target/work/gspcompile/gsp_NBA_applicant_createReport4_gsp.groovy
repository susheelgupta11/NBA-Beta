import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_createReport4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_createReport4.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (periodicReportInstance)) {
printHtmlPart(0)
}
printHtmlPart(1)
if(true && (periodicReportInstance?.haveTransfer)) {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (periodicReportInstance?.dbsapAgree)) {
printHtmlPart(4)
}
printHtmlPart(1)
if(true && (periodicReportInstance?.haveTransferredBiological)) {
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('hiddenField','g',37,['name':("appNumber"),'value':(formDetails?.id)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',38,['name':("applicantName"),'value':(fullName)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',40,['name':("periodicInstance"),'value':(periodicReportInstance?.id)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',42,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',43,['name':("formType"),'value':("createReport4")],-1)
printHtmlPart(8)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(9)
expressionOut.print(fullName)
printHtmlPart(10)
invokeTag('textField','g',84,['name':("dtsTransferee"),'value':(periodicReportInstance?.dtsTransferee),'style':("width:100%")],-1)
printHtmlPart(11)
if(true && (periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck)) {
printHtmlPart(12)
invokeTag('radio','g',92,['name':("trnsBioCheck"),'id':("yesBo"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(13)
invokeTag('radio','g',94,['name':("trnsBioCheck"),'id':("noBo"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(14)
}
else if(true && (periodicReportInstance?.trnsBioCheck == 'Yes')) {
printHtmlPart(12)
invokeTag('radio','g',99,['name':("trnsBioCheck"),'id':("yesBo"),'checked':("checked"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(13)
invokeTag('radio','g',101,['name':("trnsBioCheck"),'id':("noBo"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(14)
}
else {
printHtmlPart(12)
invokeTag('radio','g',105,['name':("trnsBioCheck"),'id':("yesBo"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(13)
invokeTag('radio','g',107,['name':("trnsBioCheck"),'id':("noBo"),'checked':("checked"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('textField','g',112,['name':("haveTransferredBiological"),'placeholder':("Please provide the details"),'id':("transBio"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.haveTransferredBiological)],-1)
printHtmlPart(16)
invokeTag('textField','g',118,['name':("dtsQuantityTfr"),'value':(periodicReportInstance?.dtsQuantityTfr),'style':("width:100%")],-1)
printHtmlPart(17)
if(true && (periodicReportInstance?.haveTrsfCheck == '' || periodicReportInstance?.haveTrsfCheck == null)) {
printHtmlPart(12)
invokeTag('radio','g',127,['name':("haveTrsfCheck"),'id':("yesApp"),'value':("Yes"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(13)
invokeTag('radio','g',129,['name':("haveTrsfCheck"),'id':("noApp"),'value':("No"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(14)
}
else if(true && (periodicReportInstance?.haveTrsfCheck == 'Yes')) {
printHtmlPart(12)
invokeTag('radio','g',134,['name':("haveTrsfCheck"),'id':("yesApp"),'checked':("checked"),'value':("Yes"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(18)
invokeTag('radio','g',136,['name':("haveTrsfCheck"),'id':("noApp"),'value':("No"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(14)
}
else {
printHtmlPart(12)
invokeTag('radio','g',140,['name':("haveTrsfCheck"),'id':("yesApp"),'value':("Yes"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(13)
invokeTag('radio','g',142,['name':("haveTrsfCheck"),'id':("noApp"),'value':("No"),'checked':("checked"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('textField','g',147,['name':("haveTransfer"),'placeholder':("Please provide the details"),'id':("haveA"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.haveTransfer)],-1)
printHtmlPart(19)
if(true && (periodicReportInstance?.dbsapCheck == '' || periodicReportInstance?.dbsapCheck == null)) {
printHtmlPart(12)
invokeTag('radio','g',156,['name':("dbsapCheck"),'id':("yesTra"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(13)
invokeTag('radio','g',158,['name':("dbsapCheck"),'id':("noTra"),'value':("No"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(14)
}
else if(true && (periodicReportInstance?.dbsapCheck == 'Yes')) {
printHtmlPart(12)
invokeTag('radio','g',163,['name':("dbsapCheck"),'id':("yesTra"),'checked':("checked"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(18)
invokeTag('radio','g',165,['name':("dbsapCheck"),'id':("noTra"),'value':("No"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(14)
}
else {
printHtmlPart(12)
invokeTag('radio','g',169,['name':("dbsapCheck"),'id':("yesTra"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(13)
invokeTag('radio','g',171,['name':("dbsapCheck"),'id':("noTra"),'value':("No"),'checked':("checked"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('textField','g',176,['name':("dbsapAgree"),'placeholder':("Please provide the details"),'id':("transf"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.dbsapAgree)],-1)
printHtmlPart(20)
if(true && (periodicReportInstance)) {
printHtmlPart(21)
for( file in (periodicReportInstance?.periodicFiles) ) {
printHtmlPart(22)
expressionOut.print(file?.fileName)
printHtmlPart(23)
}
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (periodicReportInstance)) {
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('formatDate','g',216,['format':("dd/MM/yyyy hh:mm  aa"),'date':(new Date())],-1)
printHtmlPart(30)
invokeTag('textField','g',218,['name':("place"),'value':(periodicReportInstance?.place)],-1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649405037006L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
