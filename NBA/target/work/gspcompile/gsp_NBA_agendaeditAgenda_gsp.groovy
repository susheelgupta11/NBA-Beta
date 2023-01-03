import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_agendaeditAgenda_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/agenda/editAgenda.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
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
invokeTag('render','g',29,['template':("/agenda/formAgenda")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',31,['name':("agendaInstane"),'value':(agendaInstance?.id)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',32,['name':("instance"),'value':(formDetails?.id)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',33,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',34,['name':("sts"),'value':(status)],-1)
printHtmlPart(9)
if(true && (status == 'draft')) {
printHtmlPart(10)
invokeTag('actionSubmit','g',37,['value':("Send for Approval"),'action':("sendForApproval"),'class':("btn btn-primary pull-right"),'style':("margin:5px;")],-1)
printHtmlPart(10)
invokeTag('actionSubmit','g',38,['value':("Update Agenda"),'action':("updateAgenda"),'class':("btn btn-primary pull-right"),'style':("margin:5px;")],-1)
printHtmlPart(10)
}
else if(true && (status == 'approve')) {
printHtmlPart(10)
invokeTag('actionSubmit','g',41,['value':("Approved"),'action':("sendAgendaEC"),'class':("btn btn-primary pull-right"),'style':("margin:5px;")],-1)
printHtmlPart(10)
invokeTag('actionSubmit','g',42,['value':("Review and Re-submit"),'action':("updateAgenda"),'class':("btn btn-primary pull-right"),'style':("margin:5px;")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
})
invokeTag('form','g',43,['enctype':("multipart/form-data"),'controller':("agenda"),'action':("updateAgenda"),'method':("POST")],2)
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
public static final long LAST_MODIFIED = 1649068583773L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
