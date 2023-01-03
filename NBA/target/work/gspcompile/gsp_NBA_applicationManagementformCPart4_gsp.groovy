import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementformCPart4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/formCPart4.gsp" }
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
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(8)
})
invokeTag('javascript','g',39,[:],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',59,['controller':("applicationManagement"),'post':("true"),'action':("completePayment"),'params':([formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],2)
printHtmlPart(11)
invokeTag('render','g',72,['template':("leftTabs"),'model':([formType:formType,appForm:appForm])],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(14)
}
else if(true && (appForm?.isDeclarationDigitallySigned = 'notDigital')) {
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
for( notification in (listOfNotifications) ) {
printHtmlPart(18)
if(true && (notification?.docName == 'Declaration by the Applicant Form C')) {
printHtmlPart(19)
createClosureForHtmlPart(20, 5)
invokeTag('link','g',188,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
printHtmlPart(21)
expressionOut.print(applicationform?.undertakingCopy)
printHtmlPart(22)
createTagBody(5, {->
printHtmlPart(23)
expressionOut.print(applicationform?.undertakingCopyFileName)
printHtmlPart(24)
})
invokeTag('link','g',200,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(applicationform?.id),'target':("_blank"),'params':([filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('hiddenField','g',221,['name':("formType"),'value':(formType)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',222,['name':("appFormId"),'value':(appFormId)],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',224,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(29)
if(true && (formType == 'FormC')) {
printHtmlPart(30)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',234,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary preview"),'action':("formCpreview"),'params':([formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(32)
}
printHtmlPart(33)
})
invokeTag('uploadForm','g',238,['controller':("applicationManagement"),'autocomplete':("off"),'action':("submitDeclarationFormC")],2)
printHtmlPart(34)
createClosureForHtmlPart(35, 2)
invokeTag('link','g',258,['controller':("applicationManagement"),'action':("formCPart3"),'class':("btn btn-primary"),'params':([appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(36)
})
invokeTag('captureBody','sitemesh',265,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1650527699456L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
