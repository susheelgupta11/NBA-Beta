import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layouts_topmenu_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_topmenu.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',12,['controller':("loggedInAs"),'action':("inbox"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',13,['controller':("register"),'action':("userDetail"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(2)
createClosureForHtmlPart(4, 1)
invokeTag('link','g',14,['controller':("register"),'action':("changePassword"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(2)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',15,['controller':("logout"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1651300200419L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
