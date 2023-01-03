import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_dashboardnoting_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/noting.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',22,['action':("dashboard"),'class':("add_button add-note")],2)
printHtmlPart(6)
if(true && (messageNote == null || messageNote == "")) {
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',26,['action':("addNote"),'class':("add_button add-note"),'title':("Add field"),'params':([instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
}
printHtmlPart(9)
if(true && (messageNote)) {
printHtmlPart(10)
expressionOut.print(messageNote)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (viewNoteDetails)) {
printHtmlPart(13)
loop:{
int i = 0
for( noteDetail in (viewNoteDetails) ) {
printHtmlPart(14)
expressionOut.print(noteDetail?.notedUser)
printHtmlPart(15)
expressionOut.print(noteDetail?.comments?.toString()?.replaceAll("\\<.*?>","")?.replace("&nbsp;", " "))
printHtmlPart(16)
invokeTag('formatDate','g',52,['format':("dd/MM/yyyy hh:mm aa"),'date':(noteDetail?.noteDate)],-1)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('render','g',61,['template':("/rightPane/matchdata")],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620571137498L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
