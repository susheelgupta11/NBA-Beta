import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_setMstrDataindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/setMstrData/index.gsp" }
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
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('modalIncludes','modalbox',13,[:],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('createLink','modalbox',18,['action':("create"),'params':([type:'draft']),'title':("Add Draft Value!"),'width':("600")],2)
printHtmlPart(7)
loop:{
int i = 0
for( setMstrData in (setMstrDataInstance) ) {
printHtmlPart(8)
loop:{
int j = 0
for( dftVal in (setMstrData?.draft) ) {
printHtmlPart(9)
expressionOut.print(j+1)
printHtmlPart(10)
expressionOut.print(dftVal)
printHtmlPart(11)
invokeTag('modalIncludes','modalbox',40,[:],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('createLink','modalbox',43,['action':("edit"),'params':([type:'draft',index:j]),'title':("Update Draft Value!"),'width':("600")],4)
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('link','g',46,['action':("delete"),'params':([type:'draft',index:j,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(16)
j++
}
}
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',60,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1586269700000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
