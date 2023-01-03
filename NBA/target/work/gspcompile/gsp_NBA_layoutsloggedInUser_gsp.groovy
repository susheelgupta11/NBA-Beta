import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsloggedInUser_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/loggedInUser.gsp" }
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
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',24,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',26,['default':("National Biodiversity Application")],-1)
})
invokeTag('captureTitle','sitemesh',26,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',26,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',27,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(6)
invokeTag('stylesheet','asset',37,['src':("bootstrap.min.css"),'media':("screen")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',38,['src':("custom.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',39,['src':("jquery.tooltip.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',40,['src':("errors.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',41,['src':("font-awesome.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',42,['src':("jquery-ui.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',43,['src':("print.css"),'media':("print")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',44,['src':("calender/kendo.dataviz.material.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',45,['src':("calender/kendo-material.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',46,['src':("calender/kendo-dataviz.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',47,['src':("calender/kendo-dataviz.material.min.css")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',50,['src':("jquery-vv.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',51,['src':("jquery-v.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',52,['src':("NBA.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',53,['src':("blockUI.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',54,['src':("jquery-ui.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',55,['src':("bootstrap.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',56,['src':("jquery-datepick.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',57,['src':("responsive-calendar.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',58,['src':("MoES_Validations.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',59,['src':("responsive-calendar.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',60,['src':("calender/kendo-all.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',61,['src':("calender/kendo-all.min.js")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',64,['src':("jquery.PrintArea.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',65,['src':("jquerysession.js")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',68,['src':("Main.js"),'media':("screen")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',69,['src':("mybootstrap2.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',70,['src':("/ckeditor/jquery.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',71,['src':("/ckeditor/ckeditor.js")],-1)
printHtmlPart(8)
invokeTag('layoutHead','g',79,[:],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',80,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('render','g',84,['template':("/layouts/topmenu")],-1)
printHtmlPart(10)
invokeTag('render','g',85,['template':("/layouts/headerimage")],-1)
printHtmlPart(11)
invokeTag('render','g',87,['template':("/common/applicationTabs")],-1)
printHtmlPart(12)
invokeTag('layoutBody','g',93,[:],-1)
printHtmlPart(13)
invokeTag('render','g',97,['template':("/layouts/footer")],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',98,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537947338000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
