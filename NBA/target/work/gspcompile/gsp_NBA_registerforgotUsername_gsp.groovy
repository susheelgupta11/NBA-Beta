import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_registerforgotUsername_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/forgotUsername.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("spring.security.ui.register.title")],-1)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',59,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(flash.message)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(7)
if(true && (user)) {
printHtmlPart(8)
invokeTag('message','g',85,['code':("Your username is: ")],-1)
printHtmlPart(9)
expressionOut.print(user?.username)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',90,['controller':("login"),'action':("auth"),'class':("btn btn-primary "),'params':([csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(12)
}
else {
printHtmlPart(13)
if(true && (isUserAvailable == 'false')) {
printHtmlPart(14)
invokeTag('message','g',98,['code':("No user exists with this email id ")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',133,['controller':("login"),'action':("auth"),'class':("btn btn-primary"),'params':([])],4)
printHtmlPart(17)
invokeTag('hiddenField','g',134,['name':("userId"),'value':(currentUser?.id)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
})
invokeTag('form','g',135,['class':("form-horizontal row"),'role':("form"),'autocomplete':("off"),'action':("showUserId"),'name':("registerForm")],2)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',137,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1670220320601L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
