import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formBformBPart5_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/formBPart5.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(tabStatus)
printHtmlPart(5)
})
invokeTag('javascript','g',20,[:],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',39,['controller':("applicationManagement"),'post':("true"),'action':("completePayment"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],2)
printHtmlPart(8)
invokeTag('render','g',52,['template':("/applicationManagement/leftTabs"),'model':([appForm:appForm,formType:formType])],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
for( notification in (listOfNotifications) ) {
printHtmlPart(11)
if(true && (notification?.docName == 'Undertaking by the Applicant Form B')) {
printHtmlPart(12)
createClosureForHtmlPart(13, 5)
invokeTag('link','g',113,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
printHtmlPart(14)
expressionOut.print(appForm?.undertakingCopy)
printHtmlPart(15)
createTagBody(5, {->
printHtmlPart(16)
expressionOut.print(appForm?.undertakingCopyFileName)
printHtmlPart(17)
})
invokeTag('link','g',126,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (notification?.docName == 'Declaration by the applicant on Nationality Form B')) {
printHtmlPart(22)
createClosureForHtmlPart(13, 5)
invokeTag('link','g',153,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
printHtmlPart(23)
expressionOut.print(appForm?.declarationByApplicantOnNationalityCopy)
printHtmlPart(24)
createTagBody(5, {->
printHtmlPart(16)
expressionOut.print(appForm?.declarationByApplicantOnNationalityCopyFileName)
printHtmlPart(17)
})
invokeTag('link','g',167,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "declarationByApplicantOnNationalityCopy", dataName: "declarationByApplicantOnNationalityCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (notification?.docName == 'Declaration by the Supervisor head of the institution in India Form B')) {
printHtmlPart(27)
createClosureForHtmlPart(13, 5)
invokeTag('link','g',193,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
printHtmlPart(28)
expressionOut.print(appForm?.declarationBySupervisorCopy)
printHtmlPart(29)
createTagBody(5, {->
printHtmlPart(17)
expressionOut.print(appForm?.declarationBySupervisorCopyFileName)
printHtmlPart(30)
})
invokeTag('link','g',207,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "declarationBySupervisorCopy", dataName: "declarationBySupervisorCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(30)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(31)
}
printHtmlPart(26)
if(true && (notification?.docName == 'Declaration by the Recipient collaborator outside india Form B')) {
printHtmlPart(32)
createClosureForHtmlPart(13, 5)
invokeTag('link','g',234,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
printHtmlPart(33)
expressionOut.print(appForm?.declarationByRecipientCopy)
printHtmlPart(29)
createTagBody(5, {->
printHtmlPart(17)
expressionOut.print(appForm?.declarationByRecipientCopyFileName)
printHtmlPart(30)
})
invokeTag('link','g',248,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "declarationByRecipientCopy", dataName: "declarationByRecipientCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(30)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(34)
}
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('hiddenField','g',265,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',266,['name':("formType"),'value':(formType)],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',267,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',277,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary"),'action':("formBpreview"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(39)
})
invokeTag('uploadForm','g',281,['controller':("formB"),'autocomplete':("off"),'action':("submitDeclarationFormB")],2)
printHtmlPart(40)
createClosureForHtmlPart(41, 2)
invokeTag('link','g',293,['controller':("formB"),'action':("formBPart4"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],2)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',293,[:],1)
printHtmlPart(43)
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
