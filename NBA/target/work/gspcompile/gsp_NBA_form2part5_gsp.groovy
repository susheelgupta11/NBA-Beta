import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form2part5_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form2/part5.gsp" }
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
invokeTag('captureHead','sitemesh',34,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(appForm?.id)
printHtmlPart(7)
expressionOut.print(declaration)
printHtmlPart(8)
expressionOut.print(tabStatus)
printHtmlPart(9)
})
invokeTag('javascript','g',45,[:],1)
printHtmlPart(10)
createClosureForHtmlPart(11, 1)
invokeTag('link','g',91,['controller':("applicationManagement"),'post':("true"),'action':("changeAppStatus"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}']),'class':("btn btn-success")],1)
printHtmlPart(12)
invokeTag('render','g',105,['template':("leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(15)
invokeTag('hiddenField','g',152,['name':("formType"),'value':(formType)],-1)
printHtmlPart(16)
invokeTag('actionSubmit','g',154,['action':("changeAppStatus"),'class':("btn btn-primary"),'value':("OK")],-1)
printHtmlPart(17)
if(true && (!declaration)) {
printHtmlPart(18)
}
else if(true && (declaration)) {
printHtmlPart(19)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(24)
invokeTag('checkBox','g',265,['class':("checkbox"),'type':("checkbox"),'checked':("true"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(26)
invokeTag('checkBox','g',277,['class':("checkbox"),'type':("checkbox"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)")],-1)
printHtmlPart(27)
}
printHtmlPart(28)
invokeTag('hiddenField','g',283,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(19)
invokeTag('actionSubmit','g',287,['controller':("applicationManagement"),'action':("saveDeclaration"),'class':("btn btn-primary"),'value':("Save")],-1)
printHtmlPart(29)
createClosureForHtmlPart(30, 2)
invokeTag('link','g',295,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary preview"),'action':("form1preview"),'disabled':("true"),'params':([formType:formType,declaration:declaration,appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}'])],2)
printHtmlPart(31)
})
invokeTag('form','g',298,['autocomplete':("off")],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
