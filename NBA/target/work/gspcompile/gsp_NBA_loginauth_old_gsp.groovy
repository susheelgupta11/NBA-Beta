
import org.nba.master.ManageLoginContent

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loginauth_old_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/auth_old.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',10,['src':("/ckeditor/ckeditor.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',11,['src':("/ckeditor/jquery.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',12,['src':("/aes.js")],-1)
printHtmlPart(4)

def aboutNBA = ManageLoginContent?.findByRev(0)

printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(aboutNBA?.aboutNBA)
printHtmlPart(7)
expressionOut.print(aboutNBA?.latestUpdate)
printHtmlPart(8)
expressionOut.print(createLink(controller:'login',action:'sec'))
printHtmlPart(9)
})
invokeTag('javascript','g',30,[:],2)
printHtmlPart(10)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',101,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(sec)
printHtmlPart(13)

def aboutNBA = ManageLoginContent?.findByRev(0)

printHtmlPart(14)
expressionOut.print(postUrl)
printHtmlPart(15)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',144,['code':("Username")],-1)
printHtmlPart(20)
expressionOut.print(createLink(controller: 'simpleCaptcha', action: 'captcha'))
printHtmlPart(21)
invokeTag('textField','g',170,['name':("captcha"),'req':("1"),'class':("margin-top"),'required':("required")],-1)
printHtmlPart(22)
if(true && (captchaInvalid == true)) {
printHtmlPart(23)
}
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('link','g',189,['class':("red"),'controller':("register"),'action':("forgotPassword"),'params':([])],2)
printHtmlPart(26)
createClosureForHtmlPart(27, 2)
invokeTag('link','g',194,['class':("red"),'controller':("register"),'action':("forgotUsername"),'params':([])],2)
printHtmlPart(28)
expressionOut.print(resource(dir: 'images', file: 'blue.png'))
printHtmlPart(29)
createClosureForHtmlPart(30, 2)
invokeTag('link','g',239,['controller':("register"),'action':("howToApply"),'params':([aboutNBAId: "${aboutNBA?.id}"]),'class':("text-primary ")],2)
printHtmlPart(31)
expressionOut.print(resource(dir: 'images', file: 'blue.png'))
printHtmlPart(32)
if(true && (doc != null)) {
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',259,['class':("text-primary "),'controller':("login"),'action':("showDc"),'id':(doc?.id),'target':("_blank"),'params':([filename: "manual", dataName: "manual"])],3)
printHtmlPart(35)
}
else {
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(resource(dir: 'images', file: 'blue.png'))
printHtmlPart(38)
createClosureForHtmlPart(39, 2)
invokeTag('link','g',267,['controller':("register"),'action':("faq"),'params':([aboutNBAId: "${aboutNBA?.id}"]),'class':("text-primary ")],2)
printHtmlPart(37)
expressionOut.print(resource(dir: 'images', file: 'blue.png'))
printHtmlPart(29)
createClosureForHtmlPart(40, 2)
invokeTag('link','g',269,['controller':("register"),'action':("knowYourFormPart1"),'params':([]),'class':("text-primary ")],2)
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
expressionOut.print(sec)
printHtmlPart(43)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(9)
})
invokeTag('javascript','g',274,[:],2)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',275,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664876186087L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
