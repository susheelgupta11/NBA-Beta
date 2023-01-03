import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_SBBsbbConsentPrint_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/SBB/sbbConsentPrint.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(1)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',6,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
if(true && (printInstance?.other)) {
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(sbbName?:printInstance?.sbbName)
printHtmlPart(6)
expressionOut.print(formDetails?.appNumber?:printInstance?.appNumber)
printHtmlPart(7)
expressionOut.print(printInstance?.dynLetterNumber)
printHtmlPart(8)
invokeTag('formatDate','g',54,['format':("dd/MM/yyyy"),'date':(printInstance?.letterCreatedDate)],-1)
printHtmlPart(9)
invokeTag('formatDate','g',64,['name':("consentCreateDate"),'format':("dd/MM/yyyy"),'date':(new Date())],-1)
printHtmlPart(10)
if(true && (printInstance?.localBody)) {
printHtmlPart(11)
for( local in (printInstance?.localBody) ) {
printHtmlPart(12)
expressionOut.print(local)
printHtmlPart(13)
}
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(sbbName?:printInstance?.sbbName)
printHtmlPart(17)
expressionOut.print(printInstance?.ddn)
printHtmlPart(18)
expressionOut.print(printInstance?.other?:'')
printHtmlPart(19)
if(true && (printInstance)) {
printHtmlPart(20)
expressionOut.print(printInstance?.fileName)
}
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1634137007686L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
