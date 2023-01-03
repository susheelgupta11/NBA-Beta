import org.nba.communication.AgendaLetterStatus
import org.nba.communication.Agenda
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_expertCommitteeexpertDash_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/expertCommittee/expertDash.gsp" }
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
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("expertMember")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (message)) {
printHtmlPart(5)
expressionOut.print(message)
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(type)
printHtmlPart(8)
expressionOut.print(agendaDetails?.size()?:0)
printHtmlPart(9)
loop:{
int i = 0
for( ec in (agendaDetails) ) {
printHtmlPart(10)
expressionOut.print(i+1)
printHtmlPart(11)
expressionOut.print(ec?.agendaCounter)
printHtmlPart(11)
invokeTag('formatDate','g',69,['format':("dd/MM/yyyy"),'date':(ec?.meetingDate)],-1)
printHtmlPart(12)
expressionOut.print(ec?.agendasentCounter?:0)
printHtmlPart(13)
if(true && (ec?.agendasentCounter)) {
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',77,['action':("agendaSendDetails"),'controller':("expertCommittee"),'params':([detId:ec?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',78,['action':("agendaDownloadAll"),'controller':("expertCommittee"),'params':([dwnId:ec?.id,csrfPreventionSalt:csrfPreventionSalt]),'target':("_blank")],4)
printHtmlPart(13)
}
printHtmlPart(17)
expressionOut.print(ec?.recoCounter?:0)
printHtmlPart(13)
if(true && (ec?.recoCounter)) {
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',85,['action':("agendaSendDetails"),'controller':("expertCommittee"),'params':([detId:ec?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',86,['action':("recommDwnloadAll"),'controller':("expertCommittee"),'params':([dwnId:ec?.id,csrfPreventionSalt:csrfPreventionSalt]),'target':("_blank")],4)
printHtmlPart(13)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648698746121L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
