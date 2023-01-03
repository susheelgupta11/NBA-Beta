import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunication_sbbckeditor_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/_sbbckeditor.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(1)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(2)
invokeTag('set','g',6,['var':("name"),'value':("${individualProfile?.title?: ''} ${individualProfile?.firstName?:''} ${individualProfile?.middleName?:''} ${individualProfile?.lastName?:''}")],-1)
printHtmlPart(3)
invokeTag('set','g',9,['var':("address"),'value':("${individualProfile?.address1?: ''} ${individualProfile?.address2?:''} ${individualProfile?.address3?:''} ${individualProfile?.mobile?:''}")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(1)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(2)
invokeTag('set','g',16,['value':(company?.entityName),'var':("name")],-1)
printHtmlPart(1)
k++
}
}
printHtmlPart(5)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(1)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(2)
invokeTag('set','g',22,['var':("name"),'value':("${researcher?.title ?:''}${researcher?.firstName?: ''}${researcher?.middleName?:''}${researcher?.lastName?:''}")],-1)
printHtmlPart(1)
}
printHtmlPart(5)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(1)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(2)
invokeTag('set','g',27,['value':(depost?.nameOfDepositor),'var':("name")],-1)
printHtmlPart(1)
}
printHtmlPart(5)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(1)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(2)
invokeTag('set','g',32,['value':(govt?.govtInstName),'var':("name")],-1)
printHtmlPart(1)
}
printHtmlPart(5)
}
printHtmlPart(5)
invokeTag('set','g',35,['value':(new Date()),'var':("date")],-1)
printHtmlPart(6)
invokeTag('select','g',41,['name':("email"),'from':(sbbEmailIds),'onchange':("getEmailId(this.value);"),'optionKey':("email"),'optionValue':({it.name  +' '+ "<" +it.email +">"}),'noSelection':(['':' select One'])],-1)
printHtmlPart(7)
invokeTag('select','g',47,['name':("ccEm"),'from':(ccUser),'onchange':("getEmailIdCC(this.value);"),'optionKey':("email"),'optionValue':({it.name  +' '+ "<" +it.email +">"}),'noSelection':(['':' select One']),'style':("width:302px")],-1)
printHtmlPart(8)
invokeTag('select','g',54,['name':("lette"),'from':(letterTemplate),'onchange':("lettertemplete(this.value);"),'noSelection':(['':' select'])],-1)
printHtmlPart(9)
expressionOut.print(sbbConsentInstance?.emailId)
printHtmlPart(10)
expressionOut.print(sbbConsentInstance?.ccEmailId)
printHtmlPart(11)
expressionOut.print(sbbConsentInstance?.subject)
printHtmlPart(12)
invokeTag('textArea','g',111,['name':("body"),'id':("editor2"),'value':(sbbConsentInstance?.messageBody)],-1)
printHtmlPart(13)
if(true && (sbbConsentInstance?.pdfFileAttachments)) {
printHtmlPart(14)
for( attachmentPdf in (sbbConsentInstance?.pdfFileAttachments) ) {
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(attachmentPdf?.pdfName)
})
invokeTag('link','g',134,['action':("communicationFileShow"),'target':("_blank"),'params':([showId:attachmentPdf?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',137,['action':("deleteCommunicationPdf"),'params':([deleteId:attachmentPdf?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm('Are you sure?');")],3)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('hiddenField','g',140,['name':("name"),'value':(name)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',143,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',143,['name':("sbbConsentInstance"),'value':(sbbConsentInstance?.id)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',143,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1601976964000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
