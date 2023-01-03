
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_agentProfileMatching_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_agentProfileMatching.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (allDataforMatching?.agentProfile)) {
printHtmlPart(1)
}
else {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (allDataforMatching?.agentProfile)) {
printHtmlPart(4)
expressionOut.print(allDataforMatching?.agentProfile?.profile)
printHtmlPart(5)
expressionOut.print(allDataforMatching?.agentProfile?.title)
printHtmlPart(6)
expressionOut.print(allDataforMatching?.agentProfile?.firstName)
printHtmlPart(7)
expressionOut.print(allDataforMatching?.agentProfile?.middleName)
printHtmlPart(6)
expressionOut.print(allDataforMatching?.agentProfile?.lastName)
printHtmlPart(8)
expressionOut.print(allDataforMatching?.agentProfile?.address1)
printHtmlPart(7)
expressionOut.print(allDataforMatching?.agentProfile?.address2)
printHtmlPart(6)
expressionOut.print(allDataforMatching?.agentProfile?.address3)
printHtmlPart(9)
expressionOut.print(State.findById(allDataforMatching?.agentProfile?.province)?.state)
printHtmlPart(10)
expressionOut.print(allDataforMatching?.agentProfile?.city)
printHtmlPart(11)
expressionOut.print(allDataforMatching?.agentProfile?.pincode)
printHtmlPart(12)
expressionOut.print(allDataforMatching?.agentProfile?.mobile)
printHtmlPart(13)
if(true && (allDataforMatching?.agentProfile?.authorizationLetter)) {
printHtmlPart(14)
expressionOut.print(allDataforMatching?.agentProfile?.authorizationLetterFileName)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',47,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(allDataforMatching?.agentProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(allDataforMatching?.agentProfile?.photoIdNum)
printHtmlPart(19)
}
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1644081756718L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
