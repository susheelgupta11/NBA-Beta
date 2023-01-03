import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loginreadMore_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/readMore.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
invokeTag('stylesheet','asset',12,['src':("home/animate.css")],-1)
printHtmlPart(5)
invokeTag('stylesheet','asset',14,['src':("home/icomoon.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',16,['src':("home/bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',18,['src':("home/superfish.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',20,['src':("home/magnific-popup.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',22,['src':("home/bootstrap-datepicker.min.css")],-1)
printHtmlPart(10)
invokeTag('stylesheet','asset',25,['src':("home/cs-select.css")],-1)
printHtmlPart(11)
invokeTag('stylesheet','asset',26,['src':("home/cs-skin-border.css")],-1)
printHtmlPart(11)
invokeTag('stylesheet','asset',27,['src':("home/style.css")],-1)
printHtmlPart(11)
invokeTag('stylesheet','asset',28,['src':("home/component.css")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',31,['src':("home/modernizr.custom.js")],-1)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(resource(dir: 'images', file: 'logo_nba.png'))
printHtmlPart(15)
expressionOut.print(resource(dir: 'images', file: 'MOEF-home.png'))
printHtmlPart(16)
expressionOut.print(resource(dir: 'images', file: 'Emblem_of_India2-home.png'))
printHtmlPart(17)
expressionOut.print(resource(dir: 'images', file: 'nic.png'))
printHtmlPart(18)
invokeTag('javascript','asset',133,['src':("home/jquery.min.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',134,['src':("home/jquery.easing.1.3.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',135,['src':("home/bootstrap.min.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',136,['src':("home/jquery.waypoints.min.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',137,['src':("home/sticky.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',138,['src':("home/jquery.stellar.min.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',139,['src':("home/hoverIntent.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',140,['src':("home/superfish.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',141,['src':("home/jquery.magnific-popup.min.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',142,['src':("home/magnific-popup-options.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',143,['src':("home/bootstrap-datepicker.min.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',144,['src':("home/classie.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',145,['src':("home/selectFx.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',146,['src':("home/modalEffects.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',147,['src':("home/main.js")],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',176,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671454991676L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
