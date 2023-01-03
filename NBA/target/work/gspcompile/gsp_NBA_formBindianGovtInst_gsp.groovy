
import org.nba.application.CompanyProfile


import org.nba.application.AgentProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formBindianGovtInst_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/indianGovtInst.gsp" }
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
invokeTag('captureHead','sitemesh',73,[:],1)
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
invokeTag('javascript','g',81,[:],2)
printHtmlPart(10)
invokeTag('render','g',86,['template':("/applicationManagement/leftTabs")],-1)
printHtmlPart(11)
if(true && (flash?.message)) {
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('render','g',124,['template':("indianGovtInst"),'model':([indianGovtInst:indianGovtInst1,listOfCompanyProfiles:listOfCompanyProfiles,appForm:appForm])],-1)
printHtmlPart(14)
if(true && (listOfIndianGovtInst!=null)) {
printHtmlPart(15)
invokeTag('render','g',145,['template':("indianGovtInstGrid"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",appFormId:appForm?.id,indianGovtInst:indianGovtInst1,listOfIndianGovtInst:listOfIndianGovtInst,deleteCalled:deleteCalled])],-1)
printHtmlPart(16)
}
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',154,['controller':("formB"),'action':("formBPart2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',155,[:],1)
printHtmlPart(20)
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
