import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_authorizedPersonForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_authorizedPersonForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
for( contactPersonInst in (listOfContactPerson) ) {
printHtmlPart(1)
if(true && (contactPersonInst?.contactPerson == 'Self')) {
printHtmlPart(2)
invokeTag('radio','g',12,['class':(" radio col-sm-1"),'checked':("checked"),'disabled':("disabled"),'name':("contactPerson"),'value':("Self")],-1)
printHtmlPart(3)
expressionOut.print(contactPersonInst?.contactPerson)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (contactPersonInst?.contactPerson == 'Any Other Person accompanying applicant')) {
printHtmlPart(6)
invokeTag('radio','g',21,['disabled':("disabled"),'checked':("checked"),'class':(" radio col-sm-1"),'name':("contactPerson"),'value':("Any Other Person accompanying applicant")],-1)
printHtmlPart(7)
expressionOut.print(contactPersonInst?.contactPerson)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (contactPersonInst?.contactPerson == 'No')) {
printHtmlPart(10)
invokeTag('radio','g',26,['class':(" radio col-sm-1"),'checked':("checked"),'disabled':("disabled"),'name':("contactPerson"),'value':("No")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (contactPersonInst?.contactPerson != 'Self')) {
printHtmlPart(13)
expressionOut.print(contactPersonInst?.nameOfContactPerson)
printHtmlPart(14)
expressionOut.print(contactPersonInst?.addressOfContactPerson)
printHtmlPart(15)
expressionOut.print(contactPersonInst?.mobileOfContactPerson)
printHtmlPart(16)
expressionOut.print(contactPersonInst?.emailOfContactPerson)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
})
invokeTag('formRemote','g',52,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'url':([controller:'applicationManagement',action:'saveContactperson']),'update':("divAuthorizedPersonGrid"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
