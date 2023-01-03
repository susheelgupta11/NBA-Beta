import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_registerresetPassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/resetPassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',4,['code':("spring.security.ui.resetPassword.title")],-1)
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(5)
invokeTag('hiddenField','g',19,['name':("t"),'value':(token)],-1)
printHtmlPart(6)
invokeTag('passwordFieldRow','s2ui',25,['name':("password"),'labelCode':("resetPasswordCommand.password.label"),'bean':(command),'labelCodeDefault':("Password*"),'value':(command?.password)],-1)
printHtmlPart(7)
invokeTag('passwordFieldRow','s2ui',32,['name':("password2"),'labelCode':("resetPasswordCommand.password2.label"),'bean':(command),'labelCodeDefault':("Password(again)*"),'value':(command?.password2)],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',36,['controller':("login"),'action':("auth"),'class':("btn btn-primary"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(10)
invokeTag('submitButton','g',37,['class':("btn btn-primary"),'name':("save"),'value':("Save")],-1)
printHtmlPart(11)
})
invokeTag('form','g',41,['action':("resetPassword"),'name':("resetPasswordForm"),'autocomplete':("off")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(13)
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
