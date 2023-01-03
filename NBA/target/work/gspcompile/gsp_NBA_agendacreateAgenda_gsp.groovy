
import org.nba.application.FormCategory


import org.nba.application.ApplicationForm1

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_agendacreateAgenda_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/agenda/createAgenda.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
if(true && (message)) {
printHtmlPart(4)
expressionOut.print(message)
printHtmlPart(5)
}
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(8)
invokeTag('render','g',33,['template':("/agenda/formAgenda")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',35,['name':("instance"),'value':(formDetails?.id)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',36,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',37,['name':("flag"),'value':("1")],-1)
printHtmlPart(10)
if(true && (agendaInstance == null || agendaInstance == '')) {
printHtmlPart(10)
invokeTag('submitButton','g',39,['name':("Save as Draft"),'class':("btn btn-primary pull-right"),'style':("margin: 7px;")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
})
invokeTag('form','g',40,['controller':("Agenda"),'action':("saveAgenda"),'method':("post")],2)
printHtmlPart(12)
invokeTag('render','g',49,['template':("/rightPane/matchdata")],-1)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648430240437L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
