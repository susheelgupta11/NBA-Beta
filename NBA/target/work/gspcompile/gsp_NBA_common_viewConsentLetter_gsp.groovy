import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_common_viewConsentLetter_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/common/_viewConsentLetter.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (sbbInstance?.other)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(sbbInstance?.sbbName)
printHtmlPart(7)
expressionOut.print(sbbInstance?.appNumber)
printHtmlPart(8)
expressionOut.print(sbbInstance?.dynLetterNumber)
printHtmlPart(9)
invokeTag('formatDate','g',40,['format':("dd/MM/yyyy"),'date':(sbbInstance?.letterCreatedDate)],-1)
printHtmlPart(10)
expressionOut.print(sbbInstance?.consentCreatedDate)
printHtmlPart(11)
if(true && (sbbInstance?.localBody)) {
printHtmlPart(1)
for( local in (sbbInstance?.localBody) ) {
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
expressionOut.print(sbbName?:sbbInstance?.sbbName)
printHtmlPart(17)
expressionOut.print(sbbInstance?.ddn)
printHtmlPart(18)
createTagBody(2, {->
expressionOut.print(sbbInstance?.fileName)
})
invokeTag('link','g',107,['controller':("SBB"),'action':("fileDetails"),'target':("_blank"),'params':([sbbInst:sbbInstance?.id,csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1588706032000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
