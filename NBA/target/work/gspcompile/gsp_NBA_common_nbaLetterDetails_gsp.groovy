
import org.nba.communication.LetterType

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_common_nbaLetterDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/common/_nbaLetterDetails.gsp" }
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
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
if(true && (letterDetails?.letterType?.ltrType == LetterType.LtrType.TR5_LETTER)) {
printHtmlPart(4)
if(true && (letterDetails)) {
printHtmlPart(5)
invokeTag('set','g',16,['value':(letterDetails?.dated),'var':("dated")],-1)
printHtmlPart(0)
}
else {
printHtmlPart(5)
invokeTag('set','g',19,['value':(new Date()),'var':("dated")],-1)
printHtmlPart(0)
}
printHtmlPart(6)
expressionOut.print(letterDetails?.receiptNo)
printHtmlPart(7)
invokeTag('formatDate','g',46,['format':("dd/MM/yyyy"),'date':(letterDetails?.createdDate)],-1)
printHtmlPart(8)
expressionOut.print(letterDetails?.applicantName)
printHtmlPart(9)
expressionOut.print(letterDetails?.appNumber)
printHtmlPart(10)
expressionOut.print(letterDetails?.letterNo)
printHtmlPart(11)
invokeTag('datePicker','g',60,['name':("dated"),'value':(letterDetails?.dated),'noSelection':(['':'-Choose-']),'precision':("day")],-1)
printHtmlPart(12)
expressionOut.print(letterDetails?.sumOfRupees)
printHtmlPart(13)
expressionOut.print(letterDetails?.moneyInWords)
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
expressionOut.print(it.radio)
printHtmlPart(16)
expressionOut.print(it.label)
printHtmlPart(17)
})
invokeTag('radioGroup','g',72,['name':("paymentFor"),'value':(letterDetails?.paymentFor),'labels':(['Applicant Fee','Benefit Sharing']),'values':(['Applicant Fee','Benefit Sharing'])],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(15)
expressionOut.print(it.radio)
printHtmlPart(16)
expressionOut.print(it.label)
printHtmlPart(17)
})
invokeTag('radioGroup','g',81,['name':("paymentType"),'value':(letterDetails?.paymentType),'id':("pay"),'labels':(['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT']),'values':(['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT'])],3)
printHtmlPart(19)
expressionOut.print(letterDetails?.accountOF)
printHtmlPart(20)
expressionOut.print(letterDetails?.paymentOf)
printHtmlPart(21)
}
else {
printHtmlPart(22)
expressionOut.print(letterDetails?.dynamicLetterNumberNbaOUT)
printHtmlPart(23)
invokeTag('formatDate','g',106,['format':("dd/MM/yyyy"),'date':(letterDetails?.sendDate)],-1)
printHtmlPart(24)
if(true && (appForm1)) {
printHtmlPart(25)
if(true && (appForm1.individualProfiles)) {
printHtmlPart(0)
for( indi in (appForm1.individualProfiles) ) {
printHtmlPart(26)
expressionOut.print(indi?.title)
printHtmlPart(27)
expressionOut.print(indi?.firstName)
printHtmlPart(27)
expressionOut.print(indi?.middleName)
printHtmlPart(27)
expressionOut.print(indi?.lastName)
printHtmlPart(28)
expressionOut.print(indi?.address1)
printHtmlPart(27)
expressionOut.print(indi?.address2)
printHtmlPart(27)
expressionOut.print(indi?.address3)
printHtmlPart(29)
expressionOut.print(indi?.email)
printHtmlPart(30)
}
printHtmlPart(0)
}
printHtmlPart(31)
if(true && (appForm1?.companyProfiles)) {
printHtmlPart(0)
for( com in (appForm1?.companyProfiles) ) {
printHtmlPart(26)
expressionOut.print(com?.entityName)
printHtmlPart(32)
expressionOut.print(com?.address1)
printHtmlPart(27)
expressionOut.print(com?.address2)
printHtmlPart(27)
expressionOut.print(com?.address3)
printHtmlPart(29)
expressionOut.print(com?.email)
printHtmlPart(30)
}
printHtmlPart(0)
}
printHtmlPart(25)
if(true && (appForm1?.indianResearcher)) {
printHtmlPart(0)
for( ir in (appForm1?.indianResearcher) ) {
printHtmlPart(26)
expressionOut.print(ir?.title ?:'')
expressionOut.print(ir?.firstName?: '')
expressionOut.print(ir?.middleName?:'')
expressionOut.print(ir?.lastName?:'')
printHtmlPart(32)
expressionOut.print(ir?.designation)
printHtmlPart(33)
expressionOut.print(ir?.address1)
printHtmlPart(27)
expressionOut.print(ir?.address2)
printHtmlPart(27)
expressionOut.print(ir?.address3)
printHtmlPart(29)
expressionOut.print(ir?.email)
printHtmlPart(30)
}
printHtmlPart(0)
}
printHtmlPart(25)
if(true && (appForm1?.depostionOfMicroOrganism)) {
printHtmlPart(0)
for( dm in (appForm1?.depostionOfMicroOrganism) ) {
printHtmlPart(26)
expressionOut.print(dm?.nameOfDepositor)
printHtmlPart(32)
expressionOut.print(dm?.address1)
printHtmlPart(27)
expressionOut.print(dm?.address2)
printHtmlPart(27)
expressionOut.print(dm?.address3)
printHtmlPart(29)
expressionOut.print(dm?.email)
printHtmlPart(30)
}
printHtmlPart(0)
}
printHtmlPart(25)
if(true && (appForm1?.indianGovtInst)) {
printHtmlPart(0)
for( ig in (appForm1?.indianGovtInst) ) {
printHtmlPart(26)
expressionOut.print(ig?.govtInstName)
printHtmlPart(32)
expressionOut.print(ig?.designation)
printHtmlPart(33)
expressionOut.print(ig?.address1)
printHtmlPart(27)
expressionOut.print(ig?.address2)
printHtmlPart(27)
expressionOut.print(ig?.address3)
printHtmlPart(29)
expressionOut.print(ig?.email)
printHtmlPart(30)
}
printHtmlPart(0)
}
printHtmlPart(0)
}
printHtmlPart(34)
expressionOut.print(letterDetails?.subject)
printHtmlPart(35)
expressionOut.print(raw(letterDetails?.messageBody))
printHtmlPart(36)
expressionOut.print(letterDetails?.emailId)
printHtmlPart(37)
expressionOut.print(letterDetails?.ccEmailId)
printHtmlPart(38)
invokeTag('formatDate','g',176,['format':("dd/MM/yyyy"),'date':(letterDetails?.createdDate)],-1)
printHtmlPart(39)
invokeTag('formatDate','g',178,['format':("dd/MM/yyyy"),'date':(letterDetails?.approvedDate)],-1)
printHtmlPart(40)
expressionOut.print(letterDetails?.createdBy)
printHtmlPart(41)
expressionOut.print(letterDetails?.sendBy)
printHtmlPart(42)
}
printHtmlPart(43)
})
invokeTag('captureBody','sitemesh',188,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671615936358L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
