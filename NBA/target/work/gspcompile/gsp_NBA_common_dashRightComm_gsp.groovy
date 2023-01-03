import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_common_dashRightComm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/common/_dashRightComm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (virtualApplications)) {
printHtmlPart(1)
loop:{
int i = 0
for( virtual in (virtualApplications) ) {
printHtmlPart(2)
expressionOut.print(i+1)
printHtmlPart(3)
expressionOut.print(virtual?.appNumber)
printHtmlPart(3)
expressionOut.print(virtual?.currentStatus?.status)
printHtmlPart(3)
expressionOut.print(virtual?.currentStatus?.reasonForRecordRoom)
printHtmlPart(3)
expressionOut.print(virtual?.currentStatus?.changedBy?.name)
printHtmlPart(4)
createClosureForHtmlPart(5, 3)
invokeTag('link','g',64,['controller':("dashboard"),'action':("movetoInbox"),'onclick':("return confirmation('Are you sure')"),'params':([instance:virtual?.id])],3)
printHtmlPart(6)
i++
}
}
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620150223271L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
