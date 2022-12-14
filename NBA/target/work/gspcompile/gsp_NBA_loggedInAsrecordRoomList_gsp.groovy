import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAsrecordRoomList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/recordRoomList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',5,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
loop:{
int i = 0
for( applicationDetail in (recordRoomApplication) ) {
printHtmlPart(5)
expressionOut.print(i+1)
printHtmlPart(6)
expressionOut.print(applicationDetail?.appNumber)
printHtmlPart(6)
expressionOut.print(applicationDetail?.currentStatus?.changedBy?.name)
printHtmlPart(7)
invokeTag('formatDate','g',37,['format':("dd/MM/yyyy"),'date':(applicationDetail?.currentStatus?.forwardedDate)],-1)
printHtmlPart(8)
if(true && (applicationDetail?.currentStatus?.statusUpdate)) {
printHtmlPart(9)
expressionOut.print(applicationDetail?.currentStatus?.statusUpdate)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(applicationDetail?.submittedOn)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620327331416L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
