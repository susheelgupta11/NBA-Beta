import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form4part3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form4/part3.gsp" }
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
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(appForm?.id)
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',21,[:],2)
printHtmlPart(8)
invokeTag('render','g',28,['template':("/applicationManagement/leftTabs"),'model':([formType:formType,appFormId:appForm?.id])],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(11)
if(true && (thirdPartyInst)) {
printHtmlPart(12)
if(true && (thirdPartyInst?.isIndividual == true)) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(12)
if(true && (thirdPartyInst?.isIndividual == false)) {
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(thirdPartyInst?.name)
printHtmlPart(20)
expressionOut.print(thirdPartyInst?.addressForComm)
printHtmlPart(21)
expressionOut.print(thirdPartyInst?.state)
printHtmlPart(22)
expressionOut.print(thirdPartyInst?.pincode)
printHtmlPart(23)
invokeTag('select','g',150,['name':("country"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(thirdPartyInst?.id),'class':("width ctrl"),'req1':("1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(24)
expressionOut.print(thirdPartyInst?.phone)
printHtmlPart(25)
expressionOut.print(thirdPartyInst?.fax)
printHtmlPart(26)
expressionOut.print(thirdPartyInst?.website)
printHtmlPart(27)
expressionOut.print(thirdPartyInst?.email)
printHtmlPart(28)
invokeTag('hiddenField','g',196,['name':("formType"),'value':(formType)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',197,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',198,['name':("thirdPartyInstId"),'value':(thirdPartyInst?.id)],-1)
printHtmlPart(29)
})
invokeTag('formRemote','g',203,['name':("thirdParty"),'class':("form-horizontal"),'role':("form"),'url':([controller:'form4',action:'saveThirdParty']),'autocomplete':("off"),'update':("thirdPartyGrid"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],2)
printHtmlPart(30)
if(true && (listOfThirdParty)) {
printHtmlPart(31)
invokeTag('render','g',212,['template':("thirdPartyGrid"),'model':([thirdPartyInst:thirdPartyInst,listOfThirdParty:listOfThirdParty,appForm:appForm, formType:formType])],-1)
printHtmlPart(31)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(33)
for( purpose in (purposeList) ) {
printHtmlPart(34)
expressionOut.print(purpose)
printHtmlPart(35)
expressionOut.print(purpose)
printHtmlPart(36)
}
printHtmlPart(37)
invokeTag('textArea','g',246,['name':("thirdPartyTransferPurpose"),'class':("width ctrl1"),'txtreq1':("1"),'txtmaxword100':("1"),'placeHolder':("Provide details in 500 words"),'value':(appForm?.thirdPartyTransferPurpose)],-1)
printHtmlPart(38)
invokeTag('textArea','g',266,['class':("width ctrl1"),'txtreq1':("1"),'txtmaxword100':("1"),'placeHolder':("Provide details in 500 words"),'name':("benefitsToTheThirdParty"),'value':(appForm?.benefitsToTheThirdParty)],-1)
printHtmlPart(39)
if(true && (!appForm.isAgreementBwApplicantAndThirdParty)) {
printHtmlPart(40)
}
else {
printHtmlPart(41)
if(true && (appForm.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(42)
}
else {
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (appForm.isAgreementBwApplicantAndThirdParty == 'false')) {
printHtmlPart(45)
}
else {
printHtmlPart(46)
}
printHtmlPart(47)
}
printHtmlPart(48)
if(true && (appForm?.agreementBtwnApplicantAndThirdParty)) {
printHtmlPart(49)
if(true && (flash.message)) {
printHtmlPart(50)
expressionOut.print(flash.message)
printHtmlPart(51)
}
else {
printHtmlPart(52)
createClosureForHtmlPart(53, 5)
invokeTag('link','g',341,['controller':("form4"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart3:"part3", csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(54)
}
printHtmlPart(55)
}
else {
printHtmlPart(56)
if(true && (flash.message)) {
printHtmlPart(57)
expressionOut.print(flash.message)
printHtmlPart(58)
}
printHtmlPart(59)
}
printHtmlPart(60)
invokeTag('textArea','g',371,['class':("width ctrl1"),'txtreq1':("1"),'txtmaxword100':("1"),'placeHolder':("Provide details in 500 words"),'name':("benefitsOutOfThirdPartyTransfer"),'value':(appForm?.benefitsOutOfThirdPartyTransfer)],-1)
printHtmlPart(61)
invokeTag('textArea','g',389,['class':("width ctrl1"),'txtreq1':("1"),'txtmaxword100':("1"),'placeHolder':("Provide details in 500 words"),'name':("mechanismOutOfThirdPartyTransfer"),'value':(appForm?.mechanismOutOfThirdPartyTransfer)],-1)
printHtmlPart(62)
invokeTag('textArea','g',405,['class':("width "),'txtreq1':("1"),'txtmaxword200':("1"),'placeHolder':("Provide details in 500 words"),'name':("otherRelevantInfo"),'value':(appForm?.otherRelevantInfo)],-1)
printHtmlPart(63)
invokeTag('hiddenField','g',416,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',417,['name':("formType"),'value':(formType)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',418,['name':("quesCategory"),'value':(quesCategory?.id)],-1)
printHtmlPart(64)
})
invokeTag('uploadForm','g',422,['controller':("form4"),'action':("savePart3"),'autocomplete':("off"),'class':("form-horizontal"),'role':("form")],2)
printHtmlPart(31)
createClosureForHtmlPart(65, 2)
invokeTag('link','g',426,['controller':("form4"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-left")],2)
printHtmlPart(31)
createClosureForHtmlPart(66, 2)
invokeTag('link','g',436,['controller':("applicationManagement"),'action':("form1Part5"),'params':([appFormId:appForm?.id,formType:formType,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],2)
printHtmlPart(67)
})
invokeTag('captureBody','sitemesh',438,[:],1)
printHtmlPart(68)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
