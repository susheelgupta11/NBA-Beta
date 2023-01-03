import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_manualUpload_manualDynamicPdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/manualUpload/_manualDynamicPdf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(manualDataDetails?.classified)
printHtmlPart(5)
expressionOut.print(manualDataDetails?.language)
printHtmlPart(6)
expressionOut.print(manualDataDetails?.letterDate)
printHtmlPart(7)
expressionOut.print(manualDataDetails?.letterDate)
printHtmlPart(8)
expressionOut.print(manualDataDetails?.mobileNumber)
printHtmlPart(9)
expressionOut.print(manualDataDetails?.fileNumber)
printHtmlPart(10)
expressionOut.print(manualDataDetails?.deliveryMode)
printHtmlPart(11)
expressionOut.print(manualDataDetails?.letterReferenceNumber)
printHtmlPart(12)
expressionOut.print(manualDataDetails?.name)
printHtmlPart(13)
expressionOut.print(manualDataDetails?.designation)
printHtmlPart(14)
expressionOut.print(manualDataDetails?.address1)
printHtmlPart(15)
expressionOut.print(manualDataDetails?.address2)
printHtmlPart(16)
expressionOut.print(manualDataDetails?.country)
printHtmlPart(17)
expressionOut.print(manualDataDetails?.state)
printHtmlPart(18)
expressionOut.print(manualDataDetails?.city)
printHtmlPart(19)
expressionOut.print(manualDataDetails?.pin)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1617696236313L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
