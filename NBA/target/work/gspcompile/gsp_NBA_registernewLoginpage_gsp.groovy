import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_registernewLoginpage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/newLoginpage.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(postUrl)
printHtmlPart(4)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('message','g',83,['code':("Username")],-1)
printHtmlPart(9)
expressionOut.print(createLink(controller: 'simpleCaptcha', action: 'captcha'))
printHtmlPart(10)
invokeTag('textField','g',104,['name':("captcha"),'req':("1")],-1)
printHtmlPart(11)
if(true && (captchaInvalid == true)) {
printHtmlPart(12)
}
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',115,['href':("#"),'class':("btn btn-primary"),'controller':("register"),'action':("index")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',122,['class':("red"),'controller':("register"),'action':("forgotPassword")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',125,['class':("red"),'controller':("register"),'action':("forgotUsername")],2)
printHtmlPart(19)
expressionOut.print(resource(dir: 'images', file: 'image5.PNG'))
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',188,['controller':("register"),'action':("howToApply"),'class':("text-primary ")],2)
printHtmlPart(22)
expressionOut.print(resource(dir: 'images', file: 'image5.PNG'))
printHtmlPart(23)
expressionOut.print(resource(dir: 'images', file: 'image5.PNG'))
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',223,[:],1)
printHtmlPart(25)
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
