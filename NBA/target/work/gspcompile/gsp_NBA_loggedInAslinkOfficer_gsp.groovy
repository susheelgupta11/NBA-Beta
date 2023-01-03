import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAslinkOfficer_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/linkOfficer.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (message)) {
printHtmlPart(5)
expressionOut.print(message)
printHtmlPart(6)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('render','g',15,['template':("/loggedInAs/linkOfficer")],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',16,['name':("userLink"),'value':(currentUser)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',17,['name':("updateInstance"),'value':(linkOfficerInstance?.id)],-1)
printHtmlPart(1)
if(true && (linkOfficerInstance)) {
printHtmlPart(3)
invokeTag('submitButton','g',20,['name':("Update"),'class':("btn"),'style':(" margin-left:260px;margin-top:15px;")],-1)
printHtmlPart(1)
}
else {
printHtmlPart(1)
invokeTag('submitButton','g',24,['name':("Link"),'class':("btn"),'style':(" margin-left:260px;margin-top:15px;")],-1)
printHtmlPart(1)
}
printHtmlPart(1)
})
invokeTag('form','g',26,['action':("setLinkOfficer")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',28,[:],1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1579684830000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
