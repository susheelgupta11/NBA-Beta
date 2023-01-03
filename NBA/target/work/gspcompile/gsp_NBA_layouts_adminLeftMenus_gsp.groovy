import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layouts_adminLeftMenus_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_adminLeftMenus.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',6,['controller':("loggedInAs"),'action':("inbox"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',11,['controller':("nbaUser"),'action':("index"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',12,['controller':("nbaUser"),'action':("create"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',18,['controller':("setMstrData"),'action':("index"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(8, 1)
invokeTag('link','g',19,['controller':("setMstrData"),'action':("note"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(9, 1)
invokeTag('link','g',20,['controller':("setMstrData"),'action':("submission"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(10, 1)
invokeTag('link','g',21,['controller':("setMstrData"),'action':("queries"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(11, 1)
invokeTag('link','g',22,['controller':("setMstrData"),'action':("actions"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(12, 1)
invokeTag('link','g',23,['controller':("setMstrData"),'action':("status"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(13, 1)
invokeTag('link','g',24,['controller':("setMstrData"),'action':("priority"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(14)
createClosureForHtmlPart(15, 1)
invokeTag('link','g',31,['controller':("setMstrData"),'action':("letterList"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(16, 1)
invokeTag('link','g',32,['controller':("setMstrData"),'action':("addLetter"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(17)
createClosureForHtmlPart(18, 1)
invokeTag('link','g',36,['controller':("loggedInAs"),'action':("tr5Issued"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(19)
createClosureForHtmlPart(20, 1)
invokeTag('link','g',37,['controller':("loggedInAs"),'action':("benefitSharingReceived"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(19)
createClosureForHtmlPart(21, 1)
invokeTag('link','g',38,['controller':("loggedInAs"),'action':("agendaReport"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(22)
createClosureForHtmlPart(23, 1)
invokeTag('link','g',43,['controller':("loggedInAs"),'action':("linkOfficerList"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(4)
createClosureForHtmlPart(24, 1)
invokeTag('link','g',44,['controller':("loggedInAs"),'action':("linkOfficer"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(25)
createClosureForHtmlPart(26, 1)
invokeTag('link','g',49,['controller':("setMstrData"),'action':("kms"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(27)
createClosureForHtmlPart(28, 1)
invokeTag('link','g',51,['controller':("loggedInAs"),'action':("recordRoomList"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(27)
createClosureForHtmlPart(29, 1)
invokeTag('link','g',53,['controller':("loggedInAs"),'action':("auditLog"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1652343856930L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
