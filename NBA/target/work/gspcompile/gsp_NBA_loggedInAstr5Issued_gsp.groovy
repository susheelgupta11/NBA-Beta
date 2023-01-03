import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAstr5Issued_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/tr5Issued.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('submitButton','g',27,['value':("Filter"),'name':("Filter")],-1)
printHtmlPart(6)
})
invokeTag('form','g',28,['action':("tr5DateFilter"),'controller':("loggedInAs"),'method':("POST")],2)
printHtmlPart(7)
if(true && (tr5ReceiptInstance)) {
printHtmlPart(8)
loop:{
int i = 0
for( commDaitls in (tr5ReceiptInstance) ) {
printHtmlPart(9)
expressionOut.print(i+1)
printHtmlPart(10)
expressionOut.print(commDaitls?.applicantName)
printHtmlPart(10)
expressionOut.print(commDaitls?.formType)
printHtmlPart(10)
expressionOut.print(commDaitls?.appNumber)
printHtmlPart(10)
expressionOut.print(commDaitls?.sumOfRupees)
printHtmlPart(11)
expressionOut.print(commDaitls?.receiptNo)
printHtmlPart(12)
invokeTag('formatDate','g',71,['format':("dd/MM/yyyy"),'date':(commDaitls?.createdDate)],-1)
printHtmlPart(13)
expressionOut.print(commDaitls?.sendBy)
printHtmlPart(14)
invokeTag('formatDate','g',76,['format':("dd/MM/yyyy"),'date':(commDaitls?.sendDate)],-1)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',108,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668753718295L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
