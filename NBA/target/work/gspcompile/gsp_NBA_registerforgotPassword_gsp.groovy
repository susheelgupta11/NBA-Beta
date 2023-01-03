import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_registerforgotPassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/forgotPassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',3,['code':("spring.security.ui.forgotPassword.title")],-1)
})
invokeTag('captureTitle','sitemesh',3,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',3,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',64,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(8)
if(true && (emailSent)) {
printHtmlPart(9)
invokeTag('message','g',83,['code':("spring.security.ui.forgotPassword.sent")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',85,['controller':("login"),'action':("auth"),'class':("btn btn-primary "),'params':([csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(12)
}
else {
printHtmlPart(13)
invokeTag('message','g',92,['code':("spring.security.ui.forgotPassword.username")],-1)
printHtmlPart(14)
invokeTag('textField','g',94,['name':("username"),'size':("25")],-1)
printHtmlPart(15)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',121,['controller':("login"),'action':("auth"),'class':("btn btn-primary"),'params':([csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(1)
invokeTag('submitButton','g',122,['name':("submitResetForm"),'onclick':(" return CheckValidCaptcha();"),'class':("btn btn-primary"),'value':("Reset")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('form','g',126,['action':("forgotPassword"),'name':("forgotPasswordForm"),'autocomplete':("off")],2)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',137,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1669008858688L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
