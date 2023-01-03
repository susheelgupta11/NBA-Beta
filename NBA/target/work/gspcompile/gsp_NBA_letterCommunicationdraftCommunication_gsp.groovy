import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationdraftCommunication_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/draftCommunication.gsp" }
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
printHtmlPart(1)
if(true && (message)) {
printHtmlPart(3)
expressionOut.print(message)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (draftItem)) {
printHtmlPart(6)
loop:{
int i = 0
for( commDaitls in (draftItem) ) {
printHtmlPart(7)
expressionOut.print(i+1)
printHtmlPart(8)
expressionOut.print(commDaitls.applicantName)
printHtmlPart(8)
expressionOut.print(commDaitls?.formType)
printHtmlPart(8)
expressionOut.print(commDaitls?.appNumber)
printHtmlPart(9)
expressionOut.print(commDaitls?.subject?:'NA')
printHtmlPart(8)
expressionOut.print(commDaitls?.createdBy)
printHtmlPart(10)
invokeTag('formatDate','g',52,['format':("dd-MM-yyyy"),'date':(commDaitls?.createdDate)],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('link','g',53,['action':("editCommunication"),'params':([editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,status: false])],4)
printHtmlPart(13)
i++
}
}
printHtmlPart(6)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('render','g',62,['template':("/rightPane/matchdata")],-1)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648132850893L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
