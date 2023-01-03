import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationcreateCommunication_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/createCommunication.gsp" }
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
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (message)) {
printHtmlPart(5)
expressionOut.print(message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('render','g',32,['template':("/letterCommunication/ckeditor")],-1)
printHtmlPart(9)
invokeTag('actionSubmit','g',34,['value':("Move to Approved"),'class':("btn btn-primary pull-right"),'style':("margin-left: 15px;"),'action':("sendForApproval")],-1)
printHtmlPart(10)
invokeTag('actionSubmit','g',35,['value':("Save as Draft"),'class':("btn btn-primary pull-right"),'action':("saveForDraft")],-1)
printHtmlPart(10)
})
invokeTag('form','g',35,['controller':("letterCommunication"),'action':("sendForApproval"),'enctype':("multipart/form-data"),'method':("POST")],2)
printHtmlPart(11)
invokeTag('render','g',40,['template':("/rightPane/matchdata")],-1)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',42,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1616917450679L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
