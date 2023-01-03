import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1Payment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1Payment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(appForm?.id)
printHtmlPart(6)
expressionOut.print(transactionNum)
printHtmlPart(7)
expressionOut.print(declaration)
printHtmlPart(8)
})
invokeTag('javascript','g',32,[:],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',52,['controller':("applicationManagement"),'post':("true"),'action':("completePayment"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],2)
printHtmlPart(11)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',78,['controller':("applicationManagement"),'action':("form1Payment"),'class':("btn btn-success"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(12)
invokeTag('render','g',88,['template':("leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(transactionNum)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(19)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(20)
if(true && (appForm?.transaction?.paymentReceipt)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',259,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(appForm?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('hiddenField','g',268,['name':("formType"),'value':(formType)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',269,['name':("appFormId"),'value':(appFormId)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',270,['name':("transactionId"),'value':(transactionNum)],-1)
printHtmlPart(27)
invokeTag('actionSubmit','g',276,['value':("Save"),'action':("saveBeforePaymentProcess"),'class':("btn btn-primary")],-1)
printHtmlPart(28)
})
invokeTag('uploadForm','g',287,['controller':("applicationManagement"),'autocomplete':("off")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',288,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1665486415039L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
