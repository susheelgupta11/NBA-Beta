import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationtr5Create_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/tr5Create.gsp" }
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
invokeTag('render','g',34,['template':("/letterCommunication/tr5")],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',35,['name':("receiptNo"),'value':(eReceipt)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',36,['name':("instance"),'value':(formDetails?.id)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',37,['name':("tr5Instance"),'value':(tr5ReceiptInstance?.id)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',38,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(8)
invokeTag('actionSubmit','g',41,['value':("Move to Approval"),'class':("btn btn-primary pull-right"),'action':("moveForApproval"),'style':("margin-left:15px")],-1)
printHtmlPart(7)
invokeTag('actionSubmit','g',42,['value':("Save as Draft"),'class':("btn btn-primary pull-right"),'action':("tr5LetterSave")],-1)
printHtmlPart(9)
})
invokeTag('form','g',43,['enctype':("multipart/form-data"),'method':("POST"),'action':("tr5LetterSave")],2)
printHtmlPart(10)
invokeTag('render','g',50,['template':("/rightPane/matchdata")],-1)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620570337042L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
