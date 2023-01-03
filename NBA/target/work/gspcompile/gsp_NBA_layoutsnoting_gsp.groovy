import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsnoting_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/noting.gsp" }
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

printHtmlPart(1)
invokeTag('captureMeta','sitemesh',22,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',25,['default':("National Biodiversity Application")],-1)
})
invokeTag('captureTitle','sitemesh',25,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',25,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',26,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',36,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',37,['src':("googlefont.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',40,['src':("morquee.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',42,['src':("betaTables/bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',43,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',44,['src':("beta-version/css/font-awesome.min.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',46,['src':("beta-version/css/AdminLTE.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',47,['src':("beta-version/css/custom.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',48,['src':("beta-version/css/all-skins.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',52,['src':("beta-version/css/jquery.datetimepicker.min.css")],-1)
printHtmlPart(10)
invokeTag('javascript','asset',54,['src':("/beta-version/js/jquery.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','asset',59,['src':("/beta-version/js/sample.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',61,['src':("/beta-version/js/adminlte.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',63,['src':("/beta-version/js/bootstrap.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',64,['src':("/beta-version/js/custom.js")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',65,['src':("/beta-version/config.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',66,['src':("/beta-version/build-config.js")],-1)
printHtmlPart(11)
invokeTag('javascript','asset',67,['src':("/ckeditor/ckeditor.js")],-1)
printHtmlPart(11)
invokeTag('javascript','asset',67,['src':("dashboard.js")],-1)
printHtmlPart(12)
invokeTag('layoutHead','g',69,[:],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',69,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(13)
invokeTag('render','g',74,['template':("/layouts/dashboardHeader")],-1)
printHtmlPart(14)
invokeTag('javascript','asset',81,['src':("beta-version/js/calander/jquery.datetimepicker.js")],-1)
printHtmlPart(15)
invokeTag('layoutBody','g',81,[:],-1)
printHtmlPart(16)
invokeTag('render','g',82,['template':("/layouts/footer")],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',82,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668157173223L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
