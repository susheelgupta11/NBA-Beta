import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_superAdmintr5ReceiptIssue_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/superAdmin/tr5ReceiptIssue.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
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
loop:{
int i = 0
for( commDaitls in (tr5IssueList) ) {
printHtmlPart(4)
expressionOut.print(i+1)
printHtmlPart(5)
expressionOut.print(commDaitls?.applicantName)
printHtmlPart(5)
expressionOut.print(commDaitls?.formType)
printHtmlPart(5)
expressionOut.print(commDaitls?.appNumber)
printHtmlPart(5)
expressionOut.print(commDaitls?.subject)
printHtmlPart(5)
expressionOut.print(commDaitls?.sendBy)
printHtmlPart(6)
invokeTag('formatDate','g',47,['format':("dd/MM/yyyy"),'date':(commDaitls?.sendDate)],-1)
printHtmlPart(7)
expressionOut.print(commDaitls?.tr5DynamicNumber)
printHtmlPart(7)
invokeTag('formatDate','g',49,['format':("dd/MM/yyyy"),'date':(commDaitls?.sendDate)],-1)
printHtmlPart(8)
i++
}
}
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1554448948000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
