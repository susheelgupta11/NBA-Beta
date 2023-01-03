import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationeReceiptForMail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/eReceiptForMail.gsp" }
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
invokeTag('captureHead','sitemesh',138,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(tr5ReceiptInstance?.emailId)
printHtmlPart(6)
expressionOut.print(tr5ReceiptInstance?.ccEmailId)
printHtmlPart(7)
expressionOut.print(tr5ReceiptInstance?.subject)
printHtmlPart(8)
expressionOut.print(tr5ReceiptInstance?.receiptNo)
printHtmlPart(9)
invokeTag('formatDate','g',163,['format':("dd/MM/yyyy"),'date':(tr5ReceiptInstance?.createdDate)],-1)
printHtmlPart(10)
expressionOut.print(tr5ReceiptInstance?.applicantName)
printHtmlPart(11)
expressionOut.print(tr5ReceiptInstance?.appNumber)
printHtmlPart(12)
expressionOut.print(tr5ReceiptInstance?.letterNo)
printHtmlPart(13)
expressionOut.print(tr5ReceiptInstance?.dated)
printHtmlPart(14)
expressionOut.print(tr5ReceiptInstance?.sumOfRupees)
printHtmlPart(15)
expressionOut.print(tr5ReceiptInstance?.moneyInWords)
printHtmlPart(16)
expressionOut.print(tr5ReceiptInstance?.paymentFor)
printHtmlPart(17)
expressionOut.print(tr5ReceiptInstance?.paymentType)
printHtmlPart(18)
expressionOut.print(tr5ReceiptInstance?.paymentOf)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',198,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616047864L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
