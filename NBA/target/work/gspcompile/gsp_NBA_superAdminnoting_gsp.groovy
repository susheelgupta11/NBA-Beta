import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_superAdminnoting_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/superAdmin/noting.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("nbaDashboardLayout")],-1)
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
invokeTag('link','g',14,['action':("addNote"),'class':("add_button add-note"),'title':("Add field"),'params':([instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
loop:{
int i = 0
for( noteDetail in (viewNoteDetails) ) {
printHtmlPart(9)
expressionOut.print(noteDetail?.notedUser)
printHtmlPart(10)
invokeTag('formatDate','g',42,['format':("dd-MM-yyyy"),'date':(noteDetail?.noteDate)],-1)
printHtmlPart(11)
expressionOut.print(noteDetail?.comments?.toString().replaceAll("\\<.*?>",""))
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
invokeTag('paginate','g',57,['total':(commentCount ?:0),'params':([instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt])],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',60,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1554446674000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
