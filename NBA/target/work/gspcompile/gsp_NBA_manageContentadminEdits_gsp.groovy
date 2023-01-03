import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_manageContentadminEdits_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/manageContent/adminEdits.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(aboutNBA)
printHtmlPart(4)
})
invokeTag('javascript','g',32,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',127,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('set','g',137,['var':("csrfPreventionSalt"),'value':(session.getAttribute("csrfPreventionSalt"))],-1)
printHtmlPart(8)
invokeTag('render','g',137,['template':("AdminLeftTab")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('textArea','g',156,['id':("edit"),'autocomplete':("off"),'name':("aboutUs"),'value':(aboutNBA?.aboutNBA),'style':("margin-top: 30px;")],3)
printHtmlPart(12)
expressionOut.print(aboutNBA?.id)
printHtmlPart(13)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',165,['controller':("loggedInAs"),'action':("inbox"),'params':([])],3)
printHtmlPart(16)
})
invokeTag('form','g',165,['controller':("manageContent"),'action':("saveAdminEdits")],2)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',167,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1544436488000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
