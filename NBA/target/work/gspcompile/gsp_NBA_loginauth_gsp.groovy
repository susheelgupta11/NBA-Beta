
import org.nba.master.ManageLoginContent

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loginauth_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/auth.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
invokeTag('stylesheet','asset',15,['src':("home/animate.css")],-1)
printHtmlPart(5)
invokeTag('stylesheet','asset',17,['src':("home/icomoon.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',19,['src':("home/bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',21,['src':("home/superfish.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',23,['src':("home/magnific-popup.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',26,['src':("home/bootstrap-datepicker.min.css")],-1)
printHtmlPart(10)
invokeTag('stylesheet','asset',27,['src':("home/cs-select.css")],-1)
printHtmlPart(11)
invokeTag('stylesheet','asset',29,['src':("home/cs-skin-border.css")],-1)
printHtmlPart(11)
invokeTag('stylesheet','asset',30,['src':("home/style.css")],-1)
printHtmlPart(11)
invokeTag('stylesheet','asset',31,['src':("home/component.css")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',34,['src':("home/modernizr.custom.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',35,['src':("NBA.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',36,['src':("/aes.js")],-1)
printHtmlPart(13)
invokeTag('stylesheet','asset',40,['src':("beta-version/css/jquery.datetimepicker.min.css")],-1)
printHtmlPart(14)

def aboutNBA = ManageLoginContent?.findByRev(0)

printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(aboutNBA?.aboutNBA)
printHtmlPart(16)
expressionOut.print(aboutNBA?.latestUpdate)
printHtmlPart(17)
expressionOut.print(createLink(controller:'login',action:'sec'))
printHtmlPart(18)
})
invokeTag('javascript','g',47,[:],2)
printHtmlPart(19)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(20)
})
invokeTag('captureHead','sitemesh',111,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(21)
expressionOut.print(resource(dir: 'images', file: 'logo_nba.png'))
printHtmlPart(22)
expressionOut.print(resource(dir: 'images', file: 'MOEF-home.png'))
printHtmlPart(23)
expressionOut.print(resource(dir: 'images', file: 'Emblem_of_India2-home.png'))
printHtmlPart(24)
expressionOut.print(resource(dir: 'images', file: 'bg-home.jpg'))
printHtmlPart(25)
expressionOut.print(postUrl)
printHtmlPart(26)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(27)
if(true && (flash.message)) {
printHtmlPart(28)
expressionOut.print(flash.message)
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (flash.error)) {
printHtmlPart(28)
expressionOut.print(flash.error)
printHtmlPart(29)
}
printHtmlPart(31)
expressionOut.print(createLink(controller: 'simpleCaptcha', action: 'captcha'))
printHtmlPart(32)
if(true && (flash.message)) {
printHtmlPart(33)
expressionOut.print(flash.message)
printHtmlPart(34)
}
printHtmlPart(35)
invokeTag('render','g',231,['template':("registration")],-1)
printHtmlPart(36)

def aboutNBA = ManageLoginContent?.findByRev(0)

printHtmlPart(37)
expressionOut.print(aboutNBA?.aboutNBA?.toString()?.replaceAll("\\<.*?>","")?.replace("&nbsp;", " "))
printHtmlPart(38)
createClosureForHtmlPart(39, 2)
invokeTag('link','g',248,['controller':("login"),'action':("readMore"),'target':("_blank")],2)
printHtmlPart(40)
createClosureForHtmlPart(41, 2)
invokeTag('link','g',295,['controller':("register"),'action':("howToApply"),'params':([aboutNBAId: "${aboutNBA?.id}"]),'class':("")],2)
printHtmlPart(42)
if(true && (doc != null)) {
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',302,['controller':("login"),'action':("showDc"),'id':(doc?.id),'target':("_blank"),'params':([filename: "manual", dataName: "manual"])],3)
printHtmlPart(45)
}
else {
printHtmlPart(46)
}
printHtmlPart(47)
createClosureForHtmlPart(48, 2)
invokeTag('link','g',309,['controller':("register"),'action':("faq"),'params':([aboutNBAId: "${aboutNBA?.id}"]),'class':(" ")],2)
printHtmlPart(49)
createClosureForHtmlPart(50, 2)
invokeTag('link','g',316,['controller':("register"),'action':("knowYourFormPart1"),'params':([]),'class':("")],2)
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(52)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(53)
invokeTag('textField','g',345,['name':("username"),'class':("form-control"),'id':("from-place"),'placeholder':("Enter User Id")],-1)
printHtmlPart(54)
})
invokeTag('form','g',348,['action':("forgotPassword"),'controller':("register"),'name':("forgotPasswordForm"),'autocomplete':("off")],2)
printHtmlPart(55)
createTagBody(2, {->
printHtmlPart(56)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(57)
})
invokeTag('form','g',376,['class':("form-horizontal row"),'role':("form"),'autocomplete':("off"),'action':("showUserId"),'controller':("register"),'name':("registerForm")],2)
printHtmlPart(58)
expressionOut.print(resource(dir: 'images', file: 'nic.png'))
printHtmlPart(59)
invokeTag('javascript','asset',404,['src':("home/jquery.min.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',404,['src':("home/jquery.easing.1.3.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',407,['src':("home/bootstrap.min.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',411,['src':("home/jquery.waypoints.min.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',414,['src':("home/sticky.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',414,['src':("home/jquery.stellar.min.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',416,['src':("home/hoverIntent.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',417,['src':("home/superfish.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',418,['src':("home/jquery.magnific-popup.min.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',419,['src':("home/magnific-popup-options.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',421,['src':("home/bootstrap-datepicker.min.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',421,['src':("home/classie.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',422,['src':("home/selectFx.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',423,['src':("home/modalEffects.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',424,['src':("home/main.js")],-1)
printHtmlPart(60)
invokeTag('javascript','asset',425,['src':("beta-version/js/calander/jquery.datetimepicker.js")],-1)
printHtmlPart(61)
createTagBody(2, {->
printHtmlPart(62)
expressionOut.print(secc)
printHtmlPart(63)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(18)
})
invokeTag('javascript','g',491,[:],2)
printHtmlPart(64)
})
invokeTag('captureBody','sitemesh',492,[:],1)
printHtmlPart(65)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671607671124L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
