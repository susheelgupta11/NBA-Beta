import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunication_tr5_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/_tr5.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (tr5ReceiptInstance)) {
printHtmlPart(1)
invokeTag('set','g',3,['value':(tr5ReceiptInstance?.dated),'var':("dated")],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',6,['value':(new Date()),'var':("dated")],-1)
printHtmlPart(0)
}
printHtmlPart(2)
if(true && (tr5ReceiptInstance)) {
printHtmlPart(0)
invokeTag('set','g',11,['value':(tr5ReceiptInstance?.emailId),'var':("emailId")],-1)
printHtmlPart(0)
}
else {
printHtmlPart(0)
invokeTag('set','g',14,['value':(formDetails?.submittedBy?.email),'var':("emailId")],-1)
printHtmlPart(0)
}
printHtmlPart(3)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(1)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(4)
invokeTag('set','g',20,['var':("name"),'value':("${individualProfile?.title?: ''} ${individualProfile?.firstName?:''} ${individualProfile?.middleName?:''} ${individualProfile?.lastName?:''}")],-1)
printHtmlPart(1)
}
printHtmlPart(0)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(1)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(4)
invokeTag('set','g',25,['value':(company?.entityName),'var':("name")],-1)
printHtmlPart(1)
k++
}
}
printHtmlPart(0)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(1)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(4)
invokeTag('set','g',31,['var':("name"),'value':("${researcher?.title ?:''}${researcher?.firstName?: ''}${researcher?.middleName?:''}${researcher?.lastName?:''}")],-1)
printHtmlPart(1)
}
printHtmlPart(0)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(1)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(4)
invokeTag('set','g',36,['value':(depost?.nameOfDepositor),'var':("name")],-1)
printHtmlPart(1)
}
printHtmlPart(0)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(1)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(4)
invokeTag('set','g',41,['value':(govt?.govtInstName),'var':("name")],-1)
printHtmlPart(1)
}
printHtmlPart(0)
}
printHtmlPart(5)
expressionOut.print(emailId)
printHtmlPart(6)
invokeTag('select','g',79,['name':("ccEmailId"),'from':(ccEmailList?.email),'value':(tr5ReceiptInstance?.ccEmailId),'noSelection':(['':'-Choose email for cc-']),'required':("required")],-1)
printHtmlPart(7)
expressionOut.print(tr5ReceiptInstance?.subject)
printHtmlPart(8)
if(true && (tr5ReceiptInstance == null || tr5ReceiptInstance == '')) {
printHtmlPart(9)
expressionOut.print(eReceipt)
printHtmlPart(9)
}
else if(true && ("tr5ReceiptInstance")) {
printHtmlPart(9)
expressionOut.print(tr5ReceiptInstance?.receiptNo)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('hiddenField','g',119,['name':("date"),'value':(new Date())],-1)
printHtmlPart(11)
invokeTag('formatDate','g',124,['format':("dd/MM/yyyy"),'date':(new Date())],-1)
printHtmlPart(12)
expressionOut.print(name)
printHtmlPart(13)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(14)
expressionOut.print(tr5ReceiptInstance?.letterNo)
printHtmlPart(15)
invokeTag('datePicker','g',138,['name':("dated"),'value':(dated),'noSelection':(['':'-Choose-']),'precision':("day")],-1)
printHtmlPart(16)
expressionOut.print(tr5ReceiptInstance?.sumOfRupees)
printHtmlPart(17)
expressionOut.print(tr5ReceiptInstance?.moneyInWords)
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(19)
expressionOut.print(it.radio)
printHtmlPart(20)
expressionOut.print(it.label)
printHtmlPart(21)
})
invokeTag('radioGroup','g',149,['name':("paymentFor"),'value':(tr5ReceiptInstance?.paymentFor),'labels':(['Applicant Fee','Benefit Sharing']),'values':(['Applicant Fee','Benefit Sharing'])],1)
printHtmlPart(22)
createTagBody(1, {->
printHtmlPart(19)
expressionOut.print(it.radio)
printHtmlPart(20)
expressionOut.print(it.label)
printHtmlPart(21)
})
invokeTag('radioGroup','g',158,['name':("paymentType"),'value':(tr5ReceiptInstance?.paymentType),'id':("pay"),'labels':(['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT']),'values':(['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT'])],1)
printHtmlPart(23)
expressionOut.print(tr5ReceiptInstance?.accountOF)
printHtmlPart(24)
expressionOut.print(tr5ReceiptInstance?.paymentOf)
printHtmlPart(25)
if(true && (tr5ReceiptInstance?.pdfFileAttachments)) {
printHtmlPart(26)
for( attachmentPdf in (tr5ReceiptInstance?.pdfFileAttachments) ) {
printHtmlPart(27)
createTagBody(3, {->
printHtmlPart(28)
expressionOut.print(attachmentPdf?.pdfName)
printHtmlPart(29)
})
invokeTag('link','g',193,['controller':("dashboard"),'action':("communicationShowPdf"),'target':("_blank"),'params':([showId:attachmentPdf?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',203,['action':("deleteCommunicationPdf"),'params':([deleteId:attachmentPdf?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm('Are you sure?');")],3)
printHtmlPart(32)
}
printHtmlPart(33)
}
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1653370105819L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
