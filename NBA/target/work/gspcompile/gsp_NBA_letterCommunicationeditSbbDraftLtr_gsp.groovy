import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationeditSbbDraftLtr_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/editSbbDraftLtr.gsp" }
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
invokeTag('render','g',29,['template':("/letterCommunication/sbbckeditor")],-1)
printHtmlPart(8)
if(true && (status == 'true')) {
printHtmlPart(9)
invokeTag('actionSubmit','g',32,['value':("Send to SBB"),'class':("btn btn-primary pull-right"),'style':("margin-left: 15px;"),'action':("sendSbbLetter")],-1)
printHtmlPart(9)
invokeTag('actionSubmit','g',33,['value':("Resend to Draft"),'action':("saveSbbLetter"),'class':("btn btn-primary pull-right")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
invokeTag('actionSubmit','g',36,['class':("btn btn-primary pull-right"),'style':("margin-left: 15px;"),'value':("Send for Approval"),'action':("sendForSbbApproval")],-1)
printHtmlPart(12)
invokeTag('actionSubmit','g',37,['value':("Save as Draft"),'action':("saveSbbLetter"),'class':("btn btn-primary pull-right")],-1)
printHtmlPart(10)
}
printHtmlPart(13)
})
invokeTag('form','g',38,['controller':("letterCommunication"),'action':("saveSbbLetter"),'enctype':("multipart/form-data"),'method':("POST")],2)
printHtmlPart(14)
invokeTag('render','g',43,['template':("/rightPane/matchdata")],-1)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',45,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1617156325037L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
