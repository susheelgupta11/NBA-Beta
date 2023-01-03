import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_agendaagendaDraft_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/agenda/agendaDraft.gsp" }
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
if(true && (agendaInstance)) {
printHtmlPart(4)
loop:{
int i = 0
for( agdDaitls in (agendaInstance) ) {
printHtmlPart(5)
expressionOut.print(i+1)
printHtmlPart(6)
expressionOut.print(agdDaitls?.name)
printHtmlPart(6)
expressionOut.print(agdDaitls?.formType)
printHtmlPart(6)
expressionOut.print(agdDaitls?.appNumber)
printHtmlPart(7)
expressionOut.print(agdDaitls?.createdBy)
printHtmlPart(8)
invokeTag('formatDate','g',42,['format':("dd-MM-yyyy"),'date':(agdDaitls?.createDate)],-1)
printHtmlPart(9)
createClosureForHtmlPart(10, 4)
invokeTag('link','g',43,['action':("editAgenda"),'params':([editId:agdDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,status:'draft'])],4)
printHtmlPart(11)
i++
}
}
printHtmlPart(4)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('render','g',52,['template':("/rightPane/matchdata")],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',55,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648625111949L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
