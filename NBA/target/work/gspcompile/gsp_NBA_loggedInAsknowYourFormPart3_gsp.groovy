import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAsknowYourFormPart3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/knowYourFormPart3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(7)
invokeTag('hiddenField','g',74,['name':("nationality"),'value':(nationality)],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',75,['name':("formPart"),'value':("Part2")],-1)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',78,['controller':("loggedInAs"),'action':("knowYourFormPart1"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-left")],3)
printHtmlPart(11)
})
invokeTag('form','g',84,['action':("savePart2"),'name':("knowYourFormPart3"),'autocomplete':("off")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',87,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
