import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunication_eReceiptPdfForMail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/_eReceiptPdfForMail.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('captureHead','sitemesh',52,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(tr5ReceiptInstance?.applicantName)
printHtmlPart(4)
expressionOut.print(tr5ReceiptInstance?.receiptNo)
printHtmlPart(5)
invokeTag('formatDate','g',116,['format':("dd/MM/yyyy"),'date':(tr5ReceiptInstance?.createdDate)],-1)
printHtmlPart(6)
expressionOut.print(tr5ReceiptInstance?.appNumber)
printHtmlPart(7)
expressionOut.print(tr5ReceiptInstance?.moneyInWords)
printHtmlPart(8)
expressionOut.print(tr5ReceiptInstance?.applicantName)
printHtmlPart(9)
expressionOut.print(tr5ReceiptInstance?.letterNo)
printHtmlPart(10)
invokeTag('formatDate','g',144,['format':("dd/MM/yyyy"),'date':(tr5ReceiptInstance?.createdDate)],-1)
printHtmlPart(11)
expressionOut.print(tr5ReceiptInstance?.appNumber)
printHtmlPart(12)
expressionOut.print(tr5ReceiptInstance?.sumOfRupees)
printHtmlPart(13)
expressionOut.print(tr5ReceiptInstance?.paymentType)
printHtmlPart(14)
expressionOut.print(tr5ReceiptInstance?.accountOF + 'INR')
printHtmlPart(15)
expressionOut.print(tr5ReceiptInstance?.paymentOf)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',256,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616507656L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
