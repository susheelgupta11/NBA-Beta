
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklistshowAccountData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/showAccountData.gsp" }
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
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (accountRemarkInstance?.txnDetailsInOrder == false)) {
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('javascript','g',23,[:],3)
printHtmlPart(7)
}
printHtmlPart(7)
if(true && (accountRemarkInstance?.mcdWithBakStatement == false)) {
printHtmlPart(5)
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',28,[:],3)
printHtmlPart(7)
}
printHtmlPart(7)
if(true && (accountRemarkInstance?.paymentType == 'Others')) {
printHtmlPart(5)
createClosureForHtmlPart(9, 3)
invokeTag('javascript','g',33,[:],3)
printHtmlPart(7)
}
printHtmlPart(10)
if(true && (message)) {
printHtmlPart(11)
expressionOut.print(message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(15)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(16)
expressionOut.print(individualProfile?.title)
printHtmlPart(17)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(17)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(17)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(18)
}
printHtmlPart(19)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(18)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(17)
expressionOut.print(company?.entityName)
printHtmlPart(18)
k++
}
}
printHtmlPart(19)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(18)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(16)
expressionOut.print(researcher?.title)
printHtmlPart(17)
expressionOut.print(researcher?.firstName)
printHtmlPart(17)
expressionOut.print(researcher?.middleName)
printHtmlPart(17)
expressionOut.print(researcher?.lastName)
printHtmlPart(20)
}
printHtmlPart(19)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(18)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(17)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(18)
}
printHtmlPart(19)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(18)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(17)
expressionOut.print(govt?.govtInstName)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(21)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(22)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(23)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(24)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(25)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(26)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(formDetails?.transaction?.transactionId)
printHtmlPart(29)
invokeTag('textField','g',133,['class':("remark"),'name':("trsnsRemark"),'value':(accountRemarkInstance?.trsnsRemark)],-1)
printHtmlPart(30)
expressionOut.print(formDetails?.transaction?.paymentRefNo)
printHtmlPart(29)
invokeTag('textField','g',143,['class':("remark"),'name':("paymentRemark"),'value':(accountRemarkInstance?.paymentRemark)],-1)
printHtmlPart(31)
expressionOut.print(formDetails?.transaction?.fee)
printHtmlPart(32)
invokeTag('textField','g',152,['class':("remark"),'name':("paymentReceivedRemark"),'value':(accountRemarkInstance?.paymentReceivedRemark)],-1)
printHtmlPart(33)
expressionOut.print(formDetails?.transaction?.fee)
printHtmlPart(32)
invokeTag('textField','g',161,['class':("remark"),'name':("feeRemark"),'value':(accountRemarkInstance?.feeRemark)],-1)
printHtmlPart(34)
invokeTag('select','g',172,['class':("remark"),'from':(paymentType),'name':("pymtType"),'id':("dropdn"),'onchange':("showTextBox();"),'value':(accountRemarkInstance?.paymentType),'noSelection':(['':'Select Payment Type'])],-1)
printHtmlPart(35)
invokeTag('textArea','g',177,['name':("remarkPayment"),'id':("otherText"),'style':("visibility: hidden"),'value':(accountRemarkInstance?.others)],-1)
printHtmlPart(36)
if(true && (accountRemarkInstance?.txnDetailsInOrder == null)) {
printHtmlPart(37)
invokeTag('radio','g',189,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true")],-1)
printHtmlPart(38)
invokeTag('radio','g',197,['id':("noUn"),'name':("txnCofm"),'value':("false"),'onclick':("showText();")],-1)
printHtmlPart(39)
}
else if(true && (accountRemarkInstance?.txnDetailsInOrder == true)) {
printHtmlPart(37)
invokeTag('radio','g',205,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true"),'checked':("checked")],-1)
printHtmlPart(38)
invokeTag('radio','g',212,['id':("noUn"),'name':("txnCofm"),'value':("false"),'onclick':("showText();")],-1)
printHtmlPart(40)
}
else if(true && (accountRemarkInstance?.txnDetailsInOrder == false)) {
printHtmlPart(37)
invokeTag('radio','g',218,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true")],-1)
printHtmlPart(41)
invokeTag('radio','g',224,['id':("noUn"),'name':("txnCofm"),'value':("false"),'checked':("checked"),'onclick':("showText();")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(37)
invokeTag('radio','g',229,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true")],-1)
printHtmlPart(41)
invokeTag('radio','g',235,['id':("noUn"),'name':("txnCofm"),'value':("false"),'onclick':("showText();")],-1)
printHtmlPart(40)
}
printHtmlPart(42)
invokeTag('textArea','g',242,['class':("remark"),'name':("remark"),'id':("rem"),'style':("display: none;"),'value':(accountRemarkInstance?.txnDetailsRemark)],-1)
printHtmlPart(43)
if(true && (accountRemarkInstance?.mcdWithBakStatement == null)) {
printHtmlPart(37)
invokeTag('radio','g',253,['name':("mcdBnk"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',258,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM")],-1)
printHtmlPart(40)
}
else if(true && (accountRemarkInstance?.mcdWithBakStatement == true)) {
printHtmlPart(37)
invokeTag('radio','g',266,['name':("mcdBnk"),'checked':("checked"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',270,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM")],-1)
printHtmlPart(40)
}
else if(true && (accountRemarkInstance?.mcdWithBakStatement == false)) {
printHtmlPart(37)
invokeTag('radio','g',277,['name':("mcdBnk"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',283,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM"),'checked':("checked")],-1)
printHtmlPart(39)
}
else {
printHtmlPart(37)
invokeTag('radio','g',289,['name':("mcdBnk"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',294,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM")],-1)
printHtmlPart(39)
}
printHtmlPart(44)
invokeTag('textArea','g',303,['name':("remarkBnk"),'id':("remarkM"),'style':("display: none;"),'class':("remark"),'value':(accountRemarkInstance?.mcdBakStatementRemark)],-1)
printHtmlPart(45)
if(true && (accountRemarkInstance != null || accountRemarkInstance != '')) {
printHtmlPart(46)
loop:{
int k = 0
for( quesAnswer in (accountRemarkInstance?.questionAnswers) ) {
printHtmlPart(47)
expressionOut.print(k+1)
printHtmlPart(48)
expressionOut.print(k+1)
printHtmlPart(49)
expressionOut.print(k+11)
printHtmlPart(50)
invokeTag('textArea','g',321,['name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("40")],-1)
printHtmlPart(51)
invokeTag('textArea','g',325,['name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("40")],-1)
printHtmlPart(52)
expressionOut.print(k+1)
printHtmlPart(53)
expressionOut.print(quesAnswer?.id)
printHtmlPart(54)
expressionOut.print(k+1)
printHtmlPart(55)
expressionOut.print(quesAnswer?.id)
printHtmlPart(56)
k++
}
}
printHtmlPart(57)
}
printHtmlPart(58)
createClosureForHtmlPart(59, 3)
invokeTag('link','g',339,['action':("accountCheckList"),'class':("btn btn-primary pull-right"),'controller':("checklist"),'target':("_blank"),'params':([accountInstance:accountRemarkInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(60)
invokeTag('actionSubmit','g',345,['type':("button"),'class':("btn btn-primary pull-right"),'value':("Update"),'name':("Update"),'action':("saveAccountNote"),'style':("margin-right:10px")],-1)
printHtmlPart(61)
invokeTag('hiddenField','g',347,['name':("accountRemarkInstance"),'value':(accountRemarkInstance?.id)],-1)
printHtmlPart(57)
invokeTag('hiddenField','g',347,['name':("instance"),'value':(formDetails?.id)],-1)
printHtmlPart(57)
invokeTag('hiddenField','g',350,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(62)
})
invokeTag('form','g',350,['name':("checklistNote"),'controller':("checklist"),'action':("saveAccountNote")],2)
printHtmlPart(63)
invokeTag('render','g',353,['template':("/rightPane/matchdata")],-1)
printHtmlPart(64)
})
invokeTag('captureBody','sitemesh',354,[:],1)
printHtmlPart(65)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1644832777419L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
