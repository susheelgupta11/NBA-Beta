
import org.nba.application.AgentProfile


import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_editAgentProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_editAgentProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(3)
if(true && (profile)) {
printHtmlPart(4)
}
else {
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (agentProfile)) {
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (profile)) {
printHtmlPart(10)
if(true && (agentProfile?.profile?.contains('-'))) {
printHtmlPart(11)
invokeTag('select','g',59,['name':("agentProfile"),'id':("agentProfileId"),'from':(profile),'value':(agentProfile?.profile?.split('-')[0]),'class':("width  controlreq"),'onchange':("hideshowother(this,'otherAgentProfile')")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(13)
invokeTag('select','g',64,['name':("agentProfile"),'id':("agentProfileId"),'from':(profile),'value':(agentProfile?.profile),'class':("width  controlreq"),'onchange':("hideshowother(this,'otherAgentProfile')")],-1)
printHtmlPart(12)
}
printHtmlPart(14)
}
else {
printHtmlPart(15)
if(true && (agentProfile?.profile?.contains('-'))) {
printHtmlPart(11)
invokeTag('select','g',71,['name':("agentProfile"),'id':("agentProfileId"),'from':(profiles),'value':(agentProfile?.profile?.split('-')[0]),'class':("width  controlreq"),'onchange':("hideshowother(this,'otherAgentProfile')")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(13)
invokeTag('select','g',76,['name':("agentProfile"),'id':("agentProfileId"),'from':(profiles),'value':(agentProfile?.profile),'class':("width  controlreq"),'onchange':("hideshowother(this,'otherAgentProfile')")],-1)
printHtmlPart(12)
}
printHtmlPart(14)
}
printHtmlPart(16)
if(true && (agentProfile?.profile?.contains('-'))) {
printHtmlPart(17)
expressionOut.print(agentProfile?.profile?.split('-')[1])
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('select','g',125,['name':("agentTitle"),'class':("width controlreq"),'value':(agentProfile?.title),'from':(AgentProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(21)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(22)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(23)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(24)
expressionOut.print(agentProfile?.address1)
printHtmlPart(25)
expressionOut.print(agentProfile?.address2)
printHtmlPart(26)
expressionOut.print(agentProfile?.address3)
printHtmlPart(27)
invokeTag('select','g',225,['name':("agentProvince"),'from':(listOfStates),'optionKey':("id"),'optionValue':("state"),'value':(State.findById(agentProfile?.province)?.id),'class':("width controlreq"),'noSelection':(['':'Select State'])],-1)
printHtmlPart(28)
expressionOut.print(agentProfile?.city)
printHtmlPart(29)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(30)
if(true && (!agentProfile)) {
printHtmlPart(31)
}
else if(true && (agentProfile?.mobile?.contains('-'))) {
printHtmlPart(32)
expressionOut.print(agentProfile?.mobile?.split('-')[0])
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (!agentProfile)) {
printHtmlPart(35)
}
else {
printHtmlPart(36)
expressionOut.print(agentProfile?.mobile?.split('-')[1])
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(agentProfile?.email)
printHtmlPart(39)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(40)
expressionOut.print(agentProfile?.authorizationLetter)
printHtmlPart(41)
createTagBody(3, {->
printHtmlPart(11)
expressionOut.print(agentProfile?.authorizationLetterFileName)
printHtmlPart(15)
})
invokeTag('link','g',325,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(42)
}
else {
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(45)
invokeTag('select','g',345,['id':("foucuscontrol"),'name':("photoIdSelect"),'req1':("1"),'class':("width controlclass1 fumargin"),'value':(agentProfile?.photoIdSelect),'from':(agentPhotoIdSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(46)
expressionOut.print(agentProfile?.photoIdNum)
printHtmlPart(47)
expressionOut.print(agentProfile?.passportCopy)
printHtmlPart(41)
createTagBody(3, {->
printHtmlPart(11)
expressionOut.print(agentProfile?.passportCopyFileName)
printHtmlPart(15)
})
invokeTag('link','g',364,['controller':("applicationManagement"),'class':("fumargin"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(48)
}
else {
printHtmlPart(49)
}
printHtmlPart(50)
invokeTag('hiddenField','g',372,['name':("agentProfileId"),'value':(agentProfile?.id)],-1)
printHtmlPart(42)
invokeTag('hiddenField','g',372,['name':("isIndividualProfile"),'value':("true")],-1)
printHtmlPart(42)
invokeTag('hiddenField','g',373,['name':("formType"),'value':(formType)],-1)
printHtmlPart(42)
invokeTag('hiddenField','g',376,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(51)
})
invokeTag('uploadForm','g',380,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveAgentProfile")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664296279172L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
