
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_accountPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_accountPdfGenerator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',25,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',25,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',34,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(7)
}
printHtmlPart(6)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(8)
}
printHtmlPart(6)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(12)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(13)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(14)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(15)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(16)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(19)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(20)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(21)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(22)
expressionOut.print(individualProfile?.title)
printHtmlPart(23)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(23)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(23)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(21)
}
printHtmlPart(24)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(21)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(23)
expressionOut.print(company?.entityName)
printHtmlPart(21)
k++
}
}
printHtmlPart(24)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(21)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(22)
expressionOut.print(researcher?.title)
printHtmlPart(23)
expressionOut.print(researcher?.firstName)
printHtmlPart(23)
expressionOut.print(researcher?.middleName)
printHtmlPart(23)
expressionOut.print(researcher?.lastName)
printHtmlPart(25)
}
printHtmlPart(24)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(21)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(23)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(21)
}
printHtmlPart(24)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(21)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(23)
expressionOut.print(govt?.govtInstName)
printHtmlPart(21)
}
printHtmlPart(24)
}
printHtmlPart(26)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(27)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(28)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(29)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(30)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(31)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(formDetails?.transaction?.transactionId)
printHtmlPart(34)
expressionOut.print(accountRemark?.trsnsRemark)
printHtmlPart(35)
expressionOut.print(formDetails?.transaction?.paymentRefNo)
printHtmlPart(36)
expressionOut.print(accountRemark?.paymentRemark)
printHtmlPart(37)
expressionOut.print(formDetails?.transaction?.fee)
printHtmlPart(38)
expressionOut.print(accountRemark?.paymentReceivedRemark)
printHtmlPart(39)
expressionOut.print(formDetails?.transaction?.fee)
printHtmlPart(38)
expressionOut.print(accountRemark?.feeRemark)
printHtmlPart(40)
expressionOut.print(accountRemark?.paymentType)
printHtmlPart(41)
expressionOut.print(accountRemark?.others)
printHtmlPart(42)
if(true && (accountRemark?.txnDetailsInOrder == true)) {
printHtmlPart(43)
}
else if(true && (accountRemark?.txnDetailsInOrder == false)) {
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(accountRemark?.txnDetailsRemark)
printHtmlPart(46)
if(true && (accountRemark?.mcdWithBakStatement == true)) {
printHtmlPart(43)
}
else if(true && (accountRemark?.mcdWithBakStatement == false)) {
printHtmlPart(47)
}
printHtmlPart(48)
expressionOut.print(accountRemark?.mcdBakStatementRemark)
printHtmlPart(49)
expressionOut.print(accountRemark?.question)
printHtmlPart(50)
if(true && (accountRemark != null || accountRemark != '')) {
printHtmlPart(51)
loop:{
int k = 0
for( quesAnswer in (accountRemark?.questionAnswers) ) {
printHtmlPart(52)
expressionOut.print(k+11)
printHtmlPart(53)
expressionOut.print(quesAnswer?.question)
printHtmlPart(54)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(55)
k++
}
}
printHtmlPart(56)
}
printHtmlPart(57)
})
invokeTag('captureBody','sitemesh',306,[:],1)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616173974L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
