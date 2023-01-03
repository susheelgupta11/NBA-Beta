import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1Part5_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1Part5.gsp" }
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
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(appForm?.otpStatus)
printHtmlPart(7)
expressionOut.print(tabStatus)
printHtmlPart(8)
expressionOut.print(appForm?.id)
printHtmlPart(9)
expressionOut.print(declaration)
printHtmlPart(10)
})
invokeTag('javascript','g',45,[:],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',66,['controller':("applicationManagement"),'post':("true"),'action':("changeAppStatus"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],2)
printHtmlPart(13)
invokeTag('render','g',78,['template':("leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(16)
invokeTag('hiddenField','g',126,['name':("formType"),'value':(formType)],-1)
printHtmlPart(17)
invokeTag('actionSubmit','g',129,['action':("changeAppStatus"),'class':("btn btn-primary"),'value':("OK")],-1)
printHtmlPart(18)
if(true && (!declaration)) {
printHtmlPart(19)
}
else if(true && (declaration)) {
printHtmlPart(20)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (formType == 'Form1')) {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (formType == 'Form1')) {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (formType == 'Form1')) {
printHtmlPart(20)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(29)
invokeTag('checkBox','g',239,['class':("checkbox"),'type':("checkbox"),'checked':("true"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)"),'style':("float:left; min-width:26px;margin:-5px")],-1)
printHtmlPart(30)
}
else {
printHtmlPart(29)
invokeTag('checkBox','g',246,['class':("checkbox"),'type':("checkbox"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)"),'style':("float:left; min-width:26px;margin:-5px")],-1)
printHtmlPart(31)
}
printHtmlPart(32)
}
else {
printHtmlPart(20)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(29)
invokeTag('checkBox','g',258,['class':("checkbox"),'type':("checkbox"),'checked':("true"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)"),'style':("float:left; min-width:26px; margin:-5px")],-1)
printHtmlPart(33)
}
else {
printHtmlPart(29)
invokeTag('checkBox','g',267,['class':("checkbox"),'type':("checkbox"),'name':("submitCheck"),'onclick':("DisableSumitbtn(this)"),'style':("float:left; min-width:26px;margin:-5px")],-1)
printHtmlPart(34)
}
printHtmlPart(32)
}
printHtmlPart(35)
invokeTag('hiddenField','g',276,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(36)
invokeTag('actionSubmit','g',278,['controller':("applicationManagement"),'id':("savebtn"),'action':("saveDeclaration"),'class':("btn btn-primary"),'value':("Save")],-1)
printHtmlPart(37)
expressionOut.print(appForm?.id)
printHtmlPart(38)
if(true && (formType == 'Form1')) {
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',289,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary preview"),'action':("form1preview"),'disabled':("true"),'params':([formType:formType,declaration:declaration,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(20)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',299,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary preview"),'action':("form1preview"),'disabled':("true"),'params':([formType:formType,declaration:declaration,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(20)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',304,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary preview"),'action':("form1preview"),'disabled':("true"),'params':([formType:formType,declaration:declaration,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(20)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',310,['controller':("applicationManagement"),'id':("preview"),'class':("btn btn-primary preview"),'action':("form1preview"),'disabled':("true"),'params':([formType:formType,declaration:declaration,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(20)
}
printHtmlPart(41)
})
invokeTag('form','g',314,['autocomplete':("off")],2)
printHtmlPart(42)
expressionOut.print(appForm?.id)
printHtmlPart(43)
invokeTag('textField','g',326,['name':("otptext"),'id':("getOtp")],-1)
printHtmlPart(44)
expressionOut.print(appForm?.id)
printHtmlPart(45)
if(true && (appForm?.otpStatus == false)) {
printHtmlPart(46)
expressionOut.print(appForm?.id)
printHtmlPart(43)
invokeTag('textField','g',336,['name':("otptext"),'id':("getOtp")],-1)
printHtmlPart(44)
expressionOut.print(appForm?.id)
printHtmlPart(47)
}
else if(true && (appForm?.otpStatus == true)) {
printHtmlPart(48)
}
printHtmlPart(49)
})
invokeTag('captureBody','sitemesh',343,[:],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664297375040L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
