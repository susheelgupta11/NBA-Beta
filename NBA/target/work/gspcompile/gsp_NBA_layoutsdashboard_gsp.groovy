import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsdashboard_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/dashboard.gsp" }
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
invokeTag('captureMeta','sitemesh',37,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',38,['src':("googlefont.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',40,['src':("morquee.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',42,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',43,['src':("beta-version/css/responsive.bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',44,['src':("beta-version/css/font-awesome.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',45,['src':("beta-version/css/AdminLTE.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',46,['src':("beta-version/css/custom.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',47,['src':("beta-version/css/all-skins.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',48,['src':("beta-version/css/dataTables.bootstrap.min.css")],-1)
printHtmlPart(8)
invokeTag('javascript','asset',55,['src':("dashboard.js")],-1)
printHtmlPart(7)
invokeTag('layoutHead','g',55,[:],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',59,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(10)
invokeTag('render','g',66,['template':("/layouts/indexHeader")],-1)
printHtmlPart(11)
invokeTag('javascript','asset',76,['src':("beta-version/js/datatable/jquery.min.js")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',79,['src':("beta-version/js/datatable/bootstrap.min.js")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',82,['src':("beta-version/js/datatable/jquery.dataTables.min.js")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',84,['src':("beta-version/js/datatable/dataTables.bootstrap.min.")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',86,['src':("beta-version/js/datatable/dataTables.responsive.min.js")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',106,['controller':("dashboard"),'action':("dashboard"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',115,['controller':("graphicalReport"),'action':("cristalView"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',122,['controller':("graphicalReport"),'action':("individualCristalView"),'params':([instance:formID,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('formRemote','g',144,['name':("unfileStatus"),'url':([controller: 'dashboard', action:'fileStatus']),'update':("stsUp")],2)
printHtmlPart(21)
invokeTag('layoutBody','g',168,[:],-1)
printHtmlPart(22)
invokeTag('render','g',172,['template':("/layouts/footer")],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',172,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668157207230L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
