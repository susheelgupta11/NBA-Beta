
import org.nba.application.IndividualProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1IndividualProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1IndividualProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('render','g',51,['template':("leftTabs")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(8)
invokeTag('select','g',95,['name':("title"),'req':("1"),'class':("width"),'value':(individualProfile?.title),'from':(IndividualProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(9)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(10)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(11)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(12)
expressionOut.print(individualProfile?.nationality)
printHtmlPart(13)
expressionOut.print(individualProfile?.address1)
printHtmlPart(14)
expressionOut.print(individualProfile?.address2)
printHtmlPart(15)
expressionOut.print(individualProfile?.address3)
printHtmlPart(16)
invokeTag('select','g',214,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(individualProfile?.country?.id),'class':("width"),'noSelection':(['':'-Select-']),'required':("required")],-1)
printHtmlPart(17)
expressionOut.print(individualProfile?.title)
printHtmlPart(18)
expressionOut.print(individualProfile?.city)
printHtmlPart(19)
expressionOut.print(individualProfile?.pincode)
printHtmlPart(20)
expressionOut.print(individualProfile?.mobile)
printHtmlPart(21)
expressionOut.print(individualProfile?.phone)
printHtmlPart(22)
expressionOut.print(individualProfile?.email)
printHtmlPart(23)
if(true && (individualProfile?.idProof)) {
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
expressionOut.print(individualProfile?.idProofFileName)
printHtmlPart(24)
})
invokeTag('link','g',306,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (individualProfile?.passportCopy)) {
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
expressionOut.print(individualProfile?.passportCopyFileName)
printHtmlPart(24)
})
invokeTag('link','g',327,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(26)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (individualProfile?.authorizationLetter)) {
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
expressionOut.print(individualProfile?.authorizationLetterFileName)
printHtmlPart(24)
})
invokeTag('link','g',349,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(26)
}
else {
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('select','g',449,['name':("agentTitle"),'class':("width controlreq"),'value':(agentProfile?.title),'from':(IndividualProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(33)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(34)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(35)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(36)
expressionOut.print(agentProfile?.address1)
printHtmlPart(37)
expressionOut.print(agentProfile?.address2)
printHtmlPart(38)
expressionOut.print(agentProfile?.address3)
printHtmlPart(39)
expressionOut.print(agentProfile?.title)
printHtmlPart(40)
expressionOut.print(agentProfile?.city)
printHtmlPart(41)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(42)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(43)
expressionOut.print(agentProfile?.email)
printHtmlPart(44)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
expressionOut.print(agentProfile?.authorizationLetterFileName)
printHtmlPart(24)
})
invokeTag('link','g',590,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(26)
}
else {
printHtmlPart(45)
}
printHtmlPart(46)
createClosureForHtmlPart(47, 3)
invokeTag('link','g',624,['controller':("applicationManagement"),'action':("form1Part2"),'params':([appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}']),'class':("btn  login-btin pull-right"),'method':("POST")],3)
printHtmlPart(48)
})
invokeTag('uploadForm','g',626,['class':("form-horizontal"),'role':("form"),'action':("submitIndividualFormProfile"),'autocomplete':("off")],2)
printHtmlPart(49)
})
invokeTag('captureBody','sitemesh',628,[:],1)
printHtmlPart(50)
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
