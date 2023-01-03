import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form3part4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form3/part4.gsp" }
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
invokeTag('captureHead','sitemesh',35,[:],1)
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
invokeTag('link','g',92,['controller':("applicationManagement"),'post':("true"),'action':("changeAppStatus"),'params':([formType:formType,appFormId:appForm?.id]),'class':("btn btn-success")],1)
printHtmlPart(12)
invokeTag('render','g',107,['template':("leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(15)
invokeTag('hiddenField','g',153,['name':("formType"),'value':(formType)],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',155,['name':("appFormId"),'value':(appform?.id)],-1)
printHtmlPart(16)
invokeTag('actionSubmit','g',157,['controller':("applicationManagement"),'action':("changeAppStatus"),'class':("btn btn-primary"),'value':("OK")],-1)
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
invokeTag('checkBox','g',269,['class':("checkbox"),'type':("checkbox"),'checked':("true"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('checkBox','g',281,['class':("checkbox"),'type':("checkbox"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)")],-1)
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('hiddenField','g',287,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(19)
invokeTag('actionSubmit','g',292,['controller':("applicationManagement"),'action':("saveDeclaration"),'class':("btn btn-primary"),'value':("Save")],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',297,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary preview"),'action':("form1preview"),'disabled':("true"),'params':([formType:formType,declaration:declaration,appFormId:appForm?.id])],2)
printHtmlPart(29)
})
invokeTag('form','g',302,['autocomplete':("off")],1)
printHtmlPart(30)
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
