import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_expertCommittee_recommendation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/expertCommittee/_recommendation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',3,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',3,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(agendaInstance?.whetherTraditional)
printHtmlPart(5)
expressionOut.print(agendaInstance?.screeningBiores)
printHtmlPart(6)
expressionOut.print(agendaInstance?.rareEndemic)
printHtmlPart(7)
expressionOut.print(agendaInstance?.wildlifeAct)
printHtmlPart(8)
expressionOut.print(agendaInstance?.restricted)
printHtmlPart(9)
expressionOut.print(agendaInstance?.originalFile)
printHtmlPart(10)
expressionOut.print(agendaInstance?.proposal)
printHtmlPart(11)
expressionOut.print(agendaInstance?.anyOther)
printHtmlPart(12)
expressionOut.print(agendaInstance?.expertView)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648698240929L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
