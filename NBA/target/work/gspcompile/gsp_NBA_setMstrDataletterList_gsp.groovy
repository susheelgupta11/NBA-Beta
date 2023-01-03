import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_setMstrDataletterList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/setMstrData/letterList.gsp" }
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
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',11,['controller':("setMstrData"),'action':("addLetter"),'class':("btn btn-primary pull-right"),'style':("margin-bottom: 5px;")],2)
printHtmlPart(6)
if(true && (message)) {
printHtmlPart(7)
expressionOut.print(message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (letterlist)) {
printHtmlPart(10)
loop:{
int i = 0
for( letterInstance in (letterlist) ) {
printHtmlPart(11)
expressionOut.print(i+1)
printHtmlPart(12)
expressionOut.print(letterInstance?.letterName)
printHtmlPart(12)
invokeTag('formatDate','g',31,['format':("dd-MM-yyyy"),'date':(letterInstance?.templateCreationDate)],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',34,['action':("editLetter"),'params':([idEdit:letterInstance?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',37,['action':("deleteLetter"),'params':([idDelete:letterInstance?.id,csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm('Are you sure to delete?');")],4)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',49,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1581935706000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
