import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationsentLetterDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/sentLetterDetails.gsp" }
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
if(true && (appLetter)) {
printHtmlPart(7)
loop:{
int j = 0
for( commDaitls in (appLetter) ) {
printHtmlPart(8)
expressionOut.print(j+1)
printHtmlPart(9)
expressionOut.print(commDaitls.applicantName)
printHtmlPart(9)
expressionOut.print(commDaitls?.formType)
printHtmlPart(9)
expressionOut.print(commDaitls?.appNumber)
printHtmlPart(10)
expressionOut.print(commDaitls?.subject?:'NA')
printHtmlPart(9)
expressionOut.print(commDaitls?.sendBy)
printHtmlPart(11)
invokeTag('formatDate','g',60,['format':("dd-MM-yyyy"),'date':(commDaitls?.createdDate)],-1)
printHtmlPart(12)
expressionOut.print(commDaitls?.dynamicLetterNumberNbaOUT)
printHtmlPart(12)
invokeTag('formatDate','g',63,['format':("dd-MM-yyyy"),'date':(commDaitls?.approvedDate)],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('remoteLink','g',70,['action':("viewLetterDetails"),'controller':("LetterCommunication"),'title':("Check letter Details"),'params':([editId:commDaitls?.id,csrfPreventionSalt:csrfPreventionSalt]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],4)
printHtmlPart(15)
j++
}
}
printHtmlPart(7)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('render','g',80,['template':("/rightPane/matchdata")],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648205460567L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
