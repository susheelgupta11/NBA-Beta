
import java.util.Collections

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formBformBPart2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/formBPart2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',99,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
expressionOut.print(entity2)
printHtmlPart(8)
expressionOut.print(entity2?.name)
printHtmlPart(9)
expressionOut.print(entity2?.supervisorDesignation)
printHtmlPart(10)
expressionOut.print(entity2?.headOfInstName)
printHtmlPart(11)
expressionOut.print(entity2?.headOfInstDesignation)
printHtmlPart(12)
expressionOut.print(entity2?.supervisorOrHoi)
printHtmlPart(13)
})
invokeTag('javascript','g',117,[:],2)
printHtmlPart(14)
invokeTag('render','g',126,['template':("/applicationManagement/leftTabs"),'model':([appForm:appForm,formType:formType])],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',160,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(16)
invokeTag('render','g',166,['template':("formBpart2")],-1)
printHtmlPart(17)
invokeTag('render','g',174,['template':("formBPart2HeadDetails")],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',194,['controller':("formB"),'action':("indianResearcher"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],2)
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',199,['controller':("formB"),'action':("formBPart3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',205,[:],1)
printHtmlPart(23)
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
