import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_editForm1Part3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_editForm1Part3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(1)
if(true && (contactPersonInst?.contactPerson != 'Any Other Person accompanying applicant' && 
											contactPersonInst?.contactPerson != 'No' && appForm?.selfAuthorizedPerson == 'Self')) {
printHtmlPart(2)
invokeTag('radio','g',18,['class':("contactPerson radio col-sm-1"),'checked':("checked"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'value':("Self")],-1)
printHtmlPart(3)
}
else {
printHtmlPart(4)
invokeTag('radio','g',21,['class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'value':("Self")],-1)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (contactPersonInst?.contactPerson == 'Any Other Person accompanying applicant')) {
printHtmlPart(7)
invokeTag('radio','g',31,['checked':("checked"),'class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'value':("Any Other Person accompanying applicant")],-1)
printHtmlPart(8)
expressionOut.print(contactPersonInst?.contactPerson)
printHtmlPart(9)
}
else {
printHtmlPart(10)
invokeTag('radio','g',37,['class':("contactPerson radio col-sm-1"),'name':("contactPerson"),'onclick':("hideshowmorebtn(this)"),'value':("Any Other Person accompanying applicant")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (contactPersonInst?.contactPerson == 'No')) {
printHtmlPart(13)
invokeTag('radio','g',43,['class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'checked':("checked"),'name':("contactPerson"),'value':("No")],-1)
printHtmlPart(14)
}
else {
printHtmlPart(4)
invokeTag('radio','g',47,['class':("contactPerson radio col-sm-1"),'onclick':("hideshowmorebtn(this)"),'name':("contactPerson"),'value':("No")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(contactPersonInst?.nameOfContactPerson)
printHtmlPart(17)
expressionOut.print(contactPersonInst?.addressOfContactPerson)
printHtmlPart(18)
expressionOut.print(contactPersonInst?.mobileOfContactPerson)
printHtmlPart(19)
expressionOut.print(contactPersonInst?.emailOfContactPerson)
printHtmlPart(20)
invokeTag('hiddenField','g',87,['name':("appId"),'value':(appForm?.id)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',89,['name':("contactPersonInstId"),'value':(contactPersonInst?.id)],-1)
printHtmlPart(22)
})
invokeTag('formRemote','g',92,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveEditForm1Part3']),'update':("divAuthorizedPersonGrid"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
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
