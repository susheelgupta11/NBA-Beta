
import org.nba.application.AgentProfile


import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_companyAgentProfilePreview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_companyAgentProfilePreview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (listOfCompanyData?.size() > 1)) {
printHtmlPart(2)
}
else {
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(agentProfile?.profile)
printHtmlPart(5)
expressionOut.print(agentProfile?.title)
printHtmlPart(6)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(6)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(6)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(7)
expressionOut.print(agentProfile?.address1)
printHtmlPart(6)
expressionOut.print(agentProfile?.address2)
printHtmlPart(6)
expressionOut.print(agentProfile?.address3)
printHtmlPart(8)
expressionOut.print(State.findById(agentProfile?.province)?.id)
printHtmlPart(9)
expressionOut.print(agentProfile?.city)
printHtmlPart(10)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(11)
if(true && (!agentProfile)) {
printHtmlPart(12)
}
else if(true && (agentProfile?.mobile?.contains('-'))) {
printHtmlPart(13)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(6)
}
printHtmlPart(14)
expressionOut.print(agentProfile?.email)
printHtmlPart(15)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(agentProfile?.authorizationLetterFileName)
printHtmlPart(13)
})
invokeTag('link','g',145,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}'])],2)
printHtmlPart(6)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(agentProfile?.passportCopyFileName)
printHtmlPart(13)
})
invokeTag('link','g',167,['controller':("applicationManagement"),'class':("fumargin"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: 'passportCopyFileName', dataName: 'passportCopyFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],2)
printHtmlPart(6)
}
else {
printHtmlPart(18)
}
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1614859887226L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
