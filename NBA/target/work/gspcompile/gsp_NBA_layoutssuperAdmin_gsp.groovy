import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutssuperAdmin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/superAdmin.gsp" }
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
invokeTag('captureMeta','sitemesh',38,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',41,['src':("morquee.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',44,['src':("beta-version/css/jquery.datetimepicker.min.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',46,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',47,['src':("beta-version/css/responsive.bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',48,['src':("beta-version/css/font-awesome.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',49,['src':("beta-version/css/AdminLTE.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',50,['src':("beta-version/css/custom.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',51,['src':("beta-version/css/all-skins.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',52,['src':("beta-version/css/dataTables.bootstrap.min.css")],-1)
printHtmlPart(10)
invokeTag('javascript','asset',57,['src':("beta-version/js/jquery.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',59,['src':("beta-version/js/sample.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',65,['src':("beta-version/js/adminlte.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',66,['src':("beta-version/js/bootstrap.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',67,['src':("/ckeditor/ckeditor.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',68,['src':("dashboard.js")],-1)
printHtmlPart(11)
invokeTag('stylesheet','asset',69,['src':("beta-version/css/jquery.datetimepicker.min.css")],-1)
printHtmlPart(12)
invokeTag('layoutHead','g',69,[:],-1)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',72,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(14)
invokeTag('render','g',81,['template':("/layouts/adminHeader")],-1)
printHtmlPart(15)
invokeTag('javascript','asset',82,['src':("beta-version/js/datatable/jquery.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',86,['src':("beta-version/js/datatable/bootstrap.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',89,['src':("beta-version/js/datatable/jquery.dataTables.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',90,['src':("beta-version/js/datatable/dataTables.bootstrap.min.")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',91,['src':("beta-version/js/datatable/dataTables.responsive.min.js")],-1)
printHtmlPart(17)
invokeTag('javascript','asset',92,['src':("exportTable/dataTables.buttons.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',93,['src':("exportTable/jszip.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',95,['src':("exportTable/pdfmake.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',97,['src':("exportTable/vfs_fonts.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',98,['src':("exportTable/buttons.html5.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',99,['src':("exportTable/buttons.print.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',100,['src':("exportTable/dataTables.fixedHeader.min.js")],-1)
printHtmlPart(18)
invokeTag('render','g',101,['template':("/layouts/adminLeftMenus")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',103,['src':("beta-version/js/calander/jquery.datetimepicker.js")],-1)
printHtmlPart(20)
invokeTag('layoutBody','g',104,[:],-1)
printHtmlPart(21)
invokeTag('render','g',183,['template':("/layouts/footer")],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',184,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668752460473L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
