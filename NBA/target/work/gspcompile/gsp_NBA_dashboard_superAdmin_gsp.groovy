import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_dashboard_superAdmin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_superAdmin.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(recordRoomApplication?.size()?:0)
printHtmlPart(1)
loop:{
int i = 0
for( applicationDetail in (recordRoomApplication) ) {
printHtmlPart(2)
expressionOut.print(i+1)
printHtmlPart(3)
expressionOut.print(applicationDetail?.appNumber)
printHtmlPart(3)
expressionOut.print(applicationDetail?.currentStatus?.changedBy?.name)
printHtmlPart(4)
invokeTag('formatDate','g',45,['format':("dd/MM/yyyy"),'date':(applicationDetail?.currentStatus?.forwardedDate)],-1)
printHtmlPart(5)
if(true && (applicationDetail?.currentStatus?.statusUpdate)) {
printHtmlPart(6)
expressionOut.print(applicationDetail?.currentStatus?.statusUpdate)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(applicationDetail?.submittedOn)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',60,['action':("addNote"),'controller':("dashboard"),'params':([instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]),'title':("Assign to another user")],2)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
expressionOut.print(approvedApplications?.size()?:0)
printHtmlPart(14)
if(true && (approvedApplications?.size())) {
printHtmlPart(15)
loop:{
int i = 0
for( applicationDetail in (approvedApplications) ) {
printHtmlPart(16)
expressionOut.print(i+1)
printHtmlPart(3)
expressionOut.print(applicationDetail?.category?.category)
printHtmlPart(17)
invokeTag('formatDate','g',104,['format':("dd/MM/yyyy"),'date':(applicationDetail?.currentStatus?.forwardedDate)],-1)
printHtmlPart(18)
expressionOut.print(currentUser)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(rejectedApplications?.size()?:0)
printHtmlPart(22)
if(true && (rejectedApplications?.size())) {
printHtmlPart(15)
loop:{
int l = 0
for( applicationDetail in (rejectedApplications) ) {
printHtmlPart(16)
expressionOut.print(l+1)
printHtmlPart(3)
expressionOut.print(applicationDetail?.appNumber)
printHtmlPart(4)
invokeTag('formatDate','g',158,['format':("dd/MM/yyyy"),'date':(applicationDetail?.currentStatus?.forwardedDate)],-1)
printHtmlPart(9)
expressionOut.print(applicationDetail?.currentStatus?.statusUpdate)
printHtmlPart(23)
l++
}
}
printHtmlPart(20)
}
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1611496323310L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
