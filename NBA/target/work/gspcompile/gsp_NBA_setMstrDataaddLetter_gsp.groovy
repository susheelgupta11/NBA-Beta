import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_setMstrDataaddLetter_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/setMstrData/addLetter.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("superAdmin")],-1)
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
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(letterTemInstance?.letterName)
printHtmlPart(5)
invokeTag('textArea','g',30,['name':("templateLetter"),'id':("editor2"),'value':(letterTemInstance?.templateLetter)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',32,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',33,['name':("letterInstance"),'value':(letterTemInstance?.id)],-1)
printHtmlPart(7)
if(true && (letterTemInstance)) {
invokeTag('submitButton','g',34,['name':("Update"),'class':("btn btn-primary pull-right")],-1)
}
else {
printHtmlPart(8)
invokeTag('submitButton','g',35,['name':("Add"),'class':("btn btn-primary pull-right")],-1)
}
printHtmlPart(9)
})
invokeTag('form','g',37,['controller':("setMstrData"),'action':("letterTempleteSave")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',45,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1581935668000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
