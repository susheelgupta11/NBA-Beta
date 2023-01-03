import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1preview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1preview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',60,['controller':("applicationManagement"),'post':("true"),'action':("changeAppStatus"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],2)
printHtmlPart(7)
invokeTag('modalIncludes','modalbox',101,[:],-1)
printHtmlPart(8)
if(true && (formType == 'Form1')) {
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('createLink','modalbox',110,['action':("previewForm1Info"),'controller':("FormPreview"),'title':("Form I Preview"),'width':("1000"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"]),'height':("1200"),'id':(appForm?.id)],3)
printHtmlPart(11)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('createLink','modalbox',116,['action':("previewForm2Info"),'controller':("FormPreview"),'title':("Form II Preview"),'width':("1000"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"]),'height':("1200"),'id':(appForm?.id)],3)
printHtmlPart(8)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('createLink','modalbox',121,['action':("previewForm3Info"),'controller':("FormPreview"),'title':("Form III Preview"),'width':("1000"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"]),'height':("1200"),'id':(appForm?.id)],3)
printHtmlPart(12)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('createLink','modalbox',127,['action':("previewForm4Info"),'controller':("FormPreview"),'title':("Form IV Preview"),'width':("1000"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"]),'height':("1200"),'id':(appForm?.id)],3)
printHtmlPart(8)
}
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',132,['controller':("applicationManagement"),'action':("form1Part5"),'params':([formType:formType,declaration:declaration,appFormId:params?.appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',132,[:],1)
printHtmlPart(16)
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
