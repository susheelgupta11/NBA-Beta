
import org.nba.application.ApplicationForm1


import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsappltDash_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/appltDash.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)

response.setHeader("Cache-Control","private");
response.setHeader("Cache-Control","no-store");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1);

printHtmlPart(0)

response.setHeader("Cache-control","no-store"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP1.0 
response.setDateHeader("Expire",0); //prevents caching at the proxy server

printHtmlPart(0)
invokeTag('captureMeta','sitemesh',27,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',28,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(0)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',30,['default':("National Biodiversity Application")],-1)
})
invokeTag('captureTitle','sitemesh',30,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',30,[:],2)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',31,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',44,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',46,['src':("googlefont.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',48,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',49,['src':("beta-version/css/responsive.bootstrap.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',50,['src':("beta-version/css/font-awesome.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',51,['src':("beta-version/css/AdminLTE.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',52,['src':("beta-version/css/custom.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',53,['src':("beta-version/css/all-skins.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',54,['src':("beta-version/css/dataTables.bootstrap.min.css")],-1)
printHtmlPart(8)
invokeTag('javascript','asset',57,['src':("beta-version/js/jquery.min.js")],-1)
printHtmlPart(8)
invokeTag('layoutHead','g',60,[:],-1)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',61,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('render','g',65,['template':("/layouts/adminHeader")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',74,['action':("applicantDash"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',75,['controller':("loggedInAs"),'action':("decideForm")],2)
printHtmlPart(14)
invokeTag('layoutBody','g',79,[:],-1)
printHtmlPart(15)
invokeTag('javascript','asset',80,['src':("beta-version/js/datatable/jquery.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',81,['src':("beta-version/js/datatable/bootstrap.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',82,['src':("beta-version/js/datatable/jquery.dataTables.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',83,['src':("beta-version/js/datatable/dataTables.bootstrap.min.")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',84,['src':("beta-version/js/datatable/dataTables.responsive.min.js")],-1)
printHtmlPart(17)
invokeTag('render','g',103,['template':("/layouts/footer")],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',104,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668157255152L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
