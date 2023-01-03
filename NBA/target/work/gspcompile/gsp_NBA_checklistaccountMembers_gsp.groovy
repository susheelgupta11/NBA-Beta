
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklistaccountMembers_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/accountMembers.gsp" }
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
invokeTag('javascript','g',22,[:],3)
printHtmlPart(7)
}
printHtmlPart(7)
if(true && (accountRemarkInstance?.mcdWithBakStatement == false)) {
printHtmlPart(5)
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',27,[:],3)
printHtmlPart(7)
}
printHtmlPart(7)
if(true && (accountRemarkInstance?.paymentType == 'OTHERS')) {
printHtmlPart(5)
createClosureForHtmlPart(9, 3)
invokeTag('javascript','g',32,[:],3)
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
invokeTag('textField','g',131,['class':("remark"),'name':("trsnsRemark"),'value':(accountRemarkInstance?.trsnsRemark)],-1)
printHtmlPart(30)
expressionOut.print(formDetails?.transaction?.paymentRefNo)
printHtmlPart(29)
invokeTag('textField','g',141,['class':("remark"),'name':("paymentRemark"),'value':(accountRemarkInstance?.paymentRemark)],-1)
printHtmlPart(31)
expressionOut.print(formDetails?.transaction?.fee)
printHtmlPart(32)
invokeTag('textField','g',150,['class':("remark"),'name':("paymentReceivedRemark"),'value':(accountRemarkInstance?.paymentReceivedRemark)],-1)
printHtmlPart(33)
expressionOut.print(formDetails?.transaction?.fee)
printHtmlPart(32)
invokeTag('textField','g',159,['class':("remark"),'name':("feeRemark"),'value':(accountRemarkInstance?.feeRemark)],-1)
printHtmlPart(34)
invokeTag('select','g',170,['class':("remark"),'from':(paymentType),'name':("pymtType"),'id':("dropdn"),'onchange':("showTextBox();"),'value':(accountRemarkInstance?.paymentType),'noSelection':(['':'Select Payment Type'])],-1)
printHtmlPart(35)
invokeTag('textArea','g',175,['name':("remarkPayment"),'id':("otherText"),'style':("visibility: hidden"),'value':(accountRemarkInstance?.others)],-1)
printHtmlPart(36)
if(true && (accountRemarkInstance?.txnDetailsInOrder == null)) {
printHtmlPart(37)
invokeTag('radio','g',187,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true")],-1)
printHtmlPart(38)
invokeTag('radio','g',194,['id':("noUn"),'name':("txnCofm"),'value':("false"),'onclick':("showText();")],-1)
printHtmlPart(39)
}
else if(true && (accountRemarkInstance?.txnDetailsInOrder == true)) {
printHtmlPart(37)
invokeTag('radio','g',203,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true"),'checked':("checked")],-1)
printHtmlPart(38)
invokeTag('radio','g',209,['id':("noUn"),'name':("txnCofm"),'value':("false"),'onclick':("showText();")],-1)
printHtmlPart(40)
}
else if(true && (accountRemarkInstance?.txnDetailsInOrder == false)) {
printHtmlPart(37)
invokeTag('radio','g',216,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true")],-1)
printHtmlPart(41)
invokeTag('radio','g',222,['id':("noUn"),'name':("txnCofm"),'value':("false"),'checked':("checked"),'onclick':("showText();")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(37)
invokeTag('radio','g',227,['id':("yesUn"),'onclick':("hideText();"),'name':("txnCofm"),'value':("true")],-1)
printHtmlPart(41)
invokeTag('radio','g',232,['id':("noUn"),'name':("txnCofm"),'value':("false"),'onclick':("showText();")],-1)
printHtmlPart(40)
}
printHtmlPart(42)
invokeTag('textArea','g',240,['class':("remark"),'name':("remark"),'id':("rem"),'style':("display: none;"),'value':(accountRemarkInstance?.txnDetailsRemark)],-1)
printHtmlPart(43)
if(true && (accountRemarkInstance?.mcdWithBakStatement == null)) {
printHtmlPart(37)
invokeTag('radio','g',251,['name':("mcdBnk"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',256,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM")],-1)
printHtmlPart(40)
}
else if(true && (accountRemarkInstance?.mcdWithBakStatement == true)) {
printHtmlPart(37)
invokeTag('radio','g',264,['name':("mcdBnk"),'checked':("checked"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',268,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM")],-1)
printHtmlPart(40)
}
else if(true && (accountRemarkInstance?.mcdWithBakStatement == false)) {
printHtmlPart(37)
invokeTag('radio','g',275,['name':("mcdBnk"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',280,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM"),'checked':("checked")],-1)
printHtmlPart(39)
}
else {
printHtmlPart(37)
invokeTag('radio','g',287,['name':("mcdBnk"),'value':("true"),'onclick':("hideBox();"),'id':("yesM")],-1)
printHtmlPart(41)
invokeTag('radio','g',292,['name':("mcdBnk"),'value':("false"),'onclick':("showBox();"),'id':("noM")],-1)
printHtmlPart(39)
}
printHtmlPart(42)
invokeTag('textArea','g',302,['name':("remarkBnk"),'id':("remarkM"),'class':("remark"),'style':("display: none;"),'value':(accountRemarkInstance?.mcdBakStatementRemark)],-1)
printHtmlPart(44)
invokeTag('textArea','g',311,['name':("quest"),'value':(accountRemarkInstance?.question),'style':("width: 100%; display:none;"),'class':("remark")],-1)
printHtmlPart(45)
if(true && (accountRemarkInstance == null || accountRemarkInstance == '')) {
printHtmlPart(46)
}
else {
printHtmlPart(47)
expressionOut.print(accountRemarkInstance)
printHtmlPart(48)
}
printHtmlPart(49)
invokeTag('textArea','g',326,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(50)
invokeTag('textArea','g',329,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(51)
invokeTag('actionSubmit','g',341,['type':("button"),'class':("btn btn-primary pull-right"),'value':("Save"),'name':("Save"),'action':("saveAccountNote")],-1)
printHtmlPart(52)
invokeTag('hiddenField','g',342,['name':("accountRemarkInstance"),'value':(accountRemarkInstance?.id)],-1)
printHtmlPart(53)
invokeTag('hiddenField','g',344,['name':("instance"),'value':(formDetails?.id)],-1)
printHtmlPart(53)
invokeTag('hiddenField','g',345,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(53)
invokeTag('hiddenField','g',346,['name':("counterVal"),'id':("setCounter"),'value':("")],-1)
printHtmlPart(54)
})
invokeTag('form','g',346,['name':("checklistNote"),'controller':("checklist"),'action':("saveAccountNote")],2)
printHtmlPart(55)
invokeTag('render','g',348,['template':("/rightPane/matchdata")],-1)
printHtmlPart(56)
})
invokeTag('captureBody','sitemesh',351,[:],1)
printHtmlPart(57)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1644832754986L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
