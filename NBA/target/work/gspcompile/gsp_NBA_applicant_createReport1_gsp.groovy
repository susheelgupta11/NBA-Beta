import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_createReport1_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_createReport1.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (periodicReportInstance)) {
printHtmlPart(1)
}
printHtmlPart(2)
if(true && (periodicReportInstance?.haveAppliedPatent)) {
printHtmlPart(3)
}
printHtmlPart(2)
if(true && (periodicReportInstance?.haveTransferredResults)) {
printHtmlPart(4)
}
printHtmlPart(2)
if(true && (periodicReportInstance?.haveTransferredBiological)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(periodicReportInstance?.periodFrom)
printHtmlPart(7)
expressionOut.print(periodicReportInstance?.periodTo)
printHtmlPart(8)
invokeTag('textField','g',64,['name':("applicationNumber"),'value':(formDetails?.appNumber),'style':("width:100%"),'readonly':("true")],-1)
printHtmlPart(9)
expressionOut.print(fullName)
printHtmlPart(10)
expressionOut.print(periodicReportInstance?.agreementSignDt)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(it.radio)
printHtmlPart(13)
expressionOut.print(it.label)
printHtmlPart(14)
})
invokeTag('radioGroup','g',89,['name':("whetherAccessedBioRes"),'value':(periodicReportInstance?.whetherAccessedBioRes),'labels':(['Yes','No']),'values':(['Yes','No'])],1)
printHtmlPart(15)
expressionOut.print(periodicReportInstance?.whenBiologicalResearch)
printHtmlPart(16)
expressionOut.print(periodicReportInstance?.whenBiologicalResearchTo)
printHtmlPart(17)
invokeTag('textField','g',110,['name':("reserchCarriedOut"),'style':("width:100%"),'value':(periodicReportInstance?.reserchCarriedOut)],-1)
printHtmlPart(18)
invokeTag('textField','g',117,['name':("briefResearchCarried"),'style':("width:100%"),'value':(periodicReportInstance?.briefResearchCarried)],-1)
printHtmlPart(19)
if(true && (periodicReportInstance?.publishCheck == '' ||  periodicReportInstance?.publishCheck == null)) {
printHtmlPart(20)
invokeTag('radio','g',125,['name':("publishCheck"),'id':("yesPub"),'value':("Yes"),'onclick':("fileUpload(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',128,['name':("publishCheck"),'id':("noPub"),'value':("No"),'onclick':("fileUpload(this)")],-1)
printHtmlPart(22)
}
else if(true && (periodicReportInstance?.publishCheck == 'Yes')) {
printHtmlPart(23)
invokeTag('radio','g',134,['name':("publishCheck"),'id':("yesPub"),'value':("Yes"),'checked':("checked"),'onclick':("fileUpload(this)")],-1)
printHtmlPart(24)
invokeTag('radio','g',136,['name':("publishCheck"),'id':("noPub"),'value':("No"),'onclick':("fileUpload(this)")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(23)
invokeTag('radio','g',140,['name':("publishCheck"),'id':("yesPub"),'value':("Yes"),'onclick':("fileUpload(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',142,['name':("publishCheck"),'id':("noPub"),'value':("No"),'checked':("checked"),'onclick':("fileUpload(this)")],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (periodicReportInstance?.fileName)) {
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(27)
expressionOut.print(periodicReportInstance?.fileName)
printHtmlPart(23)
})
invokeTag('link','g',149,['controller':("applicant"),'action':("showPublishPdf"),'target':("_blank"),'params':([publishId:periodicReportInstance?.id,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',155,['controller':("applicant"),'action':("deletePublishPdf"),'params':([formId:formDetails?.id, publishId:periodicReportInstance?.id,csrfPreventionSalt:csrfPreventionSalt,act:'createReport1']),'onclick':("return confirm('Are you sure to delete this file?');")],2)
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (periodicReportInstance?.haveAppliedCheck == '' || periodicReportInstance?.haveAppliedCheck == null)) {
printHtmlPart(23)
invokeTag('radio','g',169,['name':("haveAppliedCheck"),'id':("yesApp"),'value':("Yes"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',170,['name':("haveAppliedCheck"),'id':("noApp"),'value':("No"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(25)
}
else if(true && (periodicReportInstance?.haveAppliedCheck == 'Yes')) {
printHtmlPart(23)
invokeTag('radio','g',175,['name':("haveAppliedCheck"),'id':("yesApp"),'checked':("checked"),'value':("Yes"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(24)
invokeTag('radio','g',178,['name':("haveAppliedCheck"),'id':("noApp"),'value':("No"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(23)
invokeTag('radio','g',180,['name':("haveAppliedCheck"),'id':("yesApp"),'value':("Yes"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',184,['name':("haveAppliedCheck"),'id':("noApp"),'value':("No"),'checked':("checked"),'onclick':("displayTxt(this)")],-1)
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('textField','g',188,['name':("haveAppliedPatent"),'placeholder':("Please provide the details"),'id':("haveA"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.haveAppliedPatent)],-1)
printHtmlPart(32)
if(true && (periodicReportInstance?.haveTrsCheck == '' || null == periodicReportInstance?.haveTrsCheck)) {
printHtmlPart(23)
invokeTag('radio','g',196,['name':("haveTrsCheck"),'id':("yesTra"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',198,['name':("haveTrsCheck"),'id':("noTra"),'value':("No"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(25)
}
else if(true && (periodicReportInstance?.haveTrsCheck == 'Yes')) {
printHtmlPart(23)
invokeTag('radio','g',202,['name':("haveTrsCheck"),'id':("yesTra"),'checked':("checked"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',205,['name':("haveTrsCheck"),'id':("noTra"),'value':("No"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(23)
invokeTag('radio','g',208,['name':("haveTrsCheck"),'id':("yesTra"),'value':("Yes"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',211,['name':("haveTrsCheck"),'id':("noTra"),'value':("No"),'checked':("checked"),'onclick':("displayTrf(this)")],-1)
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('textField','g',216,['name':("haveTransferredResults"),'placeholder':("Please provide the details"),'id':("transf"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.haveTransferredResults)],-1)
printHtmlPart(33)
if(true && (periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck)) {
printHtmlPart(23)
invokeTag('radio','g',226,['name':("trnsBioCheck"),'id':("yesBo"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',228,['name':("trnsBioCheck"),'id':("noBo"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(25)
}
else if(true && (periodicReportInstance?.trnsBioCheck == 'Yes')) {
printHtmlPart(23)
invokeTag('radio','g',232,['name':("trnsBioCheck"),'id':("yesBo"),'checked':("checked"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',235,['name':("trnsBioCheck"),'id':("noBo"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(23)
invokeTag('radio','g',238,['name':("trnsBioCheck"),'id':("yesBo"),'value':("Yes"),'onclick':("displayBio(this)")],-1)
printHtmlPart(21)
invokeTag('radio','g',241,['name':("trnsBioCheck"),'id':("noBo"),'checked':("checked"),'value':("No"),'onclick':("displayBio(this)")],-1)
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('textField','g',247,['name':("haveTransferredBiological"),'placeholder':("Please provide the details"),'id':("transBio"),'style':("width:100%; display:none"),'value':(periodicReportInstance?.haveTransferredBiological)],-1)
printHtmlPart(34)
if(true && (periodicReportInstance)) {
printHtmlPart(35)
for( file in (periodicReportInstance?.periodicFiles) ) {
printHtmlPart(36)
expressionOut.print(file?.fileName)
printHtmlPart(37)
}
printHtmlPart(38)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (periodicReportInstance)) {
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
invokeTag('formatDate','g',288,['format':("dd/MM/yyyy hh:mm  aa"),'date':(new Date())],-1)
printHtmlPart(44)
invokeTag('textField','g',288,['name':("place"),'value':(periodicReportInstance?.place)],-1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1634120568154L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
