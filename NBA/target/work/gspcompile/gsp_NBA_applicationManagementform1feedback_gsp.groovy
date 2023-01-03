import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1feedback_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1feedback.gsp" }
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
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',32,['controller':("applicationManagement"),'action':("form1Payment"),'class':("btn btn-success")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
invokeTag('textArea','g',57,['rows':("5"),'name':("feedback"),'value':(""),'class':("width"),'req':("1")],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',62,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',64,['controller':("loggedInAs"),'class':("btn btn-primary"),'action':("inbox"),'params':([appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(14)
})
invokeTag('form','g',66,['action':("saveFormFeedback"),'autocomplete':("off")],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(16)
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
