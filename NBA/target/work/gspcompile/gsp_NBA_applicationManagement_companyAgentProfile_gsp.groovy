import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_companyAgentProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_companyAgentProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
invokeTag('select','g',29,['name':("profile"),'from':(profiles),'class':("width"),'onchange':("hideshowother(this,'otherProfile2')")],-1)
printHtmlPart(3)
invokeTag('select','g',54,['name':("agentTitle"),'class':("width controlreq"),'from':(AgentProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(4)
invokeTag('select','g',136,['name':("agentProvince"),'from':(listOfStates),'optionKey':("state"),'optionValue':("state"),'class':("  width ctrolreqddl"),'noSelection':(['':'Select State'])],-1)
printHtmlPart(5)
if(true && (!agentProfile)) {
printHtmlPart(6)
}
else if(true && (agentProfile?.mobile?.contains('-'))) {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (!agentProfile)) {
printHtmlPart(9)
}
else if(true && (agentProfile?.mobile?.contains('-'))) {
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (!agentProfile)) {
printHtmlPart(12)
}
else if(true && (agentProfile?.phone?.contains('-'))) {
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (!agentProfile)) {
printHtmlPart(15)
}
else if(true && (agentProfile?.phone?.contains('-'))) {
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
expressionOut.print(agentProfile?.authorizationLetterFileName)
printHtmlPart(20)
})
invokeTag('link','g',267,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(19)
expressionOut.print(agentProfile?.passportCopyFileName)
printHtmlPart(20)
})
invokeTag('link','g',295,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: 'passportCopyFileName', dataName: 'passportCopyFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(21)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('hiddenField','g',305,['name':("isCompanyProfile"),'value':("true")],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',306,['name':("formType"),'value':(formType)],-1)
printHtmlPart(27)
})
invokeTag('uploadForm','g',1,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveAgentProfile")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664199639936L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
