
import org.nba.master.ManageLoginContent

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loginauth_new_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/auth_new.gsp" }
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
invokeTag('stylesheet','asset',13,['src':("home/animate.css")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',15,['src':("home/icomoon.css")],-1)
printHtmlPart(5)
invokeTag('stylesheet','asset',17,['src':("home/bootstrap.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',19,['src':("home/superfish.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',21,['src':("home/magnific-popup.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',23,['src':("home/bootstrap-datepicker.min.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',26,['src':("home/cs-select.css")],-1)
printHtmlPart(10)
invokeTag('stylesheet','asset',27,['src':("home/cs-skin-border.css")],-1)
printHtmlPart(10)
invokeTag('stylesheet','asset',28,['src':("home/style.css")],-1)
printHtmlPart(10)
invokeTag('stylesheet','asset',29,['src':("home/component.css")],-1)
printHtmlPart(11)
invokeTag('javascript','asset',32,['src':("home/modernizr.custom.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',33,['src':("NBA.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',34,['src':("/aes.js")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',39,['src':("home/jquery.min.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',40,['src':("home/jquery.easing.1.3.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',41,['src':("home/bootstrap.min.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',42,['src':("home/jquery.waypoints.min.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',43,['src':("home/sticky.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',44,['src':("home/jquery.stellar.min.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',45,['src':("home/hoverIntent.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',46,['src':("home/superfish.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',47,['src':("home/jquery.magnific-popup.min.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',48,['src':("home/magnific-popup-options.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',49,['src':("home/bootstrap-datepicker.min.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',50,['src':("home/classie.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',51,['src':("home/selectFx.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',52,['src':("home/modalEffects.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',53,['src':("home/main")],-1)
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
invokeTag('javascript','g',60,[:],2)
printHtmlPart(19)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(20)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(21)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(22)
})
invokeTag('captureHead','sitemesh',327,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(23)
expressionOut.print(resource(dir: 'images', file: 'logo_nba.png'))
printHtmlPart(24)
expressionOut.print(resource(dir: 'images', file: 'MOEF-home.png'))
printHtmlPart(25)
expressionOut.print(resource(dir: 'images', file: 'Emblem_of_India2-home.png'))
printHtmlPart(26)
expressionOut.print(resource(dir: 'images', file: 'bg-home.jpg'))
printHtmlPart(27)
expressionOut.print(postUrl)
printHtmlPart(28)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(29)
expressionOut.print(createLink(controller: 'simpleCaptcha', action: 'captcha'))
printHtmlPart(30)
if(true && (flash.message)) {
printHtmlPart(31)
expressionOut.print(flash.message)
printHtmlPart(32)
}
printHtmlPart(33)
invokeTag('render','g',440,['template':("registration")],-1)
printHtmlPart(34)

def aboutNBA = ManageLoginContent?.findByRev(0)

printHtmlPart(35)
expressionOut.print(aboutNBA?.aboutNBA?.toString()?.replaceAll("\\<.*?>","")?.replace("&nbsp;", " "))
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
expressionOut.print(secc)
printHtmlPart(38)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(18)
})
invokeTag('javascript','g',607,[:],2)
printHtmlPart(39)
})
invokeTag('captureBody','sitemesh',608,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1667195357132L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
