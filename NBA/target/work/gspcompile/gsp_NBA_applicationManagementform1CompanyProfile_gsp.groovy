
import org.nba.application.CompanyProfile


import org.nba.application.AgentProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1CompanyProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1CompanyProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('render','g',45,['template':("leftTabs")],-1)
printHtmlPart(6)
if(true && (flash?.message)) {
printHtmlPart(7)
expressionOut.print(flash?.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(11)
expressionOut.print(companyProfile?.entityName)
printHtmlPart(12)
for( entityType in (entityTypes) ) {
printHtmlPart(13)
invokeTag('radio','g',98,['required':("required"),'name':("entityType"),'value':(entityType),'checked':(entityType.equals('Government Agency'))],-1)
printHtmlPart(13)
expressionOut.print(entityType)
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(companyProfile?.address1)
printHtmlPart(16)
expressionOut.print(companyProfile?.address2)
printHtmlPart(17)
expressionOut.print(companyProfile?.address2)
printHtmlPart(18)
invokeTag('select','g',167,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(companyProfile?.country?.id),'class':("width"),'noSelection':(['':'-Select-']),'required':("required")],-1)
printHtmlPart(19)
expressionOut.print(companyProfile?.province)
printHtmlPart(20)
expressionOut.print(companyProfile?.city)
printHtmlPart(21)
expressionOut.print(companyProfile?.pincode)
printHtmlPart(22)
expressionOut.print(companyProfile?.mobile)
printHtmlPart(23)
expressionOut.print(companyProfile?.phone)
printHtmlPart(24)
expressionOut.print(companyProfile?.email)
printHtmlPart(25)
expressionOut.print(companyProfile?.website)
printHtmlPart(26)
expressionOut.print(companyProfile?.turnover?.toLong())
printHtmlPart(27)
invokeTag('select','g',304,['name':("title"),'req':("1"),'class':("width"),'from':(CompanyProfile?.TitleName?.values()),'value':(companyProfile?.title),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(28)
expressionOut.print(companyProfile?.firstName)
printHtmlPart(29)
expressionOut.print(companyProfile?.middleName)
printHtmlPart(30)
expressionOut.print(companyProfile?.lastName)
printHtmlPart(31)
expressionOut.print(companyProfile?.designation)
printHtmlPart(32)
expressionOut.print(companyProfile?.personMobile)
printHtmlPart(33)
expressionOut.print(companyProfile?.personEmail)
printHtmlPart(34)
if(true && (companyProfile?.registrationDoc)) {
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(35)
expressionOut.print(companyProfile?.registrationDocName)
printHtmlPart(13)
})
invokeTag('link','g',399,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile?.id),'target':("_blank"),'params':([filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (companyProfile?.passportCopy)) {
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(35)
expressionOut.print(companyProfile?.passportCopyFileName)
printHtmlPart(13)
})
invokeTag('link','g',419,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(36)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (companyProfile?.passportCopy)) {
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(35)
expressionOut.print(companyProfile?.authorizationLetterFileName)
printHtmlPart(13)
})
invokeTag('link','g',442,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(36)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
invokeTag('select','g',502,['name':("agentTitle"),'req':("1"),'class':("width controlreq"),'value':(agentProfile?.title),'from':(AgentProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(43)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(44)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(45)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(46)
expressionOut.print(agentProfile?.address1)
printHtmlPart(47)
expressionOut.print(agentProfile?.address2)
printHtmlPart(48)
expressionOut.print(agentProfile?.address3)
printHtmlPart(49)
expressionOut.print(agentProfile?.province)
printHtmlPart(50)
expressionOut.print(agentProfile?.city)
printHtmlPart(51)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(52)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(53)
expressionOut.print(agentProfile?.phone)
printHtmlPart(54)
expressionOut.print(agentProfile?.email)
printHtmlPart(55)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(35)
createTagBody(4, {->
printHtmlPart(56)
expressionOut.print(agentProfile?.authorizationLetterFileName)
printHtmlPart(35)
})
invokeTag('link','g',648,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(13)
}
else {
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(35)
createTagBody(4, {->
printHtmlPart(56)
expressionOut.print(agentProfile?.passportCopyFileName)
printHtmlPart(35)
})
invokeTag('link','g',674,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: 'passportCopyFileName', dataName: 'passportCopyFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(13)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
createClosureForHtmlPart(61, 3)
invokeTag('link','g',696,['controller':("applicationManagement"),'action':("form1Part2"),'params':([appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}']),'class':("btn  login-btin pull-right"),'method':("POST")],3)
printHtmlPart(62)
})
invokeTag('uploadForm','g',700,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitCompanyProfile")],2)
printHtmlPart(63)
})
invokeTag('captureBody','sitemesh',712,[:],1)
printHtmlPart(64)
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
