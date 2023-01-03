import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationtr5LetterEdit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/tr5LetterEdit.gsp" }
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
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
if(true && (message)) {
printHtmlPart(4)
expressionOut.print(message)
printHtmlPart(5)
}
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('render','g',29,['template':("/letterCommunication/tr5")],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',30,['name':("instance"),'value':(formDetails?.id)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',31,['name':("receiptNo"),'value':(tr5ReceiptInstance?.receiptNo)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',32,['name':("tr5Instance"),'value':(tr5ReceiptInstance?.id)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',34,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(8)
if(true && (status == 'true')) {
printHtmlPart(7)
invokeTag('actionSubmit','g',37,['value':("Send"),'class':("btn btn-primary pull-right"),'style':("margin-left:15px"),'action':("tr5ReceiptSent")],-1)
printHtmlPart(7)
invokeTag('actionSubmit','g',38,['value':("Resend to Draft"),'class':("btn btn-primary pull-right"),'action':("tr5LetterSave")],-1)
printHtmlPart(7)
}
else {
printHtmlPart(9)
invokeTag('actionSubmit','g',41,['value':("Move to Approval"),'class':("btn btn-primary pull-right"),'action':("moveForApproval"),'style':("margin-left:15px")],-1)
printHtmlPart(9)
invokeTag('actionSubmit','g',42,['value':("Save as Draft"),'class':("btn btn-primary pull-right"),'action':("tr5LetterSave")],-1)
printHtmlPart(7)
}
printHtmlPart(10)
})
invokeTag('form','g',47,['enctype':("multipart/form-data"),'method':("POST"),'controller':("letterCommunication"),'action':("tr5LetterSave")],2)
printHtmlPart(11)
invokeTag('render','g',55,['template':("/rightPane/matchdata")],-1)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',55,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1618020632610L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
