import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_registerchangePassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/changePassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',5,['src':("/aes.js")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("spring.security.ui.register.title")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(3)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(4)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',202,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
if(true && (message)) {
printHtmlPart(8)
expressionOut.print(message)
printHtmlPart(9)
}
else {
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('link','g',273,['controller':("loggedInAs"),'action':("inbox"),'class':("btn btn-primary"),'params':([])],4)
printHtmlPart(14)
invokeTag('hiddenField','g',274,['name':("userId"),'value':(currentUser?.id)],-1)
printHtmlPart(15)
})
invokeTag('form','g',278,['class':("form-horizontal row submitIfStrongPswd"),'role':("form"),'autocomplete':("off"),'url':([controller:'register',action:'saveChangedPassword']),'name':("registerForm")],3)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
expressionOut.print(secc)
printHtmlPart(19)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(20)
})
invokeTag('javascript','g',292,[:],2)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',293,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1653045196440L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
