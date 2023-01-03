import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_benefitSharingreceivedBenefit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/benefitSharing/receivedBenefit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('textField','g',73,['name':("appNumber"),'value':(formDetails?.appNumber)],-1)
printHtmlPart(6)
expressionOut.print(formDetails?.category.category)
printHtmlPart(6)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(7)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(8)
expressionOut.print(individualProfile?.title)
printHtmlPart(9)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(9)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(9)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(10)
invokeTag('set','g',86,['var':("bsName"),'value':("${individualProfile?.title} ${individualProfile?.firstName} ${individualProfile?.middleName} ${individualProfile?.lastName}")],-1)
printHtmlPart(7)
}
printHtmlPart(11)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(7)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(9)
expressionOut.print(company?.entityName)
printHtmlPart(12)
invokeTag('set','g',91,['var':("bsName"),'value':(company?.entityName)],-1)
printHtmlPart(13)
k++
}
}
printHtmlPart(11)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(7)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(8)
expressionOut.print(researcher?.title)
printHtmlPart(9)
expressionOut.print(researcher?.firstName)
printHtmlPart(9)
expressionOut.print(researcher?.middleName)
printHtmlPart(9)
expressionOut.print(researcher?.lastName)
printHtmlPart(14)
invokeTag('set','g',104,['var':("bsName"),'value':("${researcher?.title} ${researcher?.firstName} ${researcher?.middleName} ${researcher?.lastName}")],-1)
printHtmlPart(15)
}
printHtmlPart(11)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(7)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(9)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(16)
invokeTag('set','g',113,['var':("bsName"),'value':(depost?.nameOfDepositor)],-1)
printHtmlPart(7)
}
printHtmlPart(11)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(7)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(16)
expressionOut.print(govt?.govtInstName)
printHtmlPart(9)
invokeTag('set','g',120,['var':("bsName"),'value':(govt?.govtInstName)],-1)
printHtmlPart(7)
}
printHtmlPart(11)
}
printHtmlPart(6)
invokeTag('textField','g',123,['name':("transNumber"),'value':(benefitInstance?.transNumber)],-1)
printHtmlPart(6)
invokeTag('select','g',125,['name':("modeOfPayment"),'from':(modeOfPayment),'value':(benefitInstance?.modeOfPayment)],-1)
printHtmlPart(17)
invokeTag('select','g',128,['name':("category"),'from':(category),'value':(benefitInstance?.category)],-1)
printHtmlPart(18)
invokeTag('textField','g',130,['name':("amountIn"),'autocomplete':("off"),'onmouseout':("factor(this)"),'onkeypress':("return isNumber(event)"),'value':(benefitInstance?.amountIn),'required':("required")],-1)
printHtmlPart(19)
invokeTag('textField','g',157,['name':("tr5ReceiptNumber"),'value':(benefitInstance?.tr5ReceiptNumber)],-1)
printHtmlPart(20)
expressionOut.print(benefitInstance?.dateBenefit)
printHtmlPart(21)
invokeTag('select','g',167,['name':("typeOfSharing"),'from':(typeOfSharing),'value':(benefitInstance?.typeOfSharing)],-1)
printHtmlPart(18)
invokeTag('textField','g',167,['name':("remarks"),'value':(benefitInstance?.remarks)],-1)
printHtmlPart(22)
expressionOut.print(message)
printHtmlPart(23)
if(true && (addMore == 'true')) {
printHtmlPart(24)
}
else if(true && (addMore == null || "" == addMore)) {
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('hiddenField','g',181,['name':("factorval"),'id':("diff")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',183,['name':("formInstance"),'value':(formDetails?.id)],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',186,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',189,['name':("bsName"),'value':(bsName)],-1)
printHtmlPart(27)
})
invokeTag('form','g',190,['action':("saveBenefitDetails"),'controller':("benefitSharing"),'enctype':("multipart/form-data"),'method':("post")],2)
printHtmlPart(28)
if(true && (benefitList)) {
printHtmlPart(29)
for( benefit in (benefitList) ) {
printHtmlPart(30)
expressionOut.print(benefit?.appNumber)
printHtmlPart(31)
expressionOut.print(benefit?.applicationForm1?.category.category)
printHtmlPart(31)
expressionOut.print(benefit?.bsName)
printHtmlPart(31)
expressionOut.print(benefit?.transNumber)
printHtmlPart(31)
expressionOut.print(benefit?.modeOfPayment)
printHtmlPart(31)
expressionOut.print(benefit?.category)
printHtmlPart(31)
expressionOut.print(benefit?.amountIn)
printHtmlPart(32)

float fact1=Float.parseFloat(benefit?.amountIn)*0.95;

printHtmlPart(33)

float fact2=Float.parseFloat(benefit?.amountIn)*0.05;

printHtmlPart(34)
expressionOut.print(fact1 ?:'NA')
printHtmlPart(31)
expressionOut.print(fact2 ?:'NA')
printHtmlPart(31)
expressionOut.print(benefit?.tr5ReceiptNumber)
printHtmlPart(35)
if(true && (benefit?.periodicFiles)) {
printHtmlPart(36)
for( receiptLink in (benefit?.periodicFiles) ) {
printHtmlPart(27)
createTagBody(6, {->
expressionOut.print(receiptLink?.fileName)
})
invokeTag('link','g',236,['controller':("benefitSharing"),'action':("showTr5Receipt"),'target':("_blank"),'params':([showId:receiptLink?.id, csrfPreventionSalt:csrfPreventionSalt])],6)
printHtmlPart(37)
}
printHtmlPart(38)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
invokeTag('formatDate','g',238,['format':("dd/MM/yyyy"),'date':(benefit?.dateBenefit)],-1)
printHtmlPart(31)
expressionOut.print(benefit?.typeOfSharing)
printHtmlPart(31)
expressionOut.print(benefit?.remarks)
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
invokeTag('render','g',248,['template':("/rightPane/matchdata")],-1)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',253,[:],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1617624201821L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
