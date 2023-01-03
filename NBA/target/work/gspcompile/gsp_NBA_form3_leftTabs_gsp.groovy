import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form3_leftTabs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form3/_leftTabs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',3,['controller':("form3"),'action':("selectIndividualOrCompany"),'class':("list-group-item active"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',4,['controller':("form3"),'action':("part2"),'class':("list-group-item himanshu"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(2)
createClosureForHtmlPart(4, 1)
invokeTag('link','g',5,['controller':("form3"),'action':("part3"),'class':("list-group-item himanshu"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(2)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',6,['controller':("form3"),'action':("part4"),'class':("list-group-item himanshu"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
