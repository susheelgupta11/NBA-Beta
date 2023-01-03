import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_formCRepository_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_formCRepository.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
expressionOut.print(applicationform?.depositionPerpose)
printHtmlPart(3)
invokeTag('hiddenField','g',25,['name':("profileId"),'value':(microOrgaScirntistName?.id)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',27,['name':("formType"),'value':(formType)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',31,['name':("appFormId"),'value':(appForm)],-1)
printHtmlPart(5)
})
invokeTag('formRemote','g',33,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'submitDepositionPerpose']),'onComplete':("loadPage()")],1)
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
