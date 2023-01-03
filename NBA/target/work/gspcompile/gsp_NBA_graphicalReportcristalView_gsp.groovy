import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_graphicalReportcristalView_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/graphicalReport/cristalView.gsp" }
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
createClosureForHtmlPart(6, 2)
invokeTag('link','g',50,['controller':("graphicalReport"),'action':("formwiseDetails"),'params':([appType:'total'])],2)
printHtmlPart(7)
expressionOut.print(inprocess)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',63,['controller':("graphicalReport"),'action':("formwiseDetails"),'params':([appType:'inprocess'])],2)
printHtmlPart(10)
expressionOut.print(approved)
printHtmlPart(8)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',76,['controller':("graphicalReport"),'action':("formwiseDetails"),'params':([appType:'approved'])],2)
printHtmlPart(12)
expressionOut.print(reject)
printHtmlPart(8)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',89,['controller':("graphicalReport"),'action':("formwiseDetails"),'params':([appType:'reject'])],2)
printHtmlPart(14)
expressionOut.print(inprocess)
printHtmlPart(15)
expressionOut.print(ip)
printHtmlPart(16)
expressionOut.print(approved)
printHtmlPart(17)
expressionOut.print(ap)
printHtmlPart(16)
expressionOut.print(reject)
printHtmlPart(18)
expressionOut.print(rp)
printHtmlPart(19)
expressionOut.print(first.get(0))
printHtmlPart(20)
expressionOut.print(second.get(0))
printHtmlPart(21)
expressionOut.print(third.get(0))
printHtmlPart(22)
expressionOut.print(four.get(0))
printHtmlPart(23)
expressionOut.print(five.get(0))
printHtmlPart(24)
expressionOut.print(six.get(0))
printHtmlPart(25)
expressionOut.print(seven.get(0))
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',175,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1666860447884L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
