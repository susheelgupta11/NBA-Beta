import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationeditCommunication_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/editCommunication.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
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
invokeTag('render','g',30,['template':("/letterCommunication/ckeditor")],-1)
printHtmlPart(8)
if(true && (status == 'true')) {
printHtmlPart(9)
invokeTag('actionSubmit','g',35,['value':("Send"),'class':("btn btn-primary pull-right"),'style':("margin-left: 15px;"),'action':("sendEmail")],-1)
printHtmlPart(10)
invokeTag('actionSubmit','g',36,['value':("Resend to Draft"),'class':("btn btn-primary pull-right"),'action':("saveForDraft")],-1)
printHtmlPart(11)
}
else {
printHtmlPart(12)
invokeTag('actionSubmit','g',39,['value':("Move to Approved"),'class':("btn btn-primary pull-right"),'style':("margin-left: 15px;"),'action':("sendForApproval")],-1)
printHtmlPart(12)
invokeTag('actionSubmit','g',40,['value':("Save as Draft"),'class':("btn btn-primary pull-right"),'action':("saveForDraft")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('form','g',41,['controller':("letterCommunication"),'action':("sendForApproval"),'enctype':("multipart/form-data")],2)
printHtmlPart(15)
invokeTag('render','g',45,['template':("/rightPane/matchdata")],-1)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',47,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1616917617896L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
