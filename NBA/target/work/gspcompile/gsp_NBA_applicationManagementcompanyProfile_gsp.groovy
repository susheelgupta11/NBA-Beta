
import org.nba.application.CompanyProfile


import org.nba.application.AgentProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementcompanyProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/companyProfile.gsp" }
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
invokeTag('captureHead','sitemesh',37,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchMobileCode'))
printHtmlPart(7)
expressionOut.print(tabStatus)
printHtmlPart(8)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(9)
})
invokeTag('javascript','g',44,[:],2)
printHtmlPart(10)
invokeTag('render','g',48,['template':("leftTabs")],-1)
printHtmlPart(11)
if(true && (flash?.message)) {
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('render','g',87,['template':("companyProfile"),'model':([companyProfile1:companyProfile1,listOfCompanyProfiles:listOfCompanyProfiles,appForm:appForm])],-1)
printHtmlPart(14)
if(true && (listOfCompanyProfiles != null)) {
printHtmlPart(15)
invokeTag('render','g',94,['template':("companyProfileGrid"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",appForm:appForm,companyProfile1:companyProfile1,listOfCompanyProfiles:listOfCompanyProfiles,formType:formType,deleteCompanyCalled:deleteCompanyCalled])],-1)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('render','g',98,['template':("addAgentProfile"),'model':([agentProfile:agentProfile,profiles:profiles,company:company,listOfStates:listOfStates])],-1)
printHtmlPart(18)
if(true && (agentProfile)) {
printHtmlPart(15)
invokeTag('render','g',100,['template':("agentProfileGrid"),'model':([appForm:appForm,agentProfile:agentProfile,company:company,listOfStates:listOfStates ])],-1)
printHtmlPart(16)
}
printHtmlPart(19)
if(true && (formType == 'Form1')) {
printHtmlPart(15)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',104,['controller':("applicationManagement"),'action':("form1Part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(16)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(15)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',114,['controller':("form2"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(16)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(15)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',120,['controller':("form3"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(16)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(15)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',127,['controller':("form4"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],3)
printHtmlPart(16)
}
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',132,[:],1)
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
