
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_agentProfileGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_agentProfileGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

int i=1

printHtmlPart(1)
if(true && (agentProfile != null)) {
printHtmlPart(1)
for( agent in (agentProfile) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)

i++

printHtmlPart(4)
expressionOut.print(agent?.title)
printHtmlPart(5)
expressionOut.print(agent?.firstName)
printHtmlPart(5)
expressionOut.print(agent?.middleName)
printHtmlPart(5)
expressionOut.print(agent?.lastName)
printHtmlPart(6)
expressionOut.print(agent?.profile)
printHtmlPart(6)
expressionOut.print(agent?.address1)
printHtmlPart(5)
expressionOut.print(agent?.address2)
printHtmlPart(5)
expressionOut.print(agent?.address3)
printHtmlPart(5)
expressionOut.print(agent?.city)
printHtmlPart(5)
expressionOut.print(State.get(agent?.province)?.state)
printHtmlPart(6)
expressionOut.print(agent?.mobile)
printHtmlPart(6)
expressionOut.print(agent?.email)
printHtmlPart(7)
if(true && (company)) {
printHtmlPart(8)
createClosureForHtmlPart(9, 4)
invokeTag('remoteLink','g',51,['controller':("applicationManagement"),'update':("addEditAgentProfile"),'onSuccess':("showYes()"),'action':("editAgentProfile"),'params':([agentId:agent?.id,formType:formType,company:company,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(8)
createClosureForHtmlPart(10, 4)
invokeTag('remoteLink','g',57,['controller':("applicationManagement"),'update':("updateAgentProfile1"),'action':("deleteAgentProfile"),'params':([agentId:agent?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'onComplete':("loadPage();")],4)
printHtmlPart(11)
}
else {
printHtmlPart(12)
createClosureForHtmlPart(9, 4)
invokeTag('remoteLink','g',68,['controller':("applicationManagement"),'update':("addEditAgentProfile"),'onSuccess':("showYes()"),'action':("editAgentProfile"),'params':([agentId:agent?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(13)
createClosureForHtmlPart(10, 4)
invokeTag('remoteLink','g',74,['controller':("applicationManagement"),'update':("updateAgentProfile"),'action':("deleteAgentProfile"),'params':([agentId:agent?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'onSuccess':("loadPage();")],4)
printHtmlPart(14)
}
printHtmlPart(15)
}
printHtmlPart(1)
}
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
