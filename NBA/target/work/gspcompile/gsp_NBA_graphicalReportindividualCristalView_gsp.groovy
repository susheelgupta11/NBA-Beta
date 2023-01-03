import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_graphicalReportindividualCristalView_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/graphicalReport/individualCristalView.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('stylesheet','asset',8,['src':("cristal/bootstrap.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',9,['src':("cristal/style.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',10,['src':("cristal/morris.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',12,['src':("cristal/jquery2.0.3.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',13,['src':("cristal/modernizr.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',14,['src':("cristal/jquery.cookie.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',16,['src':("cristal/screenfull.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',17,['src':("cristal/skycons.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',18,['src':("cristal/raphael-min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',19,['src':("cristal/morris.js")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',21,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(total)
printHtmlPart(5)
expressionOut.print(ondesk)
printHtmlPart(6)
expressionOut.print(processed)
printHtmlPart(7)
expressionOut.print(recordRoom)
printHtmlPart(8)
invokeTag('render','g',97,['template':("individualTable")],-1)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1641988813772L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
