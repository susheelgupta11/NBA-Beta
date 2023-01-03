import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_setMstrDatakms_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/setMstrData/kms.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('modalIncludes','modalbox',12,[:],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('createLink','modalbox',16,['url':("addKMS.gsp"),'title':("Add KMS Details!"),'width':("600")],2)
printHtmlPart(7)
if(true && (message)) {
printHtmlPart(8)
expressionOut.print(message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('javascript','g',32,['library':("application")],-1)
printHtmlPart(11)
loop:{
int j = 0
for( kmsd in (kmsInstance) ) {
printHtmlPart(12)
expressionOut.print(j+1)
printHtmlPart(13)
expressionOut.print(kmsd?.title)
printHtmlPart(14)
expressionOut.print(kmsd?.fileName)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',42,['action':("showKMS"),'controller':("setMstrData"),'params':([editId:kmsd?.id])],3)
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',46,['action':("deleteKMS"),'params':([deleteId:kmsd?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(19)
j++
}
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',48,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1600341396000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
