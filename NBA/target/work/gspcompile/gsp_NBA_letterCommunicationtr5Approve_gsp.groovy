import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationtr5Approve_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/tr5Approve.gsp" }
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
if(true && (approveItem)) {
printHtmlPart(4)
loop:{
int i = 0
for( commDaitls in (approveItem) ) {
printHtmlPart(5)
expressionOut.print(i+1)
printHtmlPart(6)
expressionOut.print(commDaitls?.applicantName)
printHtmlPart(6)
expressionOut.print(commDaitls?.formType)
printHtmlPart(6)
expressionOut.print(commDaitls?.appNumber)
printHtmlPart(6)
expressionOut.print(commDaitls?.subject)
printHtmlPart(6)
expressionOut.print(commDaitls?.approvedBy)
printHtmlPart(7)
invokeTag('formatDate','g',48,['format':("dd/MM/yyyy"),'date':(commDaitls?.createdDate)],-1)
printHtmlPart(8)
invokeTag('formatDate','g',49,['format':("dd/MM/yyyy"),'date':(commDaitls?.approvedDate)],-1)
printHtmlPart(9)
createClosureForHtmlPart(10, 4)
invokeTag('link','g',51,['action':("tr5LetterEdit"),'controller':("letterCommunication"),'params':([dftIns:commDaitls?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,status:true])],4)
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
invokeTag('render','g',56,['template':("/rightPane/matchdata")],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648140770796L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
