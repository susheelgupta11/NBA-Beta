import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_form1part3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_form1part3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
if(true && (appForm?.selfAuthorizedPerson == 'Self')) {
printHtmlPart(3)
invokeTag('radio','g',19,['class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'checked':("checked"),'value':("Self")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('radio','g',24,['class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'value':("Self")],-1)
printHtmlPart(4)
}
printHtmlPart(6)
invokeTag('radio','g',30,['class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'value':("Any Other Person accompanying applicant")],-1)
printHtmlPart(7)
invokeTag('radio','g',34,['class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'value':("No")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',72,['name':("appId"),'value':(appForm?.id)],-1)
printHtmlPart(9)
})
invokeTag('formRemote','g',78,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveContactperson']),'update':("divAuthorizedPersonGrid"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664200275971L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
