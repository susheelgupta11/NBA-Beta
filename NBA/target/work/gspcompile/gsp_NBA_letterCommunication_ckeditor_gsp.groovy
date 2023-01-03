import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunication_ckeditor_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/_ckeditor.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(0)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("name"),'value':("${individualProfile?.title?: ''} ${individualProfile?.firstName?:''} ${individualProfile?.middleName?:''} ${individualProfile?.lastName?:''}")],-1)
printHtmlPart(0)
}
printHtmlPart(2)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(0)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(1)
invokeTag('set','g',9,['value':(company?.entityName),'var':("name")],-1)
printHtmlPart(0)
k++
}
}
printHtmlPart(2)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(0)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(1)
invokeTag('set','g',15,['var':("name"),'value':("${researcher?.title ?:''} ${researcher?.firstName?: ''} ${researcher?.middleName?:''} ${researcher?.lastName?:''}")],-1)
printHtmlPart(0)
}
printHtmlPart(2)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(0)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(1)
invokeTag('set','g',20,['value':(depost?.nameOfDepositor),'var':("name")],-1)
printHtmlPart(0)
}
printHtmlPart(2)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(0)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(1)
invokeTag('set','g',25,['value':(govt?.govtInstName),'var':("name")],-1)
printHtmlPart(0)
}
printHtmlPart(2)
}
printHtmlPart(3)
invokeTag('select','g',33,['name':("lette"),'from':(letterTemplate),'onchange':("lettertemplete(this.value);"),'noSelection':(['':' select'])],-1)
printHtmlPart(4)
invokeTag('select','g',40,['name':("ccEmail"),'from':(ccEmailList),'optionKey':("email"),'optionValue':({it.name  +' '+ "<" +it.email +">"}),'noSelection':(['':' select One email Id for cc']),'onchange':("getCcEmailId(this.value);")],-1)
printHtmlPart(5)
expressionOut.print(toEmail)
printHtmlPart(6)
expressionOut.print(communicationInstance?.ccEmailId)
printHtmlPart(7)
expressionOut.print(communicationInstance?.subject)
printHtmlPart(8)
invokeTag('textArea','g',80,['name':("body"),'id':("editor2"),'value':(communicationInstance?.messageBody)],-1)
printHtmlPart(9)
if(true && (communicationInstance?.pdfFileAttachments)) {
printHtmlPart(10)
for( attachmentPdf in (communicationInstance?.pdfFileAttachments) ) {
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(attachmentPdf?.pdfName)
})
invokeTag('link','g',98,['action':("communicationFileShow"),'target':("_blank"),'params':([showId:attachmentPdf?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',107,['action':("deleteCommunicationPdf"),'params':([deleteId:attachmentPdf?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm('Are you sure?');")],3)
printHtmlPart(14)
}
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('hiddenField','g',112,['name':("communicationDetails"),'value':(communicationInstance?.id)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',113,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',113,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',115,['name':("name"),'value':(name)],-1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1665052152265L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
