import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1Part4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1Part4.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(tabStatus)
printHtmlPart(6)
expressionOut.print(appForm?.isBenefitSharing)
printHtmlPart(7)
expressionOut.print(appForm?.payBenefitSharing)
printHtmlPart(8)
})
invokeTag('javascript','g',24,[:],2)
printHtmlPart(9)
invokeTag('render','g',28,['template':("leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(12)
if(true && (!appForm.instituteParticipation)) {
printHtmlPart(13)
invokeTag('radio','g',199,['name':("instituteParticipation"),'value':("Yes"),'onclick':("AddValidation_Yes('activities')")],-1)
printHtmlPart(14)
invokeTag('radio','g',201,['name':("instituteParticipation"),'value':("No"),'onclick':("removeValidation_No('activities')")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(16)
if(true && (appForm?.instituteParticipation == 'true')) {
printHtmlPart(13)
invokeTag('radio','g',209,['checked':("checked"),'name':("instituteParticipation"),'value':("Yes"),'onclick':("AddValidation_Yes('activities')")],-1)
printHtmlPart(17)
}
else {
printHtmlPart(13)
invokeTag('radio','g',214,['name':("instituteParticipation"),'value':("Yes"),'onclick':("AddValidation_Yes('activities')")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (appForm?.instituteParticipation == 'false')) {
printHtmlPart(13)
invokeTag('radio','g',220,['class':("instituteparticipation"),'radio-check':("activities"),'checked':("checked"),'name':("instituteParticipation"),'value':("No"),'onclick':("removeValidation_No('activities')")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(13)
invokeTag('radio','g',226,['radio-check':("activities"),'name':("instituteParticipation"),'value':("No"),'onclick':("removeValidation_No('activities')")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
}
printHtmlPart(19)
invokeTag('textArea','g',238,['class':("width txtreq"),'name':("detailsOfInstitute"),'value':(appForm?.detailsOfInstitute)],-1)
printHtmlPart(20)
if(true && (appForm?.letterOfintent)) {
printHtmlPart(21)
if(true && (flash.message)) {
printHtmlPart(22)
expressionOut.print(flash.message)
printHtmlPart(23)
}
else {
printHtmlPart(24)
createTagBody(5, {->
printHtmlPart(25)
expressionOut.print(appForm?.letterOfIntentName)
printHtmlPart(24)
})
invokeTag('link','g',267,['controller':("applicationManagement"),'action':("showAppDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "letterOfIntentName", dataName: "letterOfIntentName",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(26)
}
printHtmlPart(13)
}
else {
printHtmlPart(27)
if(true && (flash.message)) {
printHtmlPart(22)
expressionOut.print(flash.message)
printHtmlPart(23)
}
printHtmlPart(28)
}
printHtmlPart(29)

int i=1

printHtmlPart(30)
for( mapKeyValue in (quesAnswerMap) ) {
printHtmlPart(31)
expressionOut.print(mapKeyValue?.getKey()?.questionNo)
printHtmlPart(32)
expressionOut.print(mapKeyValue?.getKey()?.question)
printHtmlPart(33)
invokeTag('textArea','g',301,['placeholder':(mapKeyValue?.getKey()?.placeholder),'class':("width"),'name':("answer_${mapKeyValue?.getKey()?.id}"),'value':(mapKeyValue?.getValue()?.answer),'data-toggle':("tooltip"),'req':("1"),'txtmaxword100':("1"),'data-placement':("top"),'title':(mapKeyValue?.getKey()?.questionTooltip)],-1)
printHtmlPart(34)

i++

printHtmlPart(30)
}
printHtmlPart(35)
if(true && (!appForm?.isBenefitSharing)) {
printHtmlPart(26)
invokeTag('radio','g',330,['name':("isBenefitSharing"),'value':("Yes"),'onclick':("AddValidation_Yes4('Proposed')")],-1)
printHtmlPart(36)
invokeTag('radio','g',332,['name':("isBenefitSharing"),'value':("No"),'onclick':("removeValidation_No4('notBenefitSharing')")],-1)
printHtmlPart(37)
}
else {
printHtmlPart(13)
if(true && (appForm?.isBenefitSharing == 'true')) {
printHtmlPart(26)
invokeTag('radio','g',337,['name':("isBenefitSharing"),'onclick':("AddValidation_Yes4('Proposed')"),'checked':("checked"),'value':("Yes")],-1)
printHtmlPart(38)
}
else {
printHtmlPart(26)
invokeTag('radio','g',341,['name':("isBenefitSharing"),'value':("Yes"),'onclick':("AddValidation_Yes4('Proposed')")],-1)
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (appForm?.isBenefitSharing == 'false')) {
printHtmlPart(26)
invokeTag('radio','g',346,['name':("isBenefitSharing"),'value':("No"),'onclick':("removeValidation_No4('Proposed')"),'checked':("checked")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(26)
invokeTag('radio','g',349,['name':("isBenefitSharing"),'value':("No"),'onclick':("removeValidation_No4('Proposed')")],-1)
printHtmlPart(40)
}
printHtmlPart(16)
}
printHtmlPart(41)
if(true && (appForm?.sharingDoc)) {
printHtmlPart(42)
if(true && (flash.message)) {
printHtmlPart(43)
expressionOut.print(flash.message)
printHtmlPart(44)
}
else {
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(24)
expressionOut.print(appForm?.sharingDocName)
printHtmlPart(26)
})
invokeTag('link','g',382,['controller':("applicationManagement"),'action':("showAppDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "sharingDocName", dataName: "sharingDocName",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(13)
}
printHtmlPart(16)
}
else {
printHtmlPart(45)
if(true && (flash.message)) {
printHtmlPart(43)
expressionOut.print(flash.message)
printHtmlPart(44)
}
printHtmlPart(16)
}
printHtmlPart(46)
if(true && (appForm?.companyProfiles?.size() != 0)) {
printHtmlPart(47)
if(true && (!appForm?.payBenefitSharing)) {
printHtmlPart(25)
invokeTag('radio','g',409,['name':("payBenefitSharing"),'value':("Monetary"),'onclick':("AddValidation_Yes4('openIfMonetary')")],-1)
printHtmlPart(48)
invokeTag('radio','g',418,['name':("payBenefitSharing"),'value':("Non-Monetary"),'onclick':("removeValidation_No4('openIfMonetary')")],-1)
printHtmlPart(49)
}
else if(true && (appForm?.payBenefitSharing)) {
printHtmlPart(25)
if(true && (appForm?.payBenefitSharing == 'Monetary')) {
printHtmlPart(50)
invokeTag('radio','g',425,['name':("payBenefitSharing"),'onclick':("AddValidation_Yes4('openIfMonetary')"),'checked':("checked"),'value':("Monetary")],-1)
printHtmlPart(51)
}
else {
printHtmlPart(50)
invokeTag('radio','g',429,['name':("payBenefitSharing"),'value':("Monetary"),'onclick':("AddValidation_Yes4('openIfMonetary')")],-1)
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (appForm?.payBenefitSharing == 'Non-Monetary')) {
printHtmlPart(50)
invokeTag('radio','g',435,['name':("payBenefitSharing"),'value':("Non-Monetary"),'onclick':("removeValidation_No4('openIfMonetary')"),'checked':("checked")],-1)
printHtmlPart(53)
}
else {
printHtmlPart(50)
invokeTag('radio','g',440,['name':("payBenefitSharing"),'value':("Non-Monetary"),'onclick':("removeValidation_No4('openIfMonetary')")],-1)
printHtmlPart(53)
}
printHtmlPart(24)
}
printHtmlPart(54)
if(true && (!appForm?.isMonetary)) {
printHtmlPart(25)
invokeTag('radio','g',455,['name':("isMonetary"),'value':("purchasePrice"),'onclick':("AdValidation_Yes4('Proposed')")],-1)
printHtmlPart(55)
invokeTag('radio','g',465,['name':("isMonetary"),'value':("exFactorySale"),'onclick':("removValidation_No4('Proposed')")],-1)
printHtmlPart(56)
}
else {
printHtmlPart(25)
if(true && (appForm?.isMonetary == 'purchasePrice')) {
printHtmlPart(50)
invokeTag('radio','g',473,['name':("isMonetary"),'onclick':("AdValidation_Yes4('Proposed')"),'checked':("checked"),'value':("purchasePrice")],-1)
printHtmlPart(57)
}
else {
printHtmlPart(50)
invokeTag('radio','g',478,['name':("isMonetary"),'value':("purchasePrice"),'onclick':("AdValidation_Yes4('Proposed')")],-1)
printHtmlPart(57)
}
printHtmlPart(52)
if(true && (appForm?.isMonetary == 'exFactorySale')) {
printHtmlPart(50)
invokeTag('radio','g',487,['name':("isMonetary"),'value':("exFactorySale"),'onclick':("removValidation_No4('Proposed')"),'checked':("checked")],-1)
printHtmlPart(58)
}
else {
printHtmlPart(50)
invokeTag('radio','g',493,['name':("isMonetary"),'value':("exFactorySale"),'onclick':("removValidation_No4('Proposed')")],-1)
printHtmlPart(59)
}
printHtmlPart(24)
}
printHtmlPart(60)
}
printHtmlPart(61)
invokeTag('textArea','g',508,['class':("width"),'name':("otherInfo"),'value':(appForm?.otherInfo)],-1)
printHtmlPart(62)
invokeTag('hiddenField','g',512,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(63)
invokeTag('hiddenField','g',518,['name':("formType"),'value':(formType)],-1)
printHtmlPart(63)
invokeTag('hiddenField','g',521,['name':("quesCategory"),'value':(quesCategory?.id)],-1)
printHtmlPart(64)
})
invokeTag('uploadForm','g',532,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("savePart4"),'controller':("applicationManagement")],2)
printHtmlPart(65)
createClosureForHtmlPart(66, 2)
invokeTag('link','g',540,['controller':("applicationManagement"),'action':("form1Part3"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(67)
if(true && (appForm?.isTradingPurpose == 'true')) {
printHtmlPart(30)
createClosureForHtmlPart(68, 3)
invokeTag('link','g',550,['controller':("formA"),'action':("form1FormA"),'class':("btn btn-primary pull-right"),'params':([appFormId:appForm?.id,formType:formType,declaration:"declaration" ,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(69)
}
else if(true && (appForm?.isDeclarationDigitallySigned == 'true' || appForm?.isDeclarationDigitallySigned == 'notDigital')) {
printHtmlPart(30)
createClosureForHtmlPart(68, 3)
invokeTag('link','g',561,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'params':([appFormId:appForm?.id,formType:formType,declaration:"declaration" ,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(69)
}
else {
printHtmlPart(30)
createClosureForHtmlPart(68, 3)
invokeTag('link','g',568,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(69)
}
printHtmlPart(70)
})
invokeTag('captureBody','sitemesh',572,[:],1)
printHtmlPart(71)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268166000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
