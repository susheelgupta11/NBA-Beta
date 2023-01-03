import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicantsendClientLetter_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/sendClientLetter.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("applicant")],-1)
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
if(true && (clientLetter)) {
printHtmlPart(7)
loop:{
int i = 0
for( commDaitls in (clientLetter) ) {
printHtmlPart(8)
expressionOut.print(i+1)
printHtmlPart(9)
expressionOut.print(commDaitls?.applicationForm?.category?.category)
printHtmlPart(10)
expressionOut.print(commDaitls?.applicationForm?.appNumber)
printHtmlPart(11)
expressionOut.print(commDaitls?.subject)
printHtmlPart(12)
expressionOut.print(commDaitls?.dynamicLetterNumberClientOUT)
printHtmlPart(10)
invokeTag('formatDate','g',50,['format':("dd/MM/yyyy"),'date':(commDaitls?.letterCreateDate)],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('remoteLink','g',61,['action':("viewCommunication"),'controller':("letterCommunication"),'title':("Letter Details"),'params':([editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],4)
printHtmlPart(15)
i++
}
}
printHtmlPart(7)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649164783472L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
