import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_fileMovmentsfileMovment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fileMovments/fileMovment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(9)
invokeTag('set','g',53,['var':("counter"),'value':(1)],-1)
printHtmlPart(10)
loop:{
int i = 0
for( applicationListInstance in (applicationList) ) {
printHtmlPart(11)
expressionOut.print(applicationListInstance?.forwardMember)
printHtmlPart(12)
expressionOut.print(applicationListInstance?.actions)
printHtmlPart(13)
expressionOut.print(applicationListInstance?.statusUpdate)
printHtmlPart(14)
invokeTag('formatDate','g',71,['format':("dd/MM/yyyy hh:mm aa"),'date':(applicationListInstance?.noteDate)],-1)
printHtmlPart(15)
if(true && (counter == 1)) {
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('set','g',77,['var':("counter"),'value':(counter + 1)],-1)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1650435493406L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
