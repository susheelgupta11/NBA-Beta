import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_part5_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_part5.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(1)
}
else {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(4)
}
else {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(formDetails?.transaction?.transactionId)
printHtmlPart(7)
expressionOut.print(formDetails?.transaction?.paymentRefNo)
printHtmlPart(8)
if(true && (formDetails?.transaction?.fee >9000)) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
createClosureForHtmlPart(12, 1)
invokeTag('link','g',103,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(formDetails?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", formDetailsId: formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648141372803L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
