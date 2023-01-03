
import org.nba.application.AgentProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_addAgentProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_addAgentProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
if(true && (company)) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (agentProfile != null)) {
printHtmlPart(6)
}
else {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (appForm?.isAddressOfContactPerson == 'NoForCompany' || appForm?.isAddressOfContactPerson == 'NoForIndividual')) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (profiles)) {
printHtmlPart(12)
invokeTag('select','g',72,['name':("agentProfile"),'from':(profiles),'class':("width  controlreq"),'req1':("1"),'onchange':("hideshowother(this,'otherAgentProfile')")],-1)
printHtmlPart(13)
}
else {
printHtmlPart(12)
invokeTag('select','g',76,['name':("agentProfile"),'from':(agentProfiles),'class':("width  controlreq"),'req1':("1"),'onchange':("hideshowother(this,'otherAgentProfile')")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('select','g',102,['name':("agentTitle"),'class':("width controlreq"),'req1':("1"),'from':(AgentProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(15)
invokeTag('select','g',203,['name':("agentProvince"),'from':(listOfStates),'optionKey':("id"),'optionValue':("state"),'class':("width controlreq"),'req1':("1"),'value':(""),'noSelection':(['':'Select State'])],-1)
printHtmlPart(16)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(agentProfile?.authorizationLetterFileName)
printHtmlPart(19)
})
invokeTag('link','g',291,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(12)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(22)
invokeTag('select','g',307,['id':("foucuscontrol"),'name':("photoIdSelect"),'req1':("1"),'class':("width controlreq fumargin"),'value':(agentProfile?.photoIdSelect),'from':(agentPhotoIdSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(23)
expressionOut.print(agentProfile?.photoIdNum)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
expressionOut.print(agentProfile?.passportCopyFileName)
printHtmlPart(18)
})
invokeTag('link','g',327,['controller':("applicationManagement"),'class':("fumargin"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(26)
}
else {
printHtmlPart(22)
invokeTag('select','g',336,['id':("foucuscontrol"),'name':("photoIdSelect"),'req1':("1"),'class':("width controlreq fumargin"),'from':(agentPhotoIdSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(27)
}
printHtmlPart(28)
invokeTag('hiddenField','g',349,['name':("agentProfileId"),'value':(agentProfile?.id)],-1)
printHtmlPart(29)
if(true && (company)) {
printHtmlPart(30)
invokeTag('hiddenField','g',352,['name':("isCompanyProfile"),'value':("true")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(19)
invokeTag('hiddenField','g',356,['name':("isIndividualProfile"),'value':("true")],-1)
printHtmlPart(12)
}
printHtmlPart(12)
invokeTag('hiddenField','g',356,['name':("formType"),'value':(formType)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',358,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(31)
})
invokeTag('uploadForm','g',364,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveAgentProfile")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664198762199L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
