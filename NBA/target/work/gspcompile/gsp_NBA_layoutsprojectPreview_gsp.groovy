import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsprojectPreview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/projectPreview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)

response.setHeader("Cache-Control", "private");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setDateHeader("Expires", -1);

printHtmlPart(1)

response.setHeader("Cache-control", "no-store"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP1.0
        response.setDateHeader("Expire", 0); //prevents caching at the proxy server

printHtmlPart(1)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',24,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',26,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(6)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(7)
invokeTag('stylesheet','asset',31,['src':("application.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',32,['src':("bootstrap.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',33,['src':("bootstrap-theme.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',35,['src':("jquery-ui.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',36,['src':("myBootstrap.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',37,['src':("mybootstrap2.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',38,['src':("print.css"),'media':("print")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',39,['src':("jquery.tooltip.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',40,['src':("jquery-v.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',41,['src':("jquery-migrate-1.2.1.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',42,['src':("jquery-ui.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',43,['src':("bootstrap.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',44,['src':("expand.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',45,['src':("modernizr-1.7.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',45,['src':("Main.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',47,['src':("MoES_Validations.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',48,['src':("jquery.tooltip.js")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',48,[:],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',48,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
invokeTag('layoutBody','g',52,[:],-1)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537947378000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
