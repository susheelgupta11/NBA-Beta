import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_SBBnoting_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/SBB/noting.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("sbb")],-1)
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
createClosureForHtmlPart(4, 2)
invokeTag('link','g',17,['action':("sbbDashboard"),'class':("add_button add-note")],2)
printHtmlPart(5)
if(true && (message == null || message == "")) {
printHtmlPart(6)
createClosureForHtmlPart(7, 3)
invokeTag('link','g',20,['action':("addComment"),'class':("add_button add-note"),'title':("Add field"),'params':([instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
}
printHtmlPart(8)
if(true && (message)) {
printHtmlPart(9)
expressionOut.print(message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (viewNoteDetails)) {
printHtmlPart(12)
loop:{
int i = 0
for( noteDetail in (viewNoteDetails) ) {
printHtmlPart(13)
expressionOut.print(noteDetail?.notedUser)
printHtmlPart(14)
invokeTag('formatDate','g',49,['format':("dd/MM/yyyy hh:mm aa"),'date':(noteDetail?.noteDate)],-1)
printHtmlPart(15)
expressionOut.print(noteDetail?.comments?.toString().replaceAll("\\<.*?>",""))
printHtmlPart(16)
i++
}
}
printHtmlPart(12)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('paginate','g',66,['total':(commentCount ?:0),'params':([instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt])],-1)
printHtmlPart(19)
invokeTag('render','g',68,['template':("rightPannel")],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',113,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1581417168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
