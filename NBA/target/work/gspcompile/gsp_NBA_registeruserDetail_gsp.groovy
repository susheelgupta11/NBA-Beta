import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_registeruserDetail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/userDetail.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
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
invokeTag('captureHead','sitemesh',33,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(flash.message)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(7)
if(true && (emailSent)) {
printHtmlPart(8)
invokeTag('message','g',60,['code':("spring.security.ui.register.sent")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(10)
expressionOut.print(currentUser?.username)
printHtmlPart(11)
expressionOut.print(currentUser?.name)
printHtmlPart(12)
expressionOut.print(currentUser?.email)
printHtmlPart(13)
expressionOut.print(currentUser?.dateOfBirth?.format('dd/MM/yyyy'))
printHtmlPart(14)
expressionOut.print(currentUser?.mobile)
printHtmlPart(15)
expressionOut.print(currentUser?.phone)
printHtmlPart(16)
createClosureForHtmlPart(17, 4)
invokeTag('link','g',147,['controller':("login"),'action':("auth"),'class':("btn btn-primary"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(18)
invokeTag('hiddenField','g',148,['name':("userId"),'value':(currentUser?.id)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('form','g',155,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveuserDetails"),'name':("registerForm")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',161,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1651300669418L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
