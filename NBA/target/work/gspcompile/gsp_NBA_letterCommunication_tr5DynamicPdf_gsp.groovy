import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunication_tr5DynamicPdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/_tr5DynamicPdf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',119,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(body?.emailId)
printHtmlPart(6)
expressionOut.print(body?.ccEmailId)
printHtmlPart(7)
expressionOut.print(body?.subject)
printHtmlPart(8)
expressionOut.print(body?.receiptNo)
printHtmlPart(9)
invokeTag('formatDate','g',139,['format':("dd/MM/yyyy"),'date':(body?.createdDate)],-1)
printHtmlPart(10)
expressionOut.print(body?.applicantName)
printHtmlPart(11)
expressionOut.print(body?.appNumber)
printHtmlPart(12)
expressionOut.print(body?.letterNo)
printHtmlPart(9)
expressionOut.print(body?.dated)
printHtmlPart(13)
expressionOut.print(body?.sumOfRupees)
printHtmlPart(14)
expressionOut.print(body?.moneyInWords)
printHtmlPart(15)
expressionOut.print(body?.paymentFor)
printHtmlPart(16)
expressionOut.print(body?.paymentType)
printHtmlPart(17)
expressionOut.print(body?.paymentOf)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',159,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1646731315708L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
