import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)

response.setHeader("Cache-Control","private");
response.setHeader("Cache-Control","no-store");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1);

printHtmlPart(1)

response.setHeader("Cache-control","no-store"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP1.0 
response.setDateHeader("Expire",0); //prevents caching at the proxy server

printHtmlPart(2)
invokeTag('captureMeta','sitemesh',27,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Cache-control"),'content':("private")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',28,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Cache-control"),'content':("no-cache")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',29,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Cache-control"),'content':("no-store")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',31,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',32,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',34,['default':("National Biodiversity Application")],-1)
})
invokeTag('captureTitle','sitemesh',34,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',34,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',35,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(6)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(7)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(8)
expressionOut.print(assetPath(src: 'images/logo.png'))
printHtmlPart(9)
invokeTag('stylesheet','asset',46,['src':("jquery-ui.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',47,['src':("jquery.datepick.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',48,['src':("bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',49,['src':("custom.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',50,['src':("mybootstrap2.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',51,['src':("jquery.tooltip.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',52,['src':("font-awesome.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',53,['src':("calender/kendo.dataviz.material.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',54,['src':("calender/kendo-material.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',55,['src':("calender/kendo-dataviz.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',56,['src':("calender/kendo-dataviz.material.min.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',58,['src':("jquery-vv.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',59,['src':("jquery-v.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',60,['src':("/aes.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',61,['src':("NBA.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',62,['src':("blockUI.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',63,['src':("jquery-ui.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',64,['src':("bootstrap.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',65,['src':("jquery-datepick.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',66,['src':("responsive-calendar.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',67,['src':("MoES_Validations.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',68,['src':("responsive-calendar.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',69,['src':("calender/kendo-all.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',70,['src':("calender/kendo-all.min.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',72,[:],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',73,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(10)
invokeTag('render','g',78,['template':("/layouts/outerheader"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(11)
invokeTag('layoutBody','g',80,[:],-1)
printHtmlPart(12)
invokeTag('render','g',83,['template':("/layouts/footer")],-1)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1538033066000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
