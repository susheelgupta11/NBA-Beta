
import org.nba.application.IndividualProfile


import org.nba.application.AgentProfile


import org.nba.common.Country

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementindividualProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/individualProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
invokeTag('remoteFunction','g',226,['controller':("applicationManagement"),'action':("fetchCountries"),'update':("notIndian"),'params':([selectedCountry:selectedCountry,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',232,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchCountryCode'))
printHtmlPart(8)
expressionOut.print(tabStatus)
printHtmlPart(9)
expressionOut.print(createLink(controller:'applicationManagement',action:'getNationality'))
printHtmlPart(10)
})
invokeTag('javascript','g',239,[:],2)
printHtmlPart(11)
invokeTag('render','g',246,['template':("leftTabs"),'model':([appFormId:appForm?.id,formType:formType])],-1)
printHtmlPart(12)
invokeTag('render','g',279,['template':("individualProfile"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",statesList:statesList,individualProfile:individualProfile1,listOfIndividualProfiles:listOfIndividualProfiles, profile:profile])],-1)
printHtmlPart(13)
if(true && (listOfIndividualProfiles!=null)) {
printHtmlPart(14)
invokeTag('render','g',286,['template':("individualProfileGrid"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",appFormId:appForm?.id,individualProfile:individualProfile1,listOfIndividualProfiles:listOfIndividualProfiles,deleteCalled:deleteCalled])],-1)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('render','g',287,['template':("addAgentProfile"),'model':([appForm:appForm])],-1)
printHtmlPart(17)
if(true && (agentProfile)) {
printHtmlPart(14)
invokeTag('render','g',296,['template':("agentProfileGrid"),'model':([agentProfile:agentProfile,appForm:appForm])],-1)
printHtmlPart(15)
}
printHtmlPart(18)
if(true && (formType == 'Form1')) {
printHtmlPart(15)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',311,['controller':("applicationManagement"),'action':("form1Part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(20)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(15)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',316,['controller':("form2"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(20)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(15)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',321,['controller':("form3"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(20)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(15)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',326,['controller':("form4"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',327,[:],1)
printHtmlPart(22)
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
