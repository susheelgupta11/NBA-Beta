
import org.nba.application.CompanyProfile


import org.nba.application.AgentProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formBindianResearcher_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/indianResearcher.gsp" }
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
invokeTag('captureHead','sitemesh',250,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchCountryCode'))
printHtmlPart(7)
expressionOut.print(tabStatus)
printHtmlPart(8)
expressionOut.print(createLink(controller:'applicationManagement',action:'getNationality'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchMobileCode'))
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(11)
})
invokeTag('javascript','g',262,[:],2)
printHtmlPart(12)
invokeTag('render','g',266,['template':("/applicationManagement/leftTabs")],-1)
printHtmlPart(13)
if(true && (flash?.message)) {
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('render','g',305,['template':("indianResearcher"),'model':([formType:formType,listOfCountries:listOfCountries,nationality:nationality,addressproofSelect:addressproof,appFormId:appForm?.id,indianResearcher:indianResearcher1])],-1)
printHtmlPart(16)
if(true && (listOfIndianResearcher!=null)) {
printHtmlPart(17)
invokeTag('render','g',326,['template':("indianResearcherGrid"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",appFormId:appForm?.id,indianResearcher:indianResearcher1,listOfIndianResearcher:listOfIndianResearcher,deleteCalled:deleteCalled])],-1)
printHtmlPart(18)
}
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',333,['controller':("formB"),'action':("formBPart2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary btnfirstNext inactive"),'method':("POST")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',334,[:],1)
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
